package com.discord.utilities.captcha;

import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import b.i.d.FieldNamingPolicy;
import b.i.d.GsonBuilder;
import com.discord.app.AppLog;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CaptchaErrorBody.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0001'B?\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b%\u0010&J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007JR\u0010\u0012\u001a\u00020\u00002\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0007J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\u001f\u0010\u0007R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b!\u0010\nR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\"\u0010\u0007R!\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010#\u001a\u0004\b$\u0010\u0005¨\u0006("}, d2 = {"Lcom/discord/utilities/captcha/CaptchaErrorBody;", "Ljava/io/Serializable;", "", "", "component1", "()Ljava/util/List;", "component2", "()Ljava/lang/String;", "Lcom/discord/utilities/captcha/CaptchaService;", "component3", "()Lcom/discord/utilities/captcha/CaptchaService;", "component4", "component5", "captchaKey", "captchaSitekey", "captchaService", "captchaRqdata", "captchaRqtoken", "copy", "(Ljava/util/List;Ljava/lang/String;Lcom/discord/utilities/captcha/CaptchaService;Ljava/lang/String;Ljava/lang/String;)Lcom/discord/utilities/captcha/CaptchaErrorBody;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCaptchaRqtoken", "getCaptchaRqdata", "Lcom/discord/utilities/captcha/CaptchaService;", "getCaptchaService", "getCaptchaSitekey", "Ljava/util/List;", "getCaptchaKey", "<init>", "(Ljava/util/List;Ljava/lang/String;Lcom/discord/utilities/captcha/CaptchaService;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class CaptchaErrorBody implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<String> captchaKey;
    private final String captchaRqdata;
    private final String captchaRqtoken;
    private final CaptchaService captchaService;
    private final String captchaSitekey;

    /* compiled from: CaptchaErrorBody.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/discord/utilities/captcha/CaptchaErrorBody$Companion;", "", "Lcom/discord/utilities/error/Error;", "error", "Lcom/discord/utilities/captcha/CaptchaErrorBody;", "createFromError", "(Lcom/discord/utilities/error/Error;)Lcom/discord/utilities/captcha/CaptchaErrorBody;", "", "errorString", "createFromString", "(Ljava/lang/String;)Lcom/discord/utilities/captcha/CaptchaErrorBody;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final CaptchaErrorBody createFromError(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            String bodyText = error.getBodyText();
            if (bodyText == null) {
                return null;
            }
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.c = FieldNamingPolicy.m;
            try {
                return (CaptchaErrorBody) f.E1(CaptchaErrorBody.class).cast(gsonBuilder.a().g(bodyText, CaptchaErrorBody.class));
            } catch (Exception e) {
                Logger.e$default(AppLog.g, "failed to parse captcha error body", e, null, 4, null);
                return null;
            }
        }

        public final CaptchaErrorBody createFromString(String errorString) {
            Intrinsics3.checkNotNullParameter(errorString, "errorString");
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.c = FieldNamingPolicy.m;
            try {
                return (CaptchaErrorBody) f.E1(CaptchaErrorBody.class).cast(gsonBuilder.a().g(errorString, CaptchaErrorBody.class));
            } catch (Exception e) {
                Logger.e$default(AppLog.g, "failed to parse captcha error body", e, null, 4, null);
                return null;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CaptchaErrorBody(List<String> list, String str, CaptchaService captchaService, String str2, String str3) {
        this.captchaKey = list;
        this.captchaSitekey = str;
        this.captchaService = captchaService;
        this.captchaRqdata = str2;
        this.captchaRqtoken = str3;
    }

    public static /* synthetic */ CaptchaErrorBody copy$default(CaptchaErrorBody captchaErrorBody, List list, String str, CaptchaService captchaService, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = captchaErrorBody.captchaKey;
        }
        if ((i & 2) != 0) {
            str = captchaErrorBody.captchaSitekey;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            captchaService = captchaErrorBody.captchaService;
        }
        CaptchaService captchaService2 = captchaService;
        if ((i & 8) != 0) {
            str2 = captchaErrorBody.captchaRqdata;
        }
        String str5 = str2;
        if ((i & 16) != 0) {
            str3 = captchaErrorBody.captchaRqtoken;
        }
        return captchaErrorBody.copy(list, str4, captchaService2, str5, str3);
    }

    public final List<String> component1() {
        return this.captchaKey;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCaptchaSitekey() {
        return this.captchaSitekey;
    }

    /* renamed from: component3, reason: from getter */
    public final CaptchaService getCaptchaService() {
        return this.captchaService;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCaptchaRqdata() {
        return this.captchaRqdata;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCaptchaRqtoken() {
        return this.captchaRqtoken;
    }

    public final CaptchaErrorBody copy(List<String> captchaKey, String captchaSitekey, CaptchaService captchaService, String captchaRqdata, String captchaRqtoken) {
        return new CaptchaErrorBody(captchaKey, captchaSitekey, captchaService, captchaRqdata, captchaRqtoken);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CaptchaErrorBody)) {
            return false;
        }
        CaptchaErrorBody captchaErrorBody = (CaptchaErrorBody) other;
        return Intrinsics3.areEqual(this.captchaKey, captchaErrorBody.captchaKey) && Intrinsics3.areEqual(this.captchaSitekey, captchaErrorBody.captchaSitekey) && Intrinsics3.areEqual(this.captchaService, captchaErrorBody.captchaService) && Intrinsics3.areEqual(this.captchaRqdata, captchaErrorBody.captchaRqdata) && Intrinsics3.areEqual(this.captchaRqtoken, captchaErrorBody.captchaRqtoken);
    }

    public final List<String> getCaptchaKey() {
        return this.captchaKey;
    }

    public final String getCaptchaRqdata() {
        return this.captchaRqdata;
    }

    public final String getCaptchaRqtoken() {
        return this.captchaRqtoken;
    }

    public final CaptchaService getCaptchaService() {
        return this.captchaService;
    }

    public final String getCaptchaSitekey() {
        return this.captchaSitekey;
    }

    public int hashCode() {
        List<String> list = this.captchaKey;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.captchaSitekey;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        CaptchaService captchaService = this.captchaService;
        int iHashCode3 = (iHashCode2 + (captchaService != null ? captchaService.hashCode() : 0)) * 31;
        String str2 = this.captchaRqdata;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.captchaRqtoken;
        return iHashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("CaptchaErrorBody(captchaKey=");
        sbU.append(this.captchaKey);
        sbU.append(", captchaSitekey=");
        sbU.append(this.captchaSitekey);
        sbU.append(", captchaService=");
        sbU.append(this.captchaService);
        sbU.append(", captchaRqdata=");
        sbU.append(this.captchaRqdata);
        sbU.append(", captchaRqtoken=");
        return outline.J(sbU, this.captchaRqtoken, ")");
    }
}
