package com.adjust.sdk;

import android.content.Context;
import com.adjust.sdk.scheduler.SingleThreadCachedScheduler;
import com.adjust.sdk.scheduler.ThreadScheduler;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class PackageHandler implements IPackageHandler {
    private static final String PACKAGE_QUEUE_FILENAME = "AdjustIoPackageQueue";
    private static final String PACKAGE_QUEUE_NAME = "Package queue";
    private WeakReference<IActivityHandler> activityHandlerWeakRef;
    private String basePath;
    private Context context;
    private String gdprPath;
    private AtomicBoolean isSending;
    private List<ActivityPackage> packageQueue;
    private boolean paused;
    private IRequestHandler requestHandler;
    private String subscriptionPath;
    private ThreadScheduler scheduler = new SingleThreadCachedScheduler("PackageHandler");
    private ILogger logger = AdjustFactory.getLogger();
    private BackoffStrategy backoffStrategy = AdjustFactory.getPackageHandlerBackoffStrategy();
    private BackoffStrategy backoffStrategyForInstallSession = AdjustFactory.getInstallSessionBackoffStrategy();

    /* renamed from: com.adjust.sdk.PackageHandler$1, reason: invalid class name */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PackageHandler.access$000(PackageHandler.this);
        }
    }

    /* renamed from: com.adjust.sdk.PackageHandler$2, reason: invalid class name */
    public class AnonymousClass2 implements Runnable {
        public final /* synthetic */ ActivityPackage val$activityPackage;

        public AnonymousClass2(ActivityPackage activityPackage) {
            this.val$activityPackage = activityPackage;
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            PackageHandler.access$100(PackageHandler.this, this.val$activityPackage);
        }
    }

    /* renamed from: com.adjust.sdk.PackageHandler$3, reason: invalid class name */
    public class AnonymousClass3 implements Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PackageHandler.access$200(PackageHandler.this);
        }
    }

    /* renamed from: com.adjust.sdk.PackageHandler$4, reason: invalid class name */
    public class AnonymousClass4 implements Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            PackageHandler.access$300(PackageHandler.this);
        }
    }

    /* renamed from: com.adjust.sdk.PackageHandler$5, reason: invalid class name */
    public class AnonymousClass5 implements Runnable {
        public AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PackageHandler.access$400(PackageHandler.this).verbose("Package handler can send", new Object[0]);
            PackageHandler.access$500(PackageHandler.this).set(false);
            PackageHandler.this.sendFirstPackage();
        }
    }

    /* renamed from: com.adjust.sdk.PackageHandler$6, reason: invalid class name */
    public class AnonymousClass6 implements Runnable {
        public final /* synthetic */ SessionParameters val$sessionParametersCopy;

        public AnonymousClass6(SessionParameters sessionParameters) {
            this.val$sessionParametersCopy = sessionParameters;
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            PackageHandler.this.updatePackagesI(this.val$sessionParametersCopy);
        }
    }

    /* renamed from: com.adjust.sdk.PackageHandler$7, reason: invalid class name */
    public class AnonymousClass7 implements Runnable {
        public AnonymousClass7() {
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            PackageHandler.access$600(PackageHandler.this);
        }
    }

    public PackageHandler(IActivityHandler iActivityHandler, Context context, boolean z2) {
        init(iActivityHandler, context, z2);
        this.scheduler.submit(new AnonymousClass1());
    }

    public static /* synthetic */ void access$000(PackageHandler packageHandler) {
        packageHandler.initI();
    }

    public static /* synthetic */ void access$100(PackageHandler packageHandler, ActivityPackage activityPackage) throws IOException {
        packageHandler.addI(activityPackage);
    }

    public static /* synthetic */ void access$200(PackageHandler packageHandler) {
        packageHandler.sendFirstI();
    }

    public static /* synthetic */ void access$300(PackageHandler packageHandler) throws IOException {
        packageHandler.sendNextI();
    }

    public static /* synthetic */ ILogger access$400(PackageHandler packageHandler) {
        return packageHandler.logger;
    }

    public static /* synthetic */ AtomicBoolean access$500(PackageHandler packageHandler) {
        return packageHandler.isSending;
    }

    public static /* synthetic */ void access$600(PackageHandler packageHandler) throws IOException {
        packageHandler.flushI();
    }

    private void addI(ActivityPackage activityPackage) throws IOException {
        this.packageQueue.add(activityPackage);
        this.logger.debug("Added package %d (%s)", Integer.valueOf(this.packageQueue.size()), activityPackage);
        this.logger.verbose("%s", activityPackage.getExtendedString());
        writePackageQueueI();
    }

    public static Boolean deletePackageQueue(Context context) {
        return Boolean.valueOf(context.deleteFile(PACKAGE_QUEUE_FILENAME));
    }

    public static void deleteState(Context context) {
        deletePackageQueue(context);
    }

    private void flushI() throws IOException {
        this.packageQueue.clear();
        writePackageQueueI();
    }

    private void initI() {
        this.requestHandler = AdjustFactory.getRequestHandler(this.activityHandlerWeakRef.get(), this);
        this.isSending = new AtomicBoolean();
        readPackageQueueI();
    }

    private void readPackageQueueI() {
        try {
            this.packageQueue = (List) Util.readObject(this.context, PACKAGE_QUEUE_FILENAME, PACKAGE_QUEUE_NAME, List.class);
        } catch (Exception e) {
            this.logger.error("Failed to read %s file (%s)", PACKAGE_QUEUE_NAME, e.getMessage());
            this.packageQueue = null;
        }
        List<ActivityPackage> list = this.packageQueue;
        if (list != null) {
            this.logger.debug("Package handler read %d packages", Integer.valueOf(list.size()));
        } else {
            this.packageQueue = new ArrayList();
        }
    }

    private void sendFirstI() {
        if (this.packageQueue.isEmpty()) {
            return;
        }
        if (this.paused) {
            this.logger.debug("Package handler is paused", new Object[0]);
        } else if (this.isSending.getAndSet(true)) {
            this.logger.verbose("Package handler is already sending", new Object[0]);
        } else {
            this.requestHandler.sendPackage(this.packageQueue.get(0), this.packageQueue.size() - 1);
        }
    }

    private void sendNextI() throws IOException {
        if (this.packageQueue.isEmpty()) {
            return;
        }
        this.packageQueue.remove(0);
        writePackageQueueI();
        this.isSending.set(false);
        this.logger.verbose("Package handler can send", new Object[0]);
        sendFirstI();
    }

    private void writePackageQueueI() throws IOException {
        Util.writeObject(this.packageQueue, this.context, PACKAGE_QUEUE_FILENAME, PACKAGE_QUEUE_NAME);
        this.logger.debug("Package handler wrote %d packages", Integer.valueOf(this.packageQueue.size()));
    }

    @Override // com.adjust.sdk.IPackageHandler
    public void addPackage(ActivityPackage activityPackage) {
        this.scheduler.submit(new AnonymousClass2(activityPackage));
    }

    @Override // com.adjust.sdk.IPackageHandler
    public void closeFirstPackage(ResponseData responseData, ActivityPackage activityPackage) {
        responseData.willRetry = true;
        IActivityHandler iActivityHandler = this.activityHandlerWeakRef.get();
        if (iActivityHandler != null) {
            iActivityHandler.finishedTrackingActivity(responseData);
        }
        AnonymousClass5 anonymousClass5 = new AnonymousClass5();
        if (activityPackage == null) {
            anonymousClass5.run();
            return;
        }
        int iIncreaseRetries = activityPackage.increaseRetries();
        long waitingTime = (activityPackage.getActivityKind() != ActivityKind.SESSION || new SharedPreferencesManager(this.context).getInstallTracked()) ? Util.getWaitingTime(iIncreaseRetries, this.backoffStrategy) : Util.getWaitingTime(iIncreaseRetries, this.backoffStrategyForInstallSession);
        this.logger.verbose("Waiting for %s seconds before retrying the %d time", Util.SecondsDisplayFormat.format(waitingTime / 1000.0d), Integer.valueOf(iIncreaseRetries));
        this.scheduler.schedule(anonymousClass5, waitingTime);
    }

    @Override // com.adjust.sdk.IPackageHandler
    public void flush() {
        this.scheduler.submit(new AnonymousClass7());
    }

    @Override // com.adjust.sdk.IPackageHandler
    public String getBasePath() {
        return this.basePath;
    }

    @Override // com.adjust.sdk.IPackageHandler
    public String getGdprPath() {
        return this.gdprPath;
    }

    @Override // com.adjust.sdk.IPackageHandler
    public String getSubscriptionPath() {
        return this.subscriptionPath;
    }

    @Override // com.adjust.sdk.IPackageHandler
    public void init(IActivityHandler iActivityHandler, Context context, boolean z2) {
        this.activityHandlerWeakRef = new WeakReference<>(iActivityHandler);
        this.context = context;
        this.paused = !z2;
        this.basePath = iActivityHandler.getBasePath();
        this.gdprPath = iActivityHandler.getGdprPath();
        this.subscriptionPath = iActivityHandler.getSubscriptionPath();
    }

    @Override // com.adjust.sdk.IPackageHandler
    public void pauseSending() {
        this.paused = true;
    }

    @Override // com.adjust.sdk.IPackageHandler
    public void resumeSending() {
        this.paused = false;
    }

    @Override // com.adjust.sdk.IPackageHandler
    public void sendFirstPackage() {
        this.scheduler.submit(new AnonymousClass3());
    }

    @Override // com.adjust.sdk.IPackageHandler
    public void sendNextPackage(ResponseData responseData) {
        this.scheduler.submit(new AnonymousClass4());
        IActivityHandler iActivityHandler = this.activityHandlerWeakRef.get();
        if (iActivityHandler != null) {
            iActivityHandler.finishedTrackingActivity(responseData);
        }
    }

    @Override // com.adjust.sdk.IPackageHandler
    public void teardown() {
        this.logger.verbose("PackageHandler teardown", new Object[0]);
        ThreadScheduler threadScheduler = this.scheduler;
        if (threadScheduler != null) {
            threadScheduler.teardown();
        }
        WeakReference<IActivityHandler> weakReference = this.activityHandlerWeakRef;
        if (weakReference != null) {
            weakReference.clear();
        }
        IRequestHandler iRequestHandler = this.requestHandler;
        if (iRequestHandler != null) {
            iRequestHandler.teardown();
        }
        List<ActivityPackage> list = this.packageQueue;
        if (list != null) {
            list.clear();
        }
        this.scheduler = null;
        this.requestHandler = null;
        this.activityHandlerWeakRef = null;
        this.packageQueue = null;
        this.isSending = null;
        this.context = null;
        this.logger = null;
        this.backoffStrategy = null;
    }

    @Override // com.adjust.sdk.IPackageHandler
    public void updatePackages(SessionParameters sessionParameters) {
        this.scheduler.submit(new AnonymousClass6(sessionParameters != null ? sessionParameters.deepCopy() : null));
    }

    public void updatePackagesI(SessionParameters sessionParameters) throws IOException {
        if (sessionParameters == null) {
            return;
        }
        this.logger.debug("Updating package handler queue", new Object[0]);
        this.logger.verbose("Session callback parameters: %s", sessionParameters.callbackParameters);
        this.logger.verbose("Session partner parameters: %s", sessionParameters.partnerParameters);
        for (ActivityPackage activityPackage : this.packageQueue) {
            Map<String, String> parameters = activityPackage.getParameters();
            PackageBuilder.addMapJson(parameters, Constants.CALLBACK_PARAMETERS, Util.mergeParameters(sessionParameters.callbackParameters, activityPackage.getCallbackParameters(), "Callback"));
            PackageBuilder.addMapJson(parameters, Constants.PARTNER_PARAMETERS, Util.mergeParameters(sessionParameters.partnerParameters, activityPackage.getPartnerParameters(), "Partner"));
        }
        writePackageQueueI();
    }
}
