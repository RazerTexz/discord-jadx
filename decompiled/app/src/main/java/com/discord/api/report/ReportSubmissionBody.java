package com.discord.api.report;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.Tuples;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: InAppReportsMenu.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u0000 12\u00020\u0001:\u00011J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR+\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u0019\u0010\u0015\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0013\u001a\u0004\b\u0016\u0010\u0004R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001c\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010 \u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u0019\u001a\u0004\b!\u0010\u001bR\u001b\u0010\"\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u0019\u001a\u0004\b#\u0010\u001bR\u001b\u0010$\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u0019\u001a\u0004\b%\u0010\u001bR#\u0010'\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`&0\r8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0019\u0010+\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u0013\u001a\u0004\b,\u0010\u0004R\u001b\u0010-\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010\u0019\u001a\u0004\b.\u0010\u001bR\u0019\u0010/\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010\u0013\u001a\u0004\b0\u0010\u0004¨\u00062"}, d2 = {"Lcom/discord/api/report/ReportSubmissionBody;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "", "elements", "Ljava/util/Map;", "getElements", "()Ljava/util/Map;", "variant", "Ljava/lang/String;", "getVariant", ModelAuditLogEntry.CHANGE_KEY_NAME, "getName", "", "guildScheduledEventId", "Ljava/lang/Long;", "getGuildScheduledEventId", "()Ljava/lang/Long;", ModelAuditLogEntry.CHANGE_KEY_ID, "J", "getId", "()J", "guildId", "getGuildId", "messageId", "getMessageId", "hubId", "getHubId", "Lcom/discord/api/report/ReportNodeRef;", "breadcrumbs", "Ljava/util/List;", "getBreadcrumbs", "()Ljava/util/List;", "version", "getVersion", "channelId", "getChannelId", "language", "getLanguage", "Companion", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ReportSubmissionBody {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<Integer> breadcrumbs;
    private final Long channelId;
    private final Map<String, List<String>> elements;
    private final Long guildId;
    private final Long guildScheduledEventId;
    private final Long hubId;
    private final long id;
    private final String language;
    private final Long messageId;
    private final String name;
    private final String variant;
    private final String version;

    /* compiled from: InAppReportsMenu.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJC\u0010\n\u001a*\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0002\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00020\b0\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/api/report/ReportSubmissionBody$Companion;", "", "", "Lcom/discord/api/report/NodeResult;", "results", "Lkotlin/Pair;", "", "Lcom/discord/api/report/ReportNodeRef;", "", "", "a", "(Ljava/util/List;)Lkotlin/Pair;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public final Tuples2<List<Integer>, Map<String, List<String>>> a(List<NodeResult> results) {
            Tuples2 tuples2;
            Intrinsics3.checkNotNullParameter(results, "results");
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = results.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ReportNodeChild destination = ((NodeResult) it.next()).getDestination();
                Integer numValueOf = destination != null ? Integer.valueOf(destination.getRef()) : null;
                if (numValueOf != null) {
                    arrayList.add(numValueOf);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it2 = results.iterator();
            while (it2.hasNext()) {
                NodeElementResult elementResult = ((NodeResult) it2.next()).getElementResult();
                if (elementResult != null) {
                    String key = elementResult.getKey();
                    List<ReportNodeElementData> listA = elementResult.a();
                    ArrayList arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(listA, 10));
                    Iterator<T> it3 = listA.iterator();
                    while (it3.hasNext()) {
                        arrayList3.add(((ReportNodeElementData) it3.next()).getElementKey());
                    }
                    tuples2 = Tuples.to(key, arrayList3);
                } else {
                    tuples2 = null;
                }
                if (tuples2 != null) {
                    arrayList2.add(tuples2);
                }
            }
            return Tuples.to(arrayList, Maps6.toMap(arrayList2));
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public ReportSubmissionBody(long j, Long l, Long l2, Long l3, Long l4, Long l5, String str, String str2, String str3, String str4, List list, Map map, int i) {
        Long l6 = (i & 2) != 0 ? null : l;
        Long l7 = (i & 4) != 0 ? null : l2;
        Long l8 = (i & 8) != 0 ? null : l3;
        Long l9 = (i & 16) != 0 ? null : l4;
        Long l10 = (i & 32) == 0 ? l5 : null;
        Intrinsics3.checkNotNullParameter(str, "language");
        Intrinsics3.checkNotNullParameter(str2, "variant");
        Intrinsics3.checkNotNullParameter(str3, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str4, "version");
        Intrinsics3.checkNotNullParameter(list, "breadcrumbs");
        Intrinsics3.checkNotNullParameter(map, "elements");
        this.id = j;
        this.messageId = l6;
        this.channelId = l7;
        this.guildId = l8;
        this.hubId = l9;
        this.guildScheduledEventId = l10;
        this.language = str;
        this.variant = str2;
        this.name = str3;
        this.version = str4;
        this.breadcrumbs = list;
        this.elements = map;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReportSubmissionBody)) {
            return false;
        }
        ReportSubmissionBody reportSubmissionBody = (ReportSubmissionBody) other;
        return this.id == reportSubmissionBody.id && Intrinsics3.areEqual(this.messageId, reportSubmissionBody.messageId) && Intrinsics3.areEqual(this.channelId, reportSubmissionBody.channelId) && Intrinsics3.areEqual(this.guildId, reportSubmissionBody.guildId) && Intrinsics3.areEqual(this.hubId, reportSubmissionBody.hubId) && Intrinsics3.areEqual(this.guildScheduledEventId, reportSubmissionBody.guildScheduledEventId) && Intrinsics3.areEqual(this.language, reportSubmissionBody.language) && Intrinsics3.areEqual(this.variant, reportSubmissionBody.variant) && Intrinsics3.areEqual(this.name, reportSubmissionBody.name) && Intrinsics3.areEqual(this.version, reportSubmissionBody.version) && Intrinsics3.areEqual(this.breadcrumbs, reportSubmissionBody.breadcrumbs) && Intrinsics3.areEqual(this.elements, reportSubmissionBody.elements);
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        Long l = this.messageId;
        int iHashCode = (i + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.channelId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.guildId;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.hubId;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.guildScheduledEventId;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        String str = this.language;
        int iHashCode6 = (iHashCode5 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.variant;
        int iHashCode7 = (iHashCode6 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.name;
        int iHashCode8 = (iHashCode7 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.version;
        int iHashCode9 = (iHashCode8 + (str4 != null ? str4.hashCode() : 0)) * 31;
        List<Integer> list = this.breadcrumbs;
        int iHashCode10 = (iHashCode9 + (list != null ? list.hashCode() : 0)) * 31;
        Map<String, List<String>> map = this.elements;
        return iHashCode10 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ReportSubmissionBody(id=");
        sbU.append(this.id);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", hubId=");
        sbU.append(this.hubId);
        sbU.append(", guildScheduledEventId=");
        sbU.append(this.guildScheduledEventId);
        sbU.append(", language=");
        sbU.append(this.language);
        sbU.append(", variant=");
        sbU.append(this.variant);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", version=");
        sbU.append(this.version);
        sbU.append(", breadcrumbs=");
        sbU.append(this.breadcrumbs);
        sbU.append(", elements=");
        return outline.M(sbU, this.elements, ")");
    }
}
