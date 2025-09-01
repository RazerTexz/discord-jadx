package com.discord.utilities.surveys;

import android.app.Application;
import android.content.pm.PackageManager;
import androidx.core.app.NotificationCompat;
import com.discord.api.user.UserSurvey;
import com.discord.stores.StoreStream;
import com.discord.utilities.time.ClockFactory;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Metadata;
import rx.Observable;

/* compiled from: SurveyUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0006\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/discord/utilities/surveys/SurveyUtils;", "", "", "isInstallOldEnough", "()Z", "Landroid/app/Application;", "applicationContext", "", "init", "(Landroid/app/Application;)V", "Lrx/Observable;", "Lcom/discord/utilities/surveys/SurveyUtils$Survey;", "getSurveyToShow", "()Lrx/Observable;", "Landroid/app/Application;", "", "MIN_APP_INSTALL_TIME", "J", "<init>", "()V", "Survey", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SurveyUtils {
    public static final SurveyUtils INSTANCE = new SurveyUtils();
    private static final long MIN_APP_INSTALL_TIME = 604800000;
    private static Application applicationContext;

    /* compiled from: SurveyUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0012B3\u0012\n\u0010\u000e\u001a\u00060\u0002j\u0002`\r\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R \u0010\u000e\u001a\u00060\u0002j\u0002`\r8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/discord/utilities/surveys/SurveyUtils$Survey;", "", "", "surveyTitle", "Ljava/lang/String;", "getSurveyTitle", "()Ljava/lang/String;", "surveyURL", "getSurveyURL", "surveyBody", "getSurveyBody", "noticeKey", "getNoticeKey", "Lcom/discord/primitives/SurveyId;", "surveyId", "getSurveyId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "None", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static class Survey {
        private final String noticeKey;
        private final String surveyBody;
        private final String surveyId;
        private final String surveyTitle;
        private final String surveyURL;

        /* compiled from: SurveyUtils.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/utilities/surveys/SurveyUtils$Survey$None;", "Lcom/discord/utilities/surveys/SurveyUtils$Survey;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class None extends Survey {
            public static final None INSTANCE = new None();

            private None() {
                super("", "", "", "", "");
            }
        }

        public Survey(String str, String str2, String str3, String str4, String str5) {
            Intrinsics3.checkNotNullParameter(str, "surveyId");
            Intrinsics3.checkNotNullParameter(str2, "surveyURL");
            Intrinsics3.checkNotNullParameter(str3, "noticeKey");
            Intrinsics3.checkNotNullParameter(str4, "surveyBody");
            Intrinsics3.checkNotNullParameter(str5, "surveyTitle");
            this.surveyId = str;
            this.surveyURL = str2;
            this.noticeKey = str3;
            this.surveyBody = str4;
            this.surveyTitle = str5;
        }

        public String getNoticeKey() {
            return this.noticeKey;
        }

        public String getSurveyBody() {
            return this.surveyBody;
        }

        public String getSurveyId() {
            return this.surveyId;
        }

        public String getSurveyTitle() {
            return this.surveyTitle;
        }

        public String getSurveyURL() {
            return this.surveyURL;
        }
    }

    /* compiled from: SurveyUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/user/UserSurvey;", "it", "Lcom/discord/utilities/surveys/SurveyUtils$Survey;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/user/UserSurvey;)Lcom/discord/utilities/surveys/SurveyUtils$Survey;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.surveys.SurveyUtils$getSurveyToShow$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<UserSurvey, Survey> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Survey call(UserSurvey userSurvey) {
            return call2(userSurvey);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Survey call2(UserSurvey userSurvey) {
            if (userSurvey != null) {
                return new Survey(userSurvey.getKey(), userSurvey.getUrl(), userSurvey.getKey(), userSurvey.getPrompt(), userSurvey.getCta());
            }
            return null;
        }
    }

    private SurveyUtils() {
    }

    private final boolean isInstallOldEnough() {
        try {
            Application application = applicationContext;
            if (application == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("applicationContext");
            }
            PackageManager packageManager = application.getPackageManager();
            Application application2 = applicationContext;
            if (application2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("applicationContext");
            }
            return ClockFactory.get().currentTimeMillis() - packageManager.getPackageInfo(application2.getPackageName(), 0).firstInstallTime >= MIN_APP_INSTALL_TIME;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public final Observable<Survey> getSurveyToShow() {
        if (isInstallOldEnough()) {
            Observable observableG = StoreStream.INSTANCE.getUserSurvey().observeUserSurvey().G(AnonymousClass1.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableG, "StoreStream\n        .get…  )\n          }\n        }");
            return observableG;
        }
        ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(Survey.None.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(Survey.None)");
        return scalarSynchronousObservable;
    }

    public final void init(Application applicationContext2) {
        Intrinsics3.checkNotNullParameter(applicationContext2, "applicationContext");
        applicationContext = applicationContext2;
    }
}
