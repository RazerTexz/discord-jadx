package com.discord.utilities.auth;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelInvite;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: RegistrationFlowRepo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 :2\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b9\u0010\u0004J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J/\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR$\u0010\"\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001a\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR6\u0010&\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b\u0018\u00010%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010,\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010\u001a\u001a\u0004\b-\u0010\u001c\"\u0004\b.\u0010\u001eR\"\u0010/\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010\u001a\u001a\u0004\b0\u0010\u001c\"\u0004\b1\u0010\u001eR$\u00103\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006;"}, d2 = {"Lcom/discord/utilities/auth/RegistrationFlowRepo;", "", "", "clear", "()V", "", "step", "actionType", "", "details", "trackTransition", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "Lcom/discord/models/domain/ModelInvite;", "invite", "Lcom/discord/models/domain/ModelInvite;", "getInvite", "()Lcom/discord/models/domain/ModelInvite;", "setInvite", "(Lcom/discord/models/domain/ModelInvite;)V", "", "isRegistering", "Z", "()Z", "setRegistering", "(Z)V", "username", "Ljava/lang/String;", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", NotificationCompat.CATEGORY_EMAIL, "getEmail", "setEmail", "phoneToken", "getPhoneToken", "setPhoneToken", "", "errors", "Ljava/util/Map;", "getErrors", "()Ljava/util/Map;", "setErrors", "(Ljava/util/Map;)V", "phone", "getPhone", "setPhone", WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD, "getPassword", "setPassword", "", "birthday", "Ljava/lang/Long;", "getBirthday", "()Ljava/lang/Long;", "setBirthday", "(Ljava/lang/Long;)V", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class RegistrationFlowRepo {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = LazyJVM.lazy(RegistrationFlowRepo2.INSTANCE);
    private Long birthday;
    private String email;
    private Map<String, ? extends List<String>> errors;
    private ModelInvite invite;
    private boolean isRegistering;
    private String phone;
    private String phoneToken;
    private String username = "";
    private String password = "";

    /* compiled from: RegistrationFlowRepo.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/discord/utilities/auth/RegistrationFlowRepo$Companion;", "", "Lcom/discord/utilities/auth/RegistrationFlowRepo;", "INSTANCE$delegate", "Lkotlin/Lazy;", "getINSTANCE", "()Lcom/discord/utilities/auth/RegistrationFlowRepo;", "INSTANCE", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final RegistrationFlowRepo getINSTANCE() {
            Lazy lazyAccess$getINSTANCE$cp = RegistrationFlowRepo.access$getINSTANCE$cp();
            Companion companion = RegistrationFlowRepo.INSTANCE;
            return (RegistrationFlowRepo) lazyAccess$getINSTANCE$cp.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void trackTransition$default(RegistrationFlowRepo registrationFlowRepo, String str, String str2, List list, int i, Object obj) {
        if ((i & 4) != 0) {
            list = null;
        }
        registrationFlowRepo.trackTransition(str, str2, list);
    }

    public final void clear() {
        this.email = null;
        this.phone = null;
        this.phoneToken = null;
        this.username = "";
        this.password = "";
        this.birthday = null;
        this.errors = null;
    }

    public final Long getBirthday() {
        return this.birthday;
    }

    public final String getEmail() {
        return this.email;
    }

    public final Map<String, List<String>> getErrors() {
        return this.errors;
    }

    public final ModelInvite getInvite() {
        return this.invite;
    }

    public final String getPassword() {
        return this.password;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getPhoneToken() {
        return this.phoneToken;
    }

    public final String getUsername() {
        return this.username;
    }

    /* renamed from: isRegistering, reason: from getter */
    public final boolean getIsRegistering() {
        return this.isRegistering;
    }

    public final void setBirthday(Long l) {
        this.birthday = l;
    }

    public final void setEmail(String str) {
        this.email = str;
    }

    public final void setErrors(Map<String, ? extends List<String>> map) {
        this.errors = map;
    }

    public final void setInvite(ModelInvite modelInvite) {
        this.invite = modelInvite;
    }

    public final void setPassword(String str) {
        Intrinsics3.checkNotNullParameter(str, "<set-?>");
        this.password = str;
    }

    public final void setPhone(String str) {
        this.phone = str;
    }

    public final void setPhoneToken(String str) {
        this.phoneToken = str;
    }

    public final void setRegistering(boolean z2) {
        this.isRegistering = z2;
    }

    public final void setUsername(String str) {
        Intrinsics3.checkNotNullParameter(str, "<set-?>");
        this.username = str;
    }

    public final void trackTransition(String step, String actionType, List<String> details) {
        Intrinsics3.checkNotNullParameter(step, "step");
        Intrinsics3.checkNotNullParameter(actionType, "actionType");
        if (this.isRegistering) {
            AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
            Map<String, Object> mapModelInviteToProperties = analyticsTracker.modelInviteToProperties(this.invite, new LinkedHashMap());
            if (this.invite != null) {
                mapModelInviteToProperties.put("registration_source", "invite");
            }
            String str = null;
            if (this.email != null) {
                str = NotificationCompat.CATEGORY_EMAIL;
            } else if (this.phone != null) {
                str = "phone";
            }
            analyticsTracker.registerTransition(step, actionType, str, details, mapModelInviteToProperties);
        }
    }
}
