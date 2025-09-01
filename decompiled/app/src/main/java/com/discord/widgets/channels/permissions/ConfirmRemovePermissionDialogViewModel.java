package com.discord.widgets.channels.permissions;

import android.content.Context;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.channels.permissions.PermissionOwner;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ConfirmRemovePermissionDialogViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B%\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\u0010\u000f\u001a\u00060\rj\u0002`\u000e\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u000f\u001a\u00060\rj\u0002`\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/channels/permissions/ConfirmRemovePermissionDialogViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/channels/permissions/ConfirmRemovePermissionDialogViewModel$ViewState;", "Lcom/discord/api/permission/PermissionOverwrite;", "getNewPermissionOverwrite", "()Lcom/discord/api/permission/PermissionOverwrite;", "", "handleSubmissionComplete", "()V", "submit", "Lcom/discord/widgets/channels/permissions/PermissionOwner;", "permissionOwner", "Lcom/discord/widgets/channels/permissions/PermissionOwner;", "", "Lcom/discord/primitives/ChannelId;", "channelId", "J", "Lcom/discord/stores/StoreChannels;", "channelStore", "Lcom/discord/stores/StoreChannels;", "<init>", "(Lcom/discord/widgets/channels/permissions/PermissionOwner;JLcom/discord/stores/StoreChannels;)V", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ConfirmRemovePermissionDialogViewModel extends AppViewModel<ViewState> {
    private final long channelId;
    private final StoreChannels channelStore;
    private final PermissionOwner permissionOwner;

    /* compiled from: ConfirmRemovePermissionDialogViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/channels/permissions/ConfirmRemovePermissionDialogViewModel$ViewState;", "", "<init>", "()V", "Complete", "Default", "Lcom/discord/widgets/channels/permissions/ConfirmRemovePermissionDialogViewModel$ViewState$Default;", "Lcom/discord/widgets/channels/permissions/ConfirmRemovePermissionDialogViewModel$ViewState$Complete;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: ConfirmRemovePermissionDialogViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/channels/permissions/ConfirmRemovePermissionDialogViewModel$ViewState$Complete;", "Lcom/discord/widgets/channels/permissions/ConfirmRemovePermissionDialogViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Complete extends ViewState {
            public static final Complete INSTANCE = new Complete();

            private Complete() {
                super(null);
            }
        }

        /* compiled from: ConfirmRemovePermissionDialogViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0005\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/channels/permissions/ConfirmRemovePermissionDialogViewModel$ViewState$Default;", "Lcom/discord/widgets/channels/permissions/ConfirmRemovePermissionDialogViewModel$ViewState;", "", "component1", "()Z", "isSubmitting", "copy", "(Z)Lcom/discord/widgets/channels/permissions/ConfirmRemovePermissionDialogViewModel$ViewState$Default;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "<init>", "(Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Default extends ViewState {
            private final boolean isSubmitting;

            public Default(boolean z2) {
                super(null);
                this.isSubmitting = z2;
            }

            public static /* synthetic */ Default copy$default(Default r0, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = r0.isSubmitting;
                }
                return r0.copy(z2);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getIsSubmitting() {
                return this.isSubmitting;
            }

            public final Default copy(boolean isSubmitting) {
                return new Default(isSubmitting);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Default) && this.isSubmitting == ((Default) other).isSubmitting;
                }
                return true;
            }

            public int hashCode() {
                boolean z2 = this.isSubmitting;
                if (z2) {
                    return 1;
                }
                return z2 ? 1 : 0;
            }

            public final boolean isSubmitting() {
                return this.isSubmitting;
            }

            public String toString() {
                return outline.O(outline.U("Default(isSubmitting="), this.isSubmitting, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ConfirmRemovePermissionDialogViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.permissions.ConfirmRemovePermissionDialogViewModel$submit$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            ConfirmRemovePermissionDialogViewModel.access$handleSubmissionComplete(ConfirmRemovePermissionDialogViewModel.this);
        }
    }

    public /* synthetic */ ConfirmRemovePermissionDialogViewModel(PermissionOwner permissionOwner, long j, StoreChannels storeChannels, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(permissionOwner, j, (i & 4) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels);
    }

    public static final /* synthetic */ void access$handleSubmissionComplete(ConfirmRemovePermissionDialogViewModel confirmRemovePermissionDialogViewModel) {
        confirmRemovePermissionDialogViewModel.handleSubmissionComplete();
    }

    private final PermissionOverwrite getNewPermissionOverwrite() {
        List<PermissionOverwrite> listEmptyList;
        PermissionOverwrite.Type type;
        Object next;
        Channel channel = this.channelStore.getChannel(this.channelId);
        if (channel == null || (listEmptyList = channel.v()) == null) {
            listEmptyList = Collections2.emptyList();
        }
        PermissionOwner permissionOwner = this.permissionOwner;
        if (permissionOwner instanceof PermissionOwner.Role) {
            type = PermissionOverwrite.Type.ROLE;
        } else {
            if (!(permissionOwner instanceof PermissionOwner.Member)) {
                throw new NoWhenBranchMatchedException();
            }
            type = PermissionOverwrite.Type.MEMBER;
        }
        Iterator<T> it = listEmptyList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            PermissionOverwrite permissionOverwrite = (PermissionOverwrite) next;
            if (permissionOverwrite.getType() == type && permissionOverwrite.e() == this.permissionOwner.getEntityId()) {
                break;
            }
        }
        PermissionOverwrite permissionOverwrite2 = (PermissionOverwrite) next;
        if (permissionOverwrite2 == null) {
            return null;
        }
        PermissionOverwrite permissionOverwriteB = PermissionOverwrite.b(permissionOverwrite2, 0L, null, (-20971537) & permissionOverwrite2.getAllow(), 0L, 11);
        if (permissionOverwriteB.getAllow() == 0 && permissionOverwriteB.getDeny() == 0) {
            return null;
        }
        return permissionOverwriteB;
    }

    private final void handleSubmissionComplete() {
        updateViewState(ViewState.Complete.INSTANCE);
    }

    public final void submit() {
        updateViewState(new ViewState.Default(true));
        PermissionOverwrite newPermissionOverwrite = getNewPermissionOverwrite();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(newPermissionOverwrite != null ? RestAPI.INSTANCE.getApi().updatePermissionOverwrites(this.channelId, newPermissionOverwrite.e(), RestAPIParams.ChannelPermissionOverwrites.INSTANCE.fromPermissionOverwrite(newPermissionOverwrite)) : RestAPI.INSTANCE.getApi().deletePermissionOverwrites(this.channelId, this.permissionOwner.getEntityId()), false, 1, null), this, null, 2, null), ConfirmRemovePermissionDialogViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConfirmRemovePermissionDialogViewModel(PermissionOwner permissionOwner, long j, StoreChannels storeChannels) {
        super(new ViewState.Default(false));
        Intrinsics3.checkNotNullParameter(permissionOwner, "permissionOwner");
        Intrinsics3.checkNotNullParameter(storeChannels, "channelStore");
        this.permissionOwner = permissionOwner;
        this.channelId = j;
        this.channelStore = storeChannels;
    }
}
