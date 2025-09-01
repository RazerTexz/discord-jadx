package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import com.discord.api.guildmember.GuildMember;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import com.discord.models.domain.Model;
import com.discord.models.domain.ModelGuildMemberListUpdate;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* compiled from: ModelGuildMemberListUpdate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "fieldName", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.models.domain.ModelGuildMemberListUpdate$Operation$Item$Parser$parse$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ModelGuildMemberListUpdate3<T> implements Action1<String> {
    public final /* synthetic */ Ref$ObjectRef $group;
    public final /* synthetic */ Ref$ObjectRef $member;
    public final /* synthetic */ Model.JsonReader $reader;

    public ModelGuildMemberListUpdate3(Ref$ObjectRef ref$ObjectRef, Model.JsonReader jsonReader, Ref$ObjectRef ref$ObjectRef2) {
        this.$group = ref$ObjectRef;
        this.$reader = jsonReader;
        this.$member = ref$ObjectRef2;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) throws IOException {
        call2(str);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) throws IOException {
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode != -1077769574) {
                if (iHashCode == 98629247 && str.equals("group")) {
                    this.$group.element = (T) ModelGuildMemberListUpdate.Group.Parser.INSTANCE.parse(this.$reader);
                    return;
                }
            } else if (str.equals("member")) {
                this.$member.element = (T) ((GuildMember) InboundGatewayGsonParser.fromJson(this.$reader, GuildMember.class));
                return;
            }
        }
        this.$reader.skipValue();
    }
}
