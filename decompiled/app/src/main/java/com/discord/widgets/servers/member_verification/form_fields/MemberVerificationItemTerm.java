package com.discord.widgets.servers.member_verification.form_fields;

import b.d.b.a.outline;
import com.discord.api.role.GuildRole;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.textprocessing.MessageRenderContext;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: MemberVerificationItemTerm.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\u0012\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u0012\u0016\u0010\u001c\u001a\u0012\u0012\b\u0012\u00060\u000ej\u0002`\u000f\u0012\u0004\u0012\u00020\u00050\r\u0012\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00120\r\u0012\u0006\u0010\u001e\u001a\u00020\u0014\u0012\u0006\u0010\u001f\u001a\u00020\u0014\u0012\u0006\u0010 \u001a\u00020\u0014¢\u0006\u0004\b8\u00109J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0010\u001a\u0012\u0012\b\u0012\u00060\u000ej\u0002`\u000f\u0012\u0004\u0012\u00020\u00050\rHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00120\rHÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0011J\u0010\u0010\u0015\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0016J\u0088\u0001\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00052\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0018\b\u0002\u0010\u001c\u001a\u0012\u0012\b\u0012\u00060\u000ej\u0002`\u000f\u0012\u0004\u0012\u00020\u00050\r2\u0014\b\u0002\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00120\r2\b\b\u0002\u0010\u001e\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010 \u001a\u00020\u0014HÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b#\u0010\u0007J\u0010\u0010$\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b$\u0010\u0004J\u001a\u0010'\u001a\u00020\u00142\b\u0010&\u001a\u0004\u0018\u00010%HÖ\u0003¢\u0006\u0004\b'\u0010(R%\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010)\u001a\u0004\b*\u0010\fR)\u0010\u001c\u001a\u0012\u0012\b\u0012\u00060\u000ej\u0002`\u000f\u0012\u0004\u0012\u00020\u00050\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010+\u001a\u0004\b,\u0010\u0011R\u0019\u0010\u001e\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010-\u001a\u0004\b.\u0010\u0016R\u001c\u0010/\u001a\u00020\u00028\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010\u0004R\u0019\u0010 \u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b \u0010-\u001a\u0004\b \u0010\u0016R\u0019\u0010\u0019\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u00100\u001a\u0004\b2\u0010\u0004R\u0019\u0010\u001a\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u00103\u001a\u0004\b4\u0010\u0007R%\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00120\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010+\u001a\u0004\b5\u0010\u0011R\u0019\u0010\u001f\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010-\u001a\u0004\b\u001f\u0010\u0016R\u001c\u00106\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b6\u00103\u001a\u0004\b7\u0010\u0007¨\u0006:"}, d2 = {"Lcom/discord/widgets/servers/member_verification/form_fields/MemberVerificationItemTerm;", "Lcom/discord/widgets/servers/member_verification/form_fields/MemberVerificationItem;", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "", "Lcom/discord/simpleast/core/node/Node;", "Lcom/discord/utilities/textprocessing/MessageRenderContext;", "component3", "()Ljava/util/List;", "", "", "Lcom/discord/primitives/ChannelId;", "component4", "()Ljava/util/Map;", "Lcom/discord/api/role/GuildRole;", "component5", "", "component6", "()Z", "component7", "component8", "index", "rule", "ast", "channelNames", "roles", "allowAnimatedEmojis", "isFirstItem", "isLastItem", "copy", "(ILjava/lang/String;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;ZZZ)Lcom/discord/widgets/servers/member_verification/form_fields/MemberVerificationItemTerm;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getAst", "Ljava/util/Map;", "getChannelNames", "Z", "getAllowAnimatedEmojis", "type", "I", "getType", "getIndex", "Ljava/lang/String;", "getRule", "getRoles", "key", "getKey", "<init>", "(ILjava/lang/String;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;ZZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class MemberVerificationItemTerm implements MemberVerificationItem {
    private final boolean allowAnimatedEmojis;
    private final List<Node<MessageRenderContext>> ast;
    private final Map<Long, String> channelNames;
    private final int index;
    private final boolean isFirstItem;
    private final boolean isLastItem;
    private final String key;
    private final Map<Long, GuildRole> roles;
    private final String rule;
    private final int type;

    public MemberVerificationItemTerm(int i, String str, List<Node<MessageRenderContext>> list, Map<Long, String> map, Map<Long, GuildRole> map2, boolean z2, boolean z3, boolean z4) {
        Intrinsics3.checkNotNullParameter(str, "rule");
        Intrinsics3.checkNotNullParameter(list, "ast");
        Intrinsics3.checkNotNullParameter(map, "channelNames");
        Intrinsics3.checkNotNullParameter(map2, "roles");
        this.index = i;
        this.rule = str;
        this.ast = list;
        this.channelNames = map;
        this.roles = map2;
        this.allowAnimatedEmojis = z2;
        this.isFirstItem = z3;
        this.isLastItem = z4;
        this.type = 3;
        this.key = getType() + i + str;
    }

    public static /* synthetic */ MemberVerificationItemTerm copy$default(MemberVerificationItemTerm memberVerificationItemTerm, int i, String str, List list, Map map, Map map2, boolean z2, boolean z3, boolean z4, int i2, Object obj) {
        return memberVerificationItemTerm.copy((i2 & 1) != 0 ? memberVerificationItemTerm.index : i, (i2 & 2) != 0 ? memberVerificationItemTerm.rule : str, (i2 & 4) != 0 ? memberVerificationItemTerm.ast : list, (i2 & 8) != 0 ? memberVerificationItemTerm.channelNames : map, (i2 & 16) != 0 ? memberVerificationItemTerm.roles : map2, (i2 & 32) != 0 ? memberVerificationItemTerm.allowAnimatedEmojis : z2, (i2 & 64) != 0 ? memberVerificationItemTerm.isFirstItem : z3, (i2 & 128) != 0 ? memberVerificationItemTerm.isLastItem : z4);
    }

    /* renamed from: component1, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* renamed from: component2, reason: from getter */
    public final String getRule() {
        return this.rule;
    }

    public final List<Node<MessageRenderContext>> component3() {
        return this.ast;
    }

    public final Map<Long, String> component4() {
        return this.channelNames;
    }

    public final Map<Long, GuildRole> component5() {
        return this.roles;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getAllowAnimatedEmojis() {
        return this.allowAnimatedEmojis;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsFirstItem() {
        return this.isFirstItem;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsLastItem() {
        return this.isLastItem;
    }

    public final MemberVerificationItemTerm copy(int index, String rule, List<Node<MessageRenderContext>> ast, Map<Long, String> channelNames, Map<Long, GuildRole> roles, boolean allowAnimatedEmojis, boolean isFirstItem, boolean isLastItem) {
        Intrinsics3.checkNotNullParameter(rule, "rule");
        Intrinsics3.checkNotNullParameter(ast, "ast");
        Intrinsics3.checkNotNullParameter(channelNames, "channelNames");
        Intrinsics3.checkNotNullParameter(roles, "roles");
        return new MemberVerificationItemTerm(index, rule, ast, channelNames, roles, allowAnimatedEmojis, isFirstItem, isLastItem);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemberVerificationItemTerm)) {
            return false;
        }
        MemberVerificationItemTerm memberVerificationItemTerm = (MemberVerificationItemTerm) other;
        return this.index == memberVerificationItemTerm.index && Intrinsics3.areEqual(this.rule, memberVerificationItemTerm.rule) && Intrinsics3.areEqual(this.ast, memberVerificationItemTerm.ast) && Intrinsics3.areEqual(this.channelNames, memberVerificationItemTerm.channelNames) && Intrinsics3.areEqual(this.roles, memberVerificationItemTerm.roles) && this.allowAnimatedEmojis == memberVerificationItemTerm.allowAnimatedEmojis && this.isFirstItem == memberVerificationItemTerm.isFirstItem && this.isLastItem == memberVerificationItemTerm.isLastItem;
    }

    public final boolean getAllowAnimatedEmojis() {
        return this.allowAnimatedEmojis;
    }

    public final List<Node<MessageRenderContext>> getAst() {
        return this.ast;
    }

    public final Map<Long, String> getChannelNames() {
        return this.channelNames;
    }

    public final int getIndex() {
        return this.index;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Map<Long, GuildRole> getRoles() {
        return this.roles;
    }

    public final String getRule() {
        return this.rule;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i = this.index * 31;
        String str = this.rule;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        List<Node<MessageRenderContext>> list = this.ast;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        Map<Long, String> map = this.channelNames;
        int iHashCode3 = (iHashCode2 + (map != null ? map.hashCode() : 0)) * 31;
        Map<Long, GuildRole> map2 = this.roles;
        int iHashCode4 = (iHashCode3 + (map2 != null ? map2.hashCode() : 0)) * 31;
        boolean z2 = this.allowAnimatedEmojis;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        int i3 = (iHashCode4 + i2) * 31;
        boolean z3 = this.isFirstItem;
        int i4 = z3;
        if (z3 != 0) {
            i4 = 1;
        }
        int i5 = (i3 + i4) * 31;
        boolean z4 = this.isLastItem;
        return i5 + (z4 ? 1 : z4 ? 1 : 0);
    }

    public final boolean isFirstItem() {
        return this.isFirstItem;
    }

    public final boolean isLastItem() {
        return this.isLastItem;
    }

    public String toString() {
        StringBuilder sbU = outline.U("MemberVerificationItemTerm(index=");
        sbU.append(this.index);
        sbU.append(", rule=");
        sbU.append(this.rule);
        sbU.append(", ast=");
        sbU.append(this.ast);
        sbU.append(", channelNames=");
        sbU.append(this.channelNames);
        sbU.append(", roles=");
        sbU.append(this.roles);
        sbU.append(", allowAnimatedEmojis=");
        sbU.append(this.allowAnimatedEmojis);
        sbU.append(", isFirstItem=");
        sbU.append(this.isFirstItem);
        sbU.append(", isLastItem=");
        return outline.O(sbU, this.isLastItem, ")");
    }
}
