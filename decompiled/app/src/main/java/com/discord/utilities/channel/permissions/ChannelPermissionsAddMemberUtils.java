package com.discord.utilities.channel.permissions;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import rx.Observable;

/* compiled from: ChannelPermissionsAddMemberUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010JG\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b0\n2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00052\n\u0010\t\u001a\u00060\u0002j\u0002`\b¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/discord/utilities/channel/permissions/ChannelPermissionsAddMemberUtils;", "", "", "Lcom/discord/primitives/ChannelId;", "channelId", "", "Lcom/discord/api/permission/PermissionOverwrite$Type;", "selectedItems", "Lcom/discord/api/permission/PermissionBit;", "permission", "Lrx/Observable;", "", "Ljava/lang/Void;", "addPermissionOverwrites", "(JLjava/util/Map;J)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ChannelPermissionsAddMemberUtils {
    public static final ChannelPermissionsAddMemberUtils INSTANCE = new ChannelPermissionsAddMemberUtils();

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            PermissionOverwrite.Type.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[PermissionOverwrite.Type.ROLE.ordinal()] = 1;
            iArr[PermissionOverwrite.Type.MEMBER.ordinal()] = 2;
        }
    }

    private ChannelPermissionsAddMemberUtils() {
    }

    public final Observable<List<Void>> addPermissionOverwrites(long channelId, Map<Long, ? extends PermissionOverwrite.Type> selectedItems, long permission) {
        RestAPIParams.ChannelPermissionOverwrites channelPermissionOverwritesCreateForRole;
        Intrinsics3.checkNotNullParameter(selectedItems, "selectedItems");
        Channel channel = StoreStream.INSTANCE.getChannels().getChannel(channelId);
        ArrayList arrayList = new ArrayList(selectedItems.size());
        for (Map.Entry<Long, ? extends PermissionOverwrite.Type> entry : selectedItems.entrySet()) {
            long jLongValue = entry.getKey().longValue();
            PermissionOverwrite.Type value = entry.getValue();
            PermissionOverwrite permissionOverwriteF = channel != null ? ChannelUtils.f(channel, jLongValue) : null;
            long allow = permissionOverwriteF != null ? permissionOverwriteF.getAllow() : 0L;
            long deny = permissionOverwriteF != null ? permissionOverwriteF.getDeny() : 0L;
            int iOrdinal = value.ordinal();
            if (iOrdinal == 0) {
                channelPermissionOverwritesCreateForRole = RestAPIParams.ChannelPermissionOverwrites.INSTANCE.createForRole(jLongValue, Long.valueOf(allow | permission), Long.valueOf((~permission) & deny));
            } else {
                if (iOrdinal != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                channelPermissionOverwritesCreateForRole = RestAPIParams.ChannelPermissionOverwrites.INSTANCE.createForMember(jLongValue, Long.valueOf(allow | permission), Long.valueOf((~permission) & deny));
            }
            arrayList.add(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updatePermissionOverwrites(channelId, jLongValue, channelPermissionOverwritesCreateForRole), false, 1, null));
        }
        Observable<List<Void>> observableF0 = Observable.l(arrayList).f0();
        Intrinsics3.checkNotNullExpressionValue(observableF0, "Observable.concat(overwr…quests)\n        .toList()");
        return observableF0;
    }
}
