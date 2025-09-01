package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.user.CoreUser;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.channels.WidgetGroupInviteFriends;
import d0.t.Iterables2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import rx.Observable;
import rx.functions.Func2;

/* compiled from: WidgetGroupInviteFriends.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0014\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "Lrx/Observable;", "Lcom/discord/widgets/channels/WidgetGroupInviteFriends$Model;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$Model$Companion$getForAdd$1<T, R> implements Func1<Channel, Observable<? extends WidgetGroupInviteFriends.Model>> {
    public final /* synthetic */ Observable $addedUsersPublisher;
    public final /* synthetic */ Observable $filterPublisher;

    /* compiled from: WidgetGroupInviteFriends.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/models/user/User;", "p1", "", "p2", "Lcom/discord/widgets/channels/WidgetGroupInviteFriends$Model$Companion$AddedUsersInput;", "invoke", "(Ljava/util/Collection;Ljava/lang/String;)Lcom/discord/widgets/channels/WidgetGroupInviteFriends$Model$Companion$AddedUsersInput;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getForAdd$1$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<Collection<? extends User>, String, WidgetGroupInviteFriends.Model.Companion.AddedUsersInput> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2, WidgetGroupInviteFriends.Model.Companion.AddedUsersInput.class, "<init>", "<init>(Ljava/util/Collection;Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ WidgetGroupInviteFriends.Model.Companion.AddedUsersInput invoke(Collection<? extends User> collection, String str) {
            return invoke2(collection, str);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final WidgetGroupInviteFriends.Model.Companion.AddedUsersInput invoke2(Collection<? extends User> collection, String str) {
            Intrinsics3.checkNotNullParameter(collection, "p1");
            Intrinsics3.checkNotNullParameter(str, "p2");
            return new WidgetGroupInviteFriends.Model.Companion.AddedUsersInput(collection, str);
        }
    }

    /* compiled from: WidgetGroupInviteFriends.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/widgets/channels/WidgetGroupInviteFriends$Model$Companion$AddedUsersInput;", "kotlin.jvm.PlatformType", "usersFilter", "Lrx/Observable;", "Lcom/discord/widgets/channels/WidgetGroupInviteFriends$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/channels/WidgetGroupInviteFriends$Model$Companion$AddedUsersInput;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getForAdd$1$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<WidgetGroupInviteFriends.Model.Companion.AddedUsersInput, Observable<? extends WidgetGroupInviteFriends.Model>> {
        public final /* synthetic */ Channel $channel;

        /* compiled from: WidgetGroupInviteFriends.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0001*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/widgets/channels/WidgetGroupInviteFriends$Model$ModelAppUserRelationship;", "kotlin.jvm.PlatformType", "friends", "", "Lcom/discord/widgets/channels/WidgetGroupInviteFriends$Model$FriendItem;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/channels/WidgetGroupInviteFriends$Model$ModelAppUserRelationship;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getForAdd$1$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C02432<T, R> implements Func1<WidgetGroupInviteFriends.Model.ModelAppUserRelationship, List<? extends WidgetGroupInviteFriends.Model.FriendItem>> {
            public final /* synthetic */ WidgetGroupInviteFriends.Model.Companion.AddedUsersInput $usersFilter;

            public C02432(WidgetGroupInviteFriends.Model.Companion.AddedUsersInput addedUsersInput) {
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
        /* renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getForAdd$1$2$3, reason: invalid class name */
        public static final class AnonymousClass3<T, R> implements Func1<List<? extends WidgetGroupInviteFriends.Model.FriendItem>, Observable<? extends WidgetGroupInviteFriends.Model>> {
            public final /* synthetic */ WidgetGroupInviteFriends.Model.Companion.AddedUsersInput $usersFilter;

            public AnonymousClass3(WidgetGroupInviteFriends.Model.Companion.AddedUsersInput addedUsersInput) {
                this.$usersFilter = addedUsersInput;
            }

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Observable<? extends WidgetGroupInviteFriends.Model> call(List<? extends WidgetGroupInviteFriends.Model.FriendItem> list) {
                return call2((List<WidgetGroupInviteFriends.Model.FriendItem>) list);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends WidgetGroupInviteFriends.Model> call2(List<WidgetGroupInviteFriends.Model.FriendItem> list) {
                Channel channel = AnonymousClass2.this.$channel;
                String filter = this.$usersFilter.getFilter();
                Collection<User> addedUsers = this.$usersFilter.getAddedUsers();
                Intrinsics3.checkNotNullExpressionValue(list, "friendItems");
                return new ScalarSynchronousObservable(new WidgetGroupInviteFriends.Model(channel, filter, addedUsers, list, 1, UserUtils.INSTANCE.isStaff(StoreStream.INSTANCE.getUsers().getMeSnapshot()) ? 25 : 10));
            }
        }

        public AnonymousClass2(Channel channel) {
            this.$channel = channel;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends WidgetGroupInviteFriends.Model> call(WidgetGroupInviteFriends.Model.Companion.AddedUsersInput addedUsersInput) {
            return call2(addedUsersInput);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends WidgetGroupInviteFriends.Model> call2(WidgetGroupInviteFriends.Model.Companion.AddedUsersInput addedUsersInput) {
            ArrayList arrayList;
            WidgetGroupInviteFriends.Model.Companion companion = WidgetGroupInviteFriends.Model.INSTANCE;
            List<com.discord.api.user.User> listZ = this.$channel.z();
            if (listZ != null) {
                arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listZ, 10));
                Iterator<T> it = listZ.iterator();
                while (it.hasNext()) {
                    arrayList.add(new CoreUser((com.discord.api.user.User) it.next()));
                }
            } else {
                arrayList = null;
            }
            return WidgetGroupInviteFriends.Model.Companion.access$getFilteredFriends(companion, arrayList, addedUsersInput.getFilter()).G(new C02432(addedUsersInput)).Y(new AnonymousClass3(addedUsersInput));
        }
    }

    public WidgetGroupInviteFriends$Model$Companion$getForAdd$1(Observable observable, Observable observable2) {
        this.$addedUsersPublisher = observable;
        this.$filterPublisher = observable2;
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetGroupInviteFriends.Model> call2(Channel channel) {
        if (channel == null) {
            return new ScalarSynchronousObservable(null);
        }
        Observable observable = this.$addedUsersPublisher;
        Observable observable2 = this.$filterPublisher;
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        Object widgetGroupInviteFriends$sam$rx_functions_Func2$0 = anonymousClass1;
        if (anonymousClass1 != null) {
            widgetGroupInviteFriends$sam$rx_functions_Func2$0 = new WidgetGroupInviteFriends$sam$rx_functions_Func2$0(anonymousClass1);
        }
        return Observable.j(observable, observable2, (Func2) widgetGroupInviteFriends$sam$rx_functions_Func2$0).Y(new AnonymousClass2(channel));
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetGroupInviteFriends.Model> call(Channel channel) {
        return call2(channel);
    }
}
