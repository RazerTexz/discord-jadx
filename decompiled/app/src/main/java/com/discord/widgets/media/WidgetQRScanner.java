package com.discord.widgets.media;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.view.View;
import android.webkit.URLUtil;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.m0.RoutingPatterns;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetQrScannerBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.auth.WidgetRemoteAuth;
import com.google.android.material.chip.Chip;
import com.google.zxing.Result;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import e0.a.a.a.CameraHandlerThread;
import e0.a.a.a.CameraHandlerThread2;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

/* compiled from: WidgetQRScanner.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0018B\u0007¢\u0006\u0004\b\u0017\u0010\tJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0004\u001a\u00020\u00038B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/discord/widgets/media/WidgetQRScanner;", "Lcom/discord/app/AppFragment;", "Lme/dm7/barcodescanner/zxing/ZXingScannerView$b;", "Lcom/discord/databinding/WidgetQrScannerBinding;", "binding", "", "onViewBindingDestroy", "(Lcom/discord/databinding/WidgetQrScannerBinding;)V", "onViewBoundOrOnResume", "()V", "onPause", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "Lcom/google/zxing/Result;", "rawResult", "handleResult", "(Lcom/google/zxing/Result;)V", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetQrScannerBinding;", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetQRScanner extends AppFragment implements ZXingScannerView.b {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetQRScanner.class, "binding", "getBinding()Lcom/discord/databinding/WidgetQrScannerBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_SHOW_HELP_CHIP = "SHOW_HELP_CHIP";
    private static final int MAIN_BACK_CAMERA = 0;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetQRScanner.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/media/WidgetQRScanner$Companion;", "", "Landroid/content/Context;", "context", "", "showHelpChip", "", "launch", "(Landroid/content/Context;Z)V", "", "EXTRA_SHOW_HELP_CHIP", "Ljava/lang/String;", "", "MAIN_BACK_CAMERA", "I", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, boolean z2, int i, Object obj) {
            if ((i & 2) != 0) {
                z2 = false;
            }
            companion.launch(context, z2);
        }

        public final void launch(Context context, boolean showHelpChip) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent("android.intent.action.VIEW").putExtra(WidgetQRScanner.EXTRA_SHOW_HELP_CHIP, showHelpChip);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent(Intent.ACTION_VIE…_HELP_CHIP, showHelpChip)");
            AppScreen2.d(context, WidgetQRScanner.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetQRScanner.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.media.WidgetQRScanner$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ZXingScannerView zXingScannerView = WidgetQRScanner.access$getBinding$p(WidgetQRScanner.this).f2515b;
            if (zXingScannerView.n == null) {
                zXingScannerView.n = new CameraHandlerThread2(zXingScannerView);
            }
            CameraHandlerThread2 cameraHandlerThread2 = zXingScannerView.n;
            Objects.requireNonNull(cameraHandlerThread2);
            new Handler(cameraHandlerThread2.getLooper()).post(new CameraHandlerThread(cameraHandlerThread2, 0));
        }
    }

    /* compiled from: WidgetQRScanner.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.media.WidgetQRScanner$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            AppActivity appActivity = WidgetQRScanner.this.getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
            }
        }
    }

    public WidgetQRScanner() {
        super(R.layout.widget_qr_scanner);
        this.binding = FragmentViewBindingDelegate3.viewBinding(this, WidgetQRScanner2.INSTANCE, new WidgetQRScanner3(this));
    }

    public static final /* synthetic */ WidgetQrScannerBinding access$getBinding$p(WidgetQRScanner widgetQRScanner) {
        return widgetQRScanner.getBinding();
    }

    public static final /* synthetic */ void access$onViewBindingDestroy(WidgetQRScanner widgetQRScanner, WidgetQrScannerBinding widgetQrScannerBinding) {
        widgetQRScanner.onViewBindingDestroy(widgetQrScannerBinding);
    }

    private final WidgetQrScannerBinding getBinding() {
        return (WidgetQrScannerBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void onViewBindingDestroy(WidgetQrScannerBinding binding) {
        binding.f2515b.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
    @Override // me.dm7.barcodescanner.zxing.ZXingScannerView.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleResult(Result rawResult) {
        String str;
        MatchResult matchResultMatchEntire;
        if (rawResult == null || (str = rawResult.a) == null) {
            return;
        }
        Uri uri = Uri.parse(str);
        if (URLUtil.isValidUrl(str)) {
            RoutingPatterns routingPatterns = RoutingPatterns.G;
            Intrinsics3.checkNotNullExpressionValue(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            if (!routingPatterns.a(uri.getHost())) {
                IntentUtils intentUtils = IntentUtils.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
                if (intentUtils.isDiscordAppUri(uri)) {
                    String path = uri.getPath();
                    if (path != null) {
                        RoutingPatterns routingPatterns2 = RoutingPatterns.G;
                        Regex regex = RoutingPatterns.D;
                        Intrinsics3.checkNotNullExpressionValue(path, "it");
                        matchResultMatchEntire = regex.matchEntire(path);
                    } else {
                        matchResultMatchEntire = null;
                    }
                    if (matchResultMatchEntire != null) {
                        WidgetRemoteAuth.INSTANCE.launch(requireContext(), (String) _Collections.last((List) matchResultMatchEntire.getGroupValues()));
                    } else {
                        UriHandler.handle$default(UriHandler.INSTANCE, requireContext(), str, false, false, null, 28, null);
                    }
                } else {
                    AppToast.i(this, R.string.qr_code_invalid, 0, 4);
                }
            }
        }
        requireActivity().finish();
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        getBinding().f2515b.a();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f2515b.setFormats(ZXingScannerView.D);
        getBinding().f2515b.setResultHandler(this);
        ZXingScannerView zXingScannerView = getBinding().f2515b;
        Intrinsics3.checkNotNullExpressionValue(zXingScannerView, "binding.qrScanner");
        zXingScannerView.setVisibility(0);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ColorCompat.setStatusBarColor$default((Fragment) this, ColorCompat.getColor(this, R.color.black), false, 4, (Object) null);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(R.string.login_with_qr);
        boolean booleanExtra = getMostRecentIntent().getBooleanExtra(EXTRA_SHOW_HELP_CHIP, false);
        Chip chip = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(chip, "binding.qrScannerChip");
        chip.setVisibility(booleanExtra ? 0 : 8);
        requestCameraQRScanner(new AnonymousClass1(), new AnonymousClass2());
    }
}
