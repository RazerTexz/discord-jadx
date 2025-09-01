package com.discord.screenshot_detection;

import android.app.Application;
import android.content.ContentResolver;
import android.content.SharedPreferences;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import b.a.s.ScreenshotContentObserver;
import b.a.s.ScreenshotDetector2;
import b.d.b.a.outline;
import com.discord.utilities.logging.Logger;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import rx.subjects.PublishSubject;

/* compiled from: ScreenshotDetector.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001(B\u001f\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\u001a\u001a\u00020\u0015¢\u0006\u0004\b&\u0010'R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0019\u0010\u001a\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R*\u0010#\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006)"}, d2 = {"Lcom/discord/screenshot_detection/ScreenshotDetector;", "", "Lb/a/s/a;", "d", "Lb/a/s/a;", "activityCallbacks", "Lcom/discord/utilities/logging/Logger;", "f", "Lcom/discord/utilities/logging/Logger;", "getLogger", "()Lcom/discord/utilities/logging/Logger;", "logger", "Lrx/subjects/PublishSubject;", "Lcom/discord/screenshot_detection/ScreenshotDetector$Screenshot;", "b", "Lrx/subjects/PublishSubject;", "publishSubject", "Lb/a/s/b;", "c", "Lb/a/s/b;", "screenshotContentObserver", "Landroid/content/SharedPreferences;", "g", "Landroid/content/SharedPreferences;", "getCache", "()Landroid/content/SharedPreferences;", "cache", "", "value", "e", "Z", "getEnabled", "()Z", "a", "(Z)V", "enabled", "Landroid/app/Application;", "applicationContext", "<init>", "(Landroid/app/Application;Lcom/discord/utilities/logging/Logger;Landroid/content/SharedPreferences;)V", "Screenshot", "screenshot_detection_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class ScreenshotDetector {
    public static ScreenshotDetector a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final PublishSubject<Screenshot> publishSubject;

    /* renamed from: c, reason: from kotlin metadata */
    public final ScreenshotContentObserver screenshotContentObserver;

    /* renamed from: d, reason: from kotlin metadata */
    public final ScreenshotDetector2 activityCallbacks;

    /* renamed from: e, reason: from kotlin metadata */
    public boolean enabled;

    /* renamed from: f, reason: from kotlin metadata */
    public final Logger logger;

    /* renamed from: g, reason: from kotlin metadata */
    public final SharedPreferences cache;

    /* compiled from: ScreenshotDetector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0011\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0015\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/discord/screenshot_detection/ScreenshotDetector$Screenshot;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/net/Uri;", "a", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "b", "Ljava/lang/String;", "getFilename", "filename", "<init>", "(Landroid/net/Uri;Ljava/lang/String;)V", "screenshot_detection_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Screenshot {

        /* renamed from: a, reason: from kotlin metadata */
        public final Uri uri;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final String filename;

        public Screenshot(Uri uri, String str) {
            Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            Intrinsics3.checkNotNullParameter(str, "filename");
            this.uri = uri;
            this.filename = str;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Screenshot)) {
                return false;
            }
            Screenshot screenshot = (Screenshot) other;
            return Intrinsics3.areEqual(this.uri, screenshot.uri) && Intrinsics3.areEqual(this.filename, screenshot.filename);
        }

        public int hashCode() {
            Uri uri = this.uri;
            int iHashCode = (uri != null ? uri.hashCode() : 0) * 31;
            String str = this.filename;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Screenshot(uri=");
            sbU.append(this.uri);
            sbU.append(", filename=");
            return outline.J(sbU, this.filename, ")");
        }
    }

    /* compiled from: ScreenshotDetector.kt */
    public static final class a extends Lambda implements Function2<Uri, String, Unit> {
        public a() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Uri uri, String str) {
            Uri uri2 = uri;
            String str2 = str;
            Intrinsics3.checkNotNullParameter(uri2, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            Intrinsics3.checkNotNullParameter(str2, "filename");
            ScreenshotDetector screenshotDetector = ScreenshotDetector.this;
            if (screenshotDetector.enabled) {
                PublishSubject<Screenshot> publishSubject = screenshotDetector.publishSubject;
                publishSubject.k.onNext(new Screenshot(uri2, str2));
            }
            return Unit.a;
        }
    }

    public ScreenshotDetector(Application application, Logger logger, SharedPreferences sharedPreferences) {
        Intrinsics3.checkNotNullParameter(application, "applicationContext");
        Intrinsics3.checkNotNullParameter(logger, "logger");
        Intrinsics3.checkNotNullParameter(sharedPreferences, "cache");
        this.logger = logger;
        this.cache = sharedPreferences;
        PublishSubject<Screenshot> publishSubjectK0 = PublishSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.publishSubject = publishSubjectK0;
        ContentResolver contentResolver = application.getContentResolver();
        Intrinsics3.checkNotNullExpressionValue(contentResolver, "applicationContext.contentResolver");
        ScreenshotContentObserver screenshotContentObserver = new ScreenshotContentObserver(logger, contentResolver, null, new a(), 4);
        this.screenshotContentObserver = screenshotContentObserver;
        ScreenshotDetector2 screenshotDetector2 = new ScreenshotDetector2(screenshotContentObserver);
        this.activityCallbacks = screenshotDetector2;
        a(sharedPreferences.getBoolean("screenshot_detection_enabled", false));
        application.registerActivityLifecycleCallbacks(screenshotDetector2);
        screenshotDetector2.a(this.enabled);
    }

    public final void a(boolean z2) {
        this.enabled = z2;
        SharedPreferences.Editor editorEdit = this.cache.edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putBoolean("screenshot_detection_enabled", z2);
        editorEdit.apply();
        this.activityCallbacks.a(z2);
    }
}
