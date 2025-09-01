package com.discord.models.commands;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.user.User;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Application.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b!\b\u0086\b\u0018\u0000 12\u00020\u0001:\u00011BM\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0011¢\u0006\u0004\b/\u00100J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\\\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0018\u001a\u00020\t2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u0011HÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0007J\u0010\u0010\u001e\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001e\u0010\rJ\u001a\u0010 \u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\"\u001a\u0004\b#\u0010\u0007R\u0019\u0010\u0018\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010$\u001a\u0004\b%\u0010\rR\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010&\u001a\u0004\b'\u0010\u0010R\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b)\u0010\u0004R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010*\u001a\u0004\b+\u0010\u000bR\u0019\u0010\u0015\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\"\u001a\u0004\b,\u0010\u0007R\u0019\u0010\u001a\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010-\u001a\u0004\b.\u0010\u0013¨\u00062"}, d2 = {"Lcom/discord/models/commands/Application;", "", "", "component1", "()J", "", "component2", "()Ljava/lang/String;", "component3", "", "component4", "()Ljava/lang/Integer;", "component5", "()I", "Lcom/discord/api/user/User;", "component6", "()Lcom/discord/api/user/User;", "", "component7", "()Z", ModelAuditLogEntry.CHANGE_KEY_ID, ModelAuditLogEntry.CHANGE_KEY_NAME, "icon", "iconRes", "commandCount", "bot", "builtIn", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ILcom/discord/api/user/User;Z)Lcom/discord/models/commands/Application;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getIcon", "I", "getCommandCount", "Lcom/discord/api/user/User;", "getBot", "J", "getId", "Ljava/lang/Integer;", "getIconRes", "getName", "Z", "getBuiltIn", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ILcom/discord/api/user/User;Z)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class Application {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final User bot;
    private final boolean builtIn;
    private final int commandCount;
    private final String icon;
    private final Integer iconRes;
    private final long id;
    private final String name;

    /* compiled from: Application.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/models/commands/Application$Companion;", "", "Lcom/discord/api/application/Application;", "apiApplication", "Lcom/discord/models/commands/Application;", "fromApiApplication", "(Lcom/discord/api/application/Application;)Lcom/discord/models/commands/Application;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final Application fromApiApplication(com.discord.api.application.Application apiApplication) {
            Intrinsics3.checkNotNullParameter(apiApplication, "apiApplication");
            return new Application(apiApplication.getId(), apiApplication.getName(), apiApplication.getIcon(), null, 0, null, false, 104, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Application(long j, String str, String str2, Integer num, int i, User user, boolean z2) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.id = j;
        this.name = str;
        this.icon = str2;
        this.iconRes = num;
        this.commandCount = i;
        this.bot = user;
        this.builtIn = z2;
    }

    public static /* synthetic */ Application copy$default(Application application, long j, String str, String str2, Integer num, int i, User user, boolean z2, int i2, Object obj) {
        return application.copy((i2 & 1) != 0 ? application.id : j, (i2 & 2) != 0 ? application.name : str, (i2 & 4) != 0 ? application.icon : str2, (i2 & 8) != 0 ? application.iconRes : num, (i2 & 16) != 0 ? application.commandCount : i, (i2 & 32) != 0 ? application.bot : user, (i2 & 64) != 0 ? application.builtIn : z2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getIconRes() {
        return this.iconRes;
    }

    /* renamed from: component5, reason: from getter */
    public final int getCommandCount() {
        return this.commandCount;
    }

    /* renamed from: component6, reason: from getter */
    public final User getBot() {
        return this.bot;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getBuiltIn() {
        return this.builtIn;
    }

    public final Application copy(long id2, String name, String icon, Integer iconRes, int commandCount, User bot, boolean builtIn) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return new Application(id2, name, icon, iconRes, commandCount, bot, builtIn);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Application)) {
            return false;
        }
        Application application = (Application) other;
        return this.id == application.id && Intrinsics3.areEqual(this.name, application.name) && Intrinsics3.areEqual(this.icon, application.icon) && Intrinsics3.areEqual(this.iconRes, application.iconRes) && this.commandCount == application.commandCount && Intrinsics3.areEqual(this.bot, application.bot) && this.builtIn == application.builtIn;
    }

    public final User getBot() {
        return this.bot;
    }

    public final boolean getBuiltIn() {
        return this.builtIn;
    }

    public final int getCommandCount() {
        return this.commandCount;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final Integer getIconRes() {
        return this.iconRes;
    }

    public final long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iA = b.a(this.id) * 31;
        String str = this.name;
        int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.icon;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.iconRes;
        int iHashCode3 = (((iHashCode2 + (num != null ? num.hashCode() : 0)) * 31) + this.commandCount) * 31;
        User user = this.bot;
        int iHashCode4 = (iHashCode3 + (user != null ? user.hashCode() : 0)) * 31;
        boolean z2 = this.builtIn;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode4 + i;
    }

    public String toString() {
        StringBuilder sbU = outline.U("Application(id=");
        sbU.append(this.id);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", icon=");
        sbU.append(this.icon);
        sbU.append(", iconRes=");
        sbU.append(this.iconRes);
        sbU.append(", commandCount=");
        sbU.append(this.commandCount);
        sbU.append(", bot=");
        sbU.append(this.bot);
        sbU.append(", builtIn=");
        return outline.O(sbU, this.builtIn, ")");
    }

    public /* synthetic */ Application(long j, String str, String str2, Integer num, int i, User user, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : num, i, (i2 & 32) != 0 ? null : user, (i2 & 64) != 0 ? false : z2);
    }
}
