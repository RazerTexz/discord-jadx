package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.channels.WidgetGroupInviteFriends;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import rx.Observable;

/* compiled from: WidgetGroupInviteFriends.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/widgets/channels/WidgetGroupInviteFriends$Model$Companion$AddedUsersInput;", "kotlin.jvm.PlatformType", "usersFilter", "Lrx/Observable;", "Lcom/discord/widgets/channels/WidgetGroupInviteFriends$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/channels/WidgetGroupInviteFriends$Model$Companion$AddedUsersInput;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$Model$Companion$getForCreate$2<T, R> implements Func1<WidgetGroupInviteFriends.Model.Companion.AddedUsersInput, Observable<? extends WidgetGroupInviteFriends.Model>> {
    public static final WidgetGroupInviteFriends$Model$Companion$getForCreate$2 INSTANCE = new WidgetGroupInviteFriends$Model$Companion$getForCreate$2();

    /* compiled from: WidgetGroupInviteFriends.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0001*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/widgets/channels/WidgetGroupInviteFriends$Model$ModelAppUserRelationship;", "kotlin.jvm.PlatformType", "friends", "", "Lcom/discord/widgets/channels/WidgetGroupInviteFriends$Model$FriendItem;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/channels/WidgetGroupInviteFriends$Model$ModelAppUserRelationship;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getForCreate$2$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<WidgetGroupInviteFriends.Model.ModelAppUserRelationship, List<? extends WidgetGroupInviteFriends.Model.FriendItem>> {
        public final /* synthetic */ WidgetGroupInviteFriends.Model.Companion.AddedUsersInput $usersFilter;

        public AnonymousClass1(WidgetGroupInviteFriends.Model.Companion.AddedUsersInput addedUsersInput) {
            this.$usersFilter = addedUsersInput;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ List<? extends WidgetGroupInviteFriends.Model.FriendItem> call(WidgetGroupInviteFriends.Model.ModelAppUserRelationship modelAppUserRelationship) {
            return call2(modelAppUserRelationship);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<WidgetGroupInviteFriends.Model.FriendItem> call2(WidgetGroupInviteFriends.Model.ModelAppUserRelationship modelAppUserRelationship) {
            WidgetGroupInviteFriends.Model.FriendItem.Companion companion = WidgetGroupInviteFriends.Model.FriendItem.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(modelAppUserRelationship, "friends");
            return companion.createData(modelAppUserRelationship, this.$usersFilter.getAddedUsers());
        }
    }

    /* compiled from: WidgetGroupInviteFriends.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a*\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005 \u0002*\u0014\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/widgets/channels/WidgetGroupInviteFriends$Model$FriendItem;", "kotlin.jvm.PlatformType", "friendItems", "Lrx/Observable;", "Lcom/discord/widgets/channels/WidgetGroupInviteFriends$Model;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getForCreate$2$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<List<? extends WidgetGroupInviteFriends.Model.FriendItem>, Observable<? extends WidgetGroupInviteFriends.Model>> {
        public final /* synthetic */ WidgetGroupInviteFriends.Model.Companion.AddedUsersInput $usersFilter;

        public AnonymousClass2(WidgetGroupInviteFriends.Model.Companion.AddedUsersInput addedUsersInput) {
            this.$usersFilter = addedUsersInput;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends WidgetGroupInviteFriends.Model> call(List<? extends WidgetGroupInviteFriends.Model.FriendItem> list) {
            return call2((List<WidgetGroupInviteFriends.Model.FriendItem>) list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends WidgetGroupInviteFriends.Model> call2(List<WidgetGroupInviteFriends.Model.FriendItem> list) {
            String filter = this.$usersFilter.getFilter();
            Collection<User> addedUsers = this.$usersFilter.getAddedUsers();
            Intrinsics3.checkNotNullExpressionValue(list, "friendItems");
            return new ScalarSynchronousObservable(new WidgetGroupInviteFriends.Model(null, filter, addedUsers, list, 0, UserUtils.INSTANCE.isStaff(StoreStream.INSTANCE.getUsers().getMeSnapshot()) ? 25 : 10));
        }
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetGroupInviteFriends.Model> call(WidgetGroupInviteFriends.Model.Companion.AddedUsersInput addedUsersInput) {
        return call2(addedUsersInput);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetGroupInviteFriends.Model> call2(WidgetGroupInviteFriends.Model.Companion.AddedUsersInput addedUsersInput) {
        return WidgetGroupInviteFriends.Model.Companion.access$getFilteredFriends(WidgetGroupInviteFriends.Model.INSTANCE, null, addedUsersInput.getFilter()).G(new AnonymousClass1(addedUsersInput)).Y(new AnonymousClass2(addedUsersInput));
    }
}
