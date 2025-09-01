package com.discord.api.application;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import d0.g0.Strings4;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* compiled from: Application.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0011\u001a\u0004\b\u0014\u0010\u0004R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0004R!\u0010\u0019\u001a\n\u0018\u00010\u0017j\u0004\u0018\u0001`\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u0004R\u001b\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010$\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u0011\u001a\u0004\b%\u0010\u0004R!\u0010'\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\u0007R\u0019\u0010*\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001b\u0010.\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u0011\u001a\u0004\b/\u0010\u0004R\u001b\u00101\u001a\u0004\u0018\u0001008\u0006@\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104¨\u00065"}, d2 = {"Lcom/discord/api/application/Application;", "", "", "a", "()Ljava/lang/String;", "", "d", "()Ljava/util/List;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "splash", "Ljava/lang/String;", "i", "deeplinkUri", "getDeeplinkUri", "icon", "f", "", "Lcom/discord/primitives/GuildId;", "guildId", "Ljava/lang/Long;", "e", "()Ljava/lang/Long;", "coverImage", "b", "Lcom/discord/api/application/Team;", "team", "Lcom/discord/api/application/Team;", "getTeam", "()Lcom/discord/api/application/Team;", ModelAuditLogEntry.CHANGE_KEY_NAME, "h", "Lcom/discord/api/application/ThirdPartySku;", "thirdPartySkus", "Ljava/util/List;", "getThirdPartySkus", ModelAuditLogEntry.CHANGE_KEY_ID, "J", "g", "()J", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "c", "Lcom/discord/api/application/ApplicationType;", "type", "Lcom/discord/api/application/ApplicationType;", "j", "()Lcom/discord/api/application/ApplicationType;", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class Application {
    private final String coverImage;
    private final String deeplinkUri;
    private final String description;
    private final Long guildId;
    private final String icon;
    private final long id;
    private final String name;
    private final String splash;
    private final Team team;
    private final List<ThirdPartySku> thirdPartySkus;
    private final ApplicationType type;

    public final String a() {
        String strRemoveSuffix;
        String strW;
        String str = this.deeplinkUri;
        return (str == null || (strRemoveSuffix = Strings4.removeSuffix(str, AutocompleteViewModel.COMMAND_DISCOVER_TOKEN)) == null || (strW = outline.w(strRemoveSuffix, "/_discord")) == null) ? outline.C(outline.U("dscd"), this.id, "://connect/_discord") : strW;
    }

    /* renamed from: b, reason: from getter */
    public final String getCoverImage() {
        return this.coverImage;
    }

    /* renamed from: c, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final List<String> d() {
        List<ThirdPartySku> list = this.thirdPartySkus;
        if (list == null) {
            return Collections2.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (Intrinsics3.areEqual(((ThirdPartySku) obj).getDistributor(), "google_play")) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String strB = ((ThirdPartySku) it.next()).getSku();
            if (strB != null) {
                arrayList2.add(strB);
            }
        }
        return arrayList2;
    }

    /* renamed from: e, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Application)) {
            return false;
        }
        Application application = (Application) other;
        return this.id == application.id && Intrinsics3.areEqual(this.name, application.name) && Intrinsics3.areEqual(this.description, application.description) && Intrinsics3.areEqual(this.splash, application.splash) && Intrinsics3.areEqual(this.coverImage, application.coverImage) && Intrinsics3.areEqual(this.icon, application.icon) && Intrinsics3.areEqual(this.thirdPartySkus, application.thirdPartySkus) && Intrinsics3.areEqual(this.deeplinkUri, application.deeplinkUri) && Intrinsics3.areEqual(this.type, application.type) && Intrinsics3.areEqual(this.guildId, application.guildId) && Intrinsics3.areEqual(this.team, application.team);
    }

    /* renamed from: f, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: g, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: h, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.name;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.splash;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.coverImage;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.icon;
        int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        List<ThirdPartySku> list = this.thirdPartySkus;
        int iHashCode6 = (iHashCode5 + (list != null ? list.hashCode() : 0)) * 31;
        String str6 = this.deeplinkUri;
        int iHashCode7 = (iHashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        ApplicationType applicationType = this.type;
        int iHashCode8 = (iHashCode7 + (applicationType != null ? applicationType.hashCode() : 0)) * 31;
        Long l = this.guildId;
        int iHashCode9 = (iHashCode8 + (l != null ? l.hashCode() : 0)) * 31;
        Team team = this.team;
        return iHashCode9 + (team != null ? team.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final String getSplash() {
        return this.splash;
    }

    /* renamed from: j, reason: from getter */
    public final ApplicationType getType() {
        return this.type;
    }

    public String toString() {
        StringBuilder sbU = outline.U("Application(id=");
        sbU.append(this.id);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", splash=");
        sbU.append(this.splash);
        sbU.append(", coverImage=");
        sbU.append(this.coverImage);
        sbU.append(", icon=");
        sbU.append(this.icon);
        sbU.append(", thirdPartySkus=");
        sbU.append(this.thirdPartySkus);
        sbU.append(", deeplinkUri=");
        sbU.append(this.deeplinkUri);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", team=");
        sbU.append(this.team);
        sbU.append(")");
        return sbU.toString();
    }
}
