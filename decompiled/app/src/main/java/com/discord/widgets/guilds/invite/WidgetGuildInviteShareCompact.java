package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.BuildConfig;
import com.discord.R;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.Guild;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetGuildInviteShareCompactBinding;
import com.discord.databinding.WidgetGuildInviteShareItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guilds.invite.InviteSuggestionItem;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Func0;

/* compiled from: WidgetGuildInviteShareCompact.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b1\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\f\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\bR\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001d\u0010!\u001a\u00020\u001c8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000b\u0010%R\u001d\u0010+\u001a\u00020&8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R$\u00100\u001a\n -*\u0004\u0018\u00010,0,*\u0004\u0018\u00010\u00108B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00063"}, d2 = {"Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareCompact;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareViewModel$ViewState$Loaded;", "viewState", "", "configureUI", "(Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareViewModel$ViewState$Loaded;)V", "initBottomSheet", "()V", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Lcom/discord/widgets/guilds/invite/ViewInviteSettingsSheet;", "bottomSheetBehavior", "initBottomSheetBehavior", "(Lcom/google/android/material/bottomsheet/BottomSheetBehavior;)V", "Lcom/discord/widgets/guilds/invite/InviteSuggestionItem;", "item", "Lcom/discord/models/domain/ModelInvite;", "invite", "sendInvite", "(Lcom/discord/widgets/guilds/invite/InviteSuggestionItem;Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareViewModel$ViewState$Loaded;Lcom/discord/models/domain/ModelInvite;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareCompact$PrivateChannelAdapter;", "adapter", "Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareCompact$PrivateChannelAdapter;", "Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareViewModel;", "viewModel", "", "hasTrackedSuggestionsViewed", "Z", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Lcom/discord/databinding/WidgetGuildInviteShareCompactBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetGuildInviteShareCompactBinding;", "binding", "", "kotlin.jvm.PlatformType", "getInviteLink", "(Lcom/discord/models/domain/ModelInvite;)Ljava/lang/String;", "inviteLink", "<init>", "PrivateChannelAdapter", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildInviteShareCompact extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildInviteShareCompact.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildInviteShareCompactBinding;", 0)};
    private PrivateChannelAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehavior;
    private boolean hasTrackedSuggestionsViewed;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetGuildInviteShareCompact.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR.\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareCompact$PrivateChannelAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/guilds/invite/InviteSuggestionItem;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareCompact$PrivateChannelAdapter$Item;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareCompact$PrivateChannelAdapter$Item;", "Lkotlin/Function1;", "", "onClick", "Lkotlin/jvm/functions/Function1;", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "setOnClick", "(Lkotlin/jvm/functions/Function1;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Item", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class PrivateChannelAdapter extends MGRecyclerAdapterSimple<InviteSuggestionItem> {
        private Function1<? super InviteSuggestionItem, Unit> onClick;

        /* compiled from: WidgetGuildInviteShareCompact.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareCompact$PrivateChannelAdapter$Item;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareCompact$PrivateChannelAdapter;", "Lcom/discord/widgets/guilds/invite/InviteSuggestionItem;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/guilds/invite/InviteSuggestionItem;)V", "Lcom/discord/databinding/WidgetGuildInviteShareItemBinding;", "binding", "Lcom/discord/databinding/WidgetGuildInviteShareItemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareCompact$PrivateChannelAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Item extends MGRecyclerViewHolder<PrivateChannelAdapter, InviteSuggestionItem> {
            private final WidgetGuildInviteShareItemBinding binding;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Item(PrivateChannelAdapter privateChannelAdapter) {
                super(R.layout.widget_guild_invite_share_item, privateChannelAdapter);
                Intrinsics3.checkNotNullParameter(privateChannelAdapter, "adapter");
                WidgetGuildInviteShareItemBinding widgetGuildInviteShareItemBindingA = WidgetGuildInviteShareItemBinding.a(this.itemView);
                Intrinsics3.checkNotNullExpressionValue(widgetGuildInviteShareItemBindingA, "WidgetGuildInviteShareItemBinding.bind(itemView)");
                this.binding = widgetGuildInviteShareItemBindingA;
            }

            public static final /* synthetic */ PrivateChannelAdapter access$getAdapter$p(Item item) {
                return (PrivateChannelAdapter) item.adapter;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            public /* bridge */ /* synthetic */ void onConfigure(int i, InviteSuggestionItem inviteSuggestionItem) {
                onConfigure2(i, inviteSuggestionItem);
            }

            /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
            public void onConfigure2(int position, InviteSuggestionItem data) {
                Intrinsics3.checkNotNullParameter(data, "data");
                super.onConfigure(position, (int) data);
                boolean z2 = data instanceof InviteSuggestionItem.ChannelItem;
                if (z2) {
                    InviteSuggestionItem.ChannelItem channelItem = (InviteSuggestionItem.ChannelItem) data;
                    if (channelItem.getChannel().getType() != 1) {
                        SimpleDraweeView simpleDraweeView = this.binding.f2421b;
                        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.itemIconIv");
                        IconUtils.setIcon$default(simpleDraweeView, channelItem.getChannel(), 0, (MGImages.ChangeDetector) null, 12, (Object) null);
                    } else {
                        SimpleDraweeView simpleDraweeView2 = this.binding.f2421b;
                        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.itemIconIv");
                        IconUtils.setIcon$default(simpleDraweeView2, ChannelUtils.a(channelItem.getChannel()), 0, null, null, null, 60, null);
                    }
                    TextView textView = this.binding.d;
                    Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemNameTv");
                    textView.setText(ChannelUtils.c(channelItem.getChannel()));
                } else if (data instanceof InviteSuggestionItem.UserItem) {
                    SimpleDraweeView simpleDraweeView3 = this.binding.f2421b;
                    Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.itemIconIv");
                    InviteSuggestionItem.UserItem userItem = (InviteSuggestionItem.UserItem) data;
                    IconUtils.setIcon$default(simpleDraweeView3, userItem.getUser(), 0, null, null, null, 60, null);
                    TextView textView2 = this.binding.d;
                    Intrinsics3.checkNotNullExpressionValue(textView2, "binding.itemNameTv");
                    textView2.setText(userItem.getUser().getUsername());
                }
                if (z2 || (data instanceof InviteSuggestionItem.UserItem)) {
                    MaterialButton materialButton = this.binding.e;
                    Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.itemSent");
                    materialButton.setVisibility(data.hasSentInvite() ? 0 : 8);
                    MaterialButton materialButton2 = this.binding.c;
                    Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.itemInviteBtn");
                    materialButton2.setVisibility(data.hasSentInvite() ^ true ? 0 : 8);
                    this.binding.c.setOnClickListener(new WidgetGuildInviteShareCompact2(this, data));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PrivateChannelAdapter(RecyclerView recyclerView) {
            super(recyclerView, false, 2, null);
            Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
            this.onClick = WidgetGuildInviteShareCompact3.INSTANCE;
        }

        public final Function1<InviteSuggestionItem, Unit> getOnClick() {
            return this.onClick;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return onCreateViewHolder(viewGroup, i);
        }

        public final void setOnClick(Function1<? super InviteSuggestionItem, Unit> function1) {
            Intrinsics3.checkNotNullParameter(function1, "<set-?>");
            this.onClick = function1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public Item onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            return new Item(this);
        }
    }

    /* compiled from: WidgetGuildInviteShareCompact.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guilds/invite/InviteSuggestionItem;", "item", "", "invoke", "(Lcom/discord/widgets/guilds/invite/InviteSuggestionItem;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<InviteSuggestionItem, Unit> {
        public final /* synthetic */ ModelInvite $invite;
        public final /* synthetic */ WidgetGuildInviteShareViewModel.ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(WidgetGuildInviteShareViewModel.ViewState.Loaded loaded, ModelInvite modelInvite) {
            super(1);
            this.$viewState = loaded;
            this.$invite = modelInvite;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(InviteSuggestionItem inviteSuggestionItem) {
            invoke2(inviteSuggestionItem);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(InviteSuggestionItem inviteSuggestionItem) {
            Intrinsics3.checkNotNullParameter(inviteSuggestionItem, "item");
            WidgetGuildInviteShareCompact.access$sendInvite(WidgetGuildInviteShareCompact.this, inviteSuggestionItem, this.$viewState, this.$invite);
        }
    }

    /* compiled from: WidgetGuildInviteShareCompact.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ ModelInvite $invite;

        public AnonymousClass4(ModelInvite modelInvite) {
            this.$invite = modelInvite;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ModelInvite modelInvite = this.$invite;
            if (modelInvite != null) {
                GuildInviteUiHelper.shareLinkClick(WidgetGuildInviteShareCompact.this.getContext(), modelInvite);
            }
        }
    }

    /* compiled from: WidgetGuildInviteShareCompact.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact$initBottomSheet$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetGuildInviteShareCompact.access$getBottomSheetBehavior$p(WidgetGuildInviteShareCompact.this).setState(5);
        }
    }

    /* compiled from: WidgetGuildInviteShareCompact.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/discord/widgets/guilds/invite/WidgetGuildInviteShareCompact$initBottomSheetBehavior$1", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$BottomSheetCallback;", "Landroid/view/View;", "bottomSheet", "", "newState", "", "onStateChanged", "(Landroid/view/View;I)V", "", "slideOffset", "onSlide", "(Landroid/view/View;F)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact$initBottomSheetBehavior$1, reason: invalid class name */
    public static final class AnonymousClass1 extends BottomSheetBehavior.BottomSheetCallback {
        public AnonymousClass1() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(View bottomSheet, float slideOffset) {
            Intrinsics3.checkNotNullParameter(bottomSheet, "bottomSheet");
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(View bottomSheet, int newState) {
            Intrinsics3.checkNotNullParameter(bottomSheet, "bottomSheet");
            if (newState == 5) {
                WidgetGuildInviteShareCompact.access$getViewModel$p(WidgetGuildInviteShareCompact.this).refreshUi();
            }
            ViewExtensions.fadeBy$default(WidgetGuildInviteShareCompact.access$getBinding$p(WidgetGuildInviteShareCompact.this).f2419b, newState != 5, 0L, 2, null);
        }
    }

    /* compiled from: WidgetGuildInviteShareCompact.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "()Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1<R> implements Func0<Boolean> {
        public final /* synthetic */ boolean $isNuxFlow;

        public AnonymousClass1(boolean z2) {
            this.$isNuxFlow = z2;
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            if (WidgetGuildInviteShareCompact.access$getBottomSheetBehavior$p(WidgetGuildInviteShareCompact.this).getState() != 5) {
                WidgetGuildInviteShareCompact.access$getBottomSheetBehavior$p(WidgetGuildInviteShareCompact.this).setState(5);
                return Boolean.TRUE;
            }
            if (!this.$isNuxFlow) {
                return Boolean.FALSE;
            }
            AppScreen2.c(WidgetGuildInviteShareCompact.this.requireContext(), false, null, 6);
            return Boolean.TRUE;
        }
    }

    /* compiled from: WidgetGuildInviteShareCompact.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/text/Editable;", "editable", "", "invoke", "(Landroid/text/Editable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Editable, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "editable");
            WidgetGuildInviteShareCompact.access$getViewModel$p(WidgetGuildInviteShareCompact.this).updateSearchQuery(editable.toString());
        }
    }

    /* compiled from: WidgetGuildInviteShareCompact.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildInviteShareCompact.access$getBottomSheetBehavior$p(WidgetGuildInviteShareCompact.this).setState(3);
        }
    }

    /* compiled from: WidgetGuildInviteShareCompact.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildInviteShareCompact.access$getBottomSheetBehavior$p(WidgetGuildInviteShareCompact.this).setState(3);
        }
    }

    /* compiled from: WidgetGuildInviteShareCompact.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact$onViewBound$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildInviteShareCompact.access$getBottomSheetBehavior$p(WidgetGuildInviteShareCompact.this).setState(5);
        }
    }

    /* compiled from: WidgetGuildInviteShareCompact.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareViewModel$ViewState$Loaded;", "p1", "", "invoke", "(Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareViewModel$ViewState$Loaded;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetGuildInviteShareViewModel.ViewState.Loaded, Unit> {
        public AnonymousClass1(WidgetGuildInviteShareCompact widgetGuildInviteShareCompact) {
            super(1, widgetGuildInviteShareCompact, WidgetGuildInviteShareCompact.class, "configureUI", "configureUI(Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareViewModel$ViewState$Loaded;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildInviteShareViewModel.ViewState.Loaded loaded) {
            invoke2(loaded);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildInviteShareViewModel.ViewState.Loaded loaded) {
            Intrinsics3.checkNotNullParameter(loaded, "p1");
            WidgetGuildInviteShareCompact.access$configureUI((WidgetGuildInviteShareCompact) this.receiver, loaded);
        }
    }

    public WidgetGuildInviteShareCompact() {
        super(R.layout.widget_guild_invite_share_compact);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildInviteShareCompact4.INSTANCE, null, 2, null);
        WidgetGuildInviteShareCompact5 widgetGuildInviteShareCompact5 = new WidgetGuildInviteShareCompact5(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetGuildInviteShareViewModel.class), new WidgetGuildInviteShareCompact$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildInviteShareCompact5));
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildInviteShareCompact widgetGuildInviteShareCompact, WidgetGuildInviteShareViewModel.ViewState.Loaded loaded) {
        widgetGuildInviteShareCompact.configureUI(loaded);
    }

    public static final /* synthetic */ WidgetGuildInviteShareCompactBinding access$getBinding$p(WidgetGuildInviteShareCompact widgetGuildInviteShareCompact) {
        return widgetGuildInviteShareCompact.getBinding();
    }

    public static final /* synthetic */ BottomSheetBehavior access$getBottomSheetBehavior$p(WidgetGuildInviteShareCompact widgetGuildInviteShareCompact) {
        BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehavior = widgetGuildInviteShareCompact.bottomSheetBehavior;
        if (bottomSheetBehavior == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        }
        return bottomSheetBehavior;
    }

    public static final /* synthetic */ WidgetGuildInviteShareViewModel access$getViewModel$p(WidgetGuildInviteShareCompact widgetGuildInviteShareCompact) {
        return widgetGuildInviteShareCompact.getViewModel();
    }

    public static final /* synthetic */ void access$sendInvite(WidgetGuildInviteShareCompact widgetGuildInviteShareCompact, InviteSuggestionItem inviteSuggestionItem, WidgetGuildInviteShareViewModel.ViewState.Loaded loaded, ModelInvite modelInvite) {
        widgetGuildInviteShareCompact.sendInvite(inviteSuggestionItem, loaded, modelInvite);
    }

    public static final /* synthetic */ void access$setBottomSheetBehavior$p(WidgetGuildInviteShareCompact widgetGuildInviteShareCompact, BottomSheetBehavior bottomSheetBehavior) {
        widgetGuildInviteShareCompact.bottomSheetBehavior = bottomSheetBehavior;
    }

    private final void configureUI(WidgetGuildInviteShareViewModel.ViewState.Loaded viewState) {
        Guild guild;
        WidgetInviteModel widgetInviteModel = viewState.getWidgetInviteModel();
        List<InviteSuggestionItem> inviteSuggestionItems = viewState.getInviteSuggestionItems();
        ModelInvite invite = widgetInviteModel.getInvite();
        AppViewFlipper appViewFlipper = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.guildInviteSuggestionsFlipper");
        appViewFlipper.setDisplayedChild(!inviteSuggestionItems.isEmpty() ? 1 : 0);
        if (inviteSuggestionItems.size() == 1 && (_Collections.firstOrNull((List) inviteSuggestionItems) instanceof InviteSuggestionItem.Companion)) {
            inviteSuggestionItems = null;
        }
        if (inviteSuggestionItems == null) {
            inviteSuggestionItems = Collections2.emptyList();
        }
        if ((!inviteSuggestionItems.isEmpty()) && !this.hasTrackedSuggestionsViewed) {
            ModelInvite invite2 = widgetInviteModel.getInvite();
            long id2 = (invite2 == null || (guild = invite2.guild) == null) ? 0L : guild.getId();
            AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
            ArrayList arrayList = new ArrayList();
            for (Object obj : inviteSuggestionItems) {
                if (obj instanceof InviteSuggestionItem.ChannelItem) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((InviteSuggestionItem.ChannelItem) it.next()).getChannel());
            }
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : inviteSuggestionItems) {
                if (obj2 instanceof InviteSuggestionItem.UserItem) {
                    arrayList3.add(obj2);
                }
            }
            ArrayList arrayList4 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList3, 10));
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                arrayList4.add(((InviteSuggestionItem.UserItem) it2.next()).getUser());
            }
            analyticsTracker.inviteSuggestionOpened(id2, arrayList2, arrayList4);
            this.hasTrackedSuggestionsViewed = true;
        }
        TextView textView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildInviteEmptyResults");
        textView.setVisibility(inviteSuggestionItems.isEmpty() ? 0 : 8);
        RecyclerView recyclerView = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.guildInviteSuggestionList");
        recyclerView.setVisibility(inviteSuggestionItems.isEmpty() ^ true ? 0 : 8);
        PrivateChannelAdapter privateChannelAdapter = this.adapter;
        if (privateChannelAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        privateChannelAdapter.setData(inviteSuggestionItems);
        PrivateChannelAdapter privateChannelAdapter2 = this.adapter;
        if (privateChannelAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        privateChannelAdapter2.setOnClick(new AnonymousClass3(viewState, invite));
        getBinding().j.configureUi(viewState.getWidgetInviteModel());
        MaterialButton materialButton = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.guildInviteShareBtn");
        materialButton.setText(getInviteLink(invite));
        getBinding().f.setOnClickListener(new AnonymousClass4(invite));
        ImageView imageView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.guildInviteSettingsEdit");
        imageView.setVisibility(viewState.getShowInviteSettings() ? 0 : 8);
        TextView textView2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildInviteNeverExpire");
        textView2.setVisibility(viewState.getShowInviteSettings() ? 0 : 8);
        TextView textView3 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildInviteNeverExpire");
        textView3.setText(GuildInviteUiHelper.getInviteLinkText(requireContext(), getViewModel().getDefaultInviteExperiment()));
    }

    private final WidgetGuildInviteShareCompactBinding getBinding() {
        return (WidgetGuildInviteShareCompactBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getInviteLink(ModelInvite modelInvite) {
        return modelInvite == null ? BuildConfig.HOST_INVITE : modelInvite.toLink(getResources(), BuildConfig.HOST_INVITE);
    }

    private final WidgetGuildInviteShareViewModel getViewModel() {
        return (WidgetGuildInviteShareViewModel) this.viewModel.getValue();
    }

    private final void initBottomSheet() {
        getBinding().j.setOnGenerateLinkListener(new AnonymousClass1());
        getBinding().j.setViewModel(getViewModel());
    }

    private final void initBottomSheetBehavior(BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehavior) {
        bottomSheetBehavior.setState(5);
        bottomSheetBehavior.addBottomSheetCallback(new AnonymousClass1());
    }

    private final void sendInvite(InviteSuggestionItem item, WidgetGuildInviteShareViewModel.ViewState.Loaded viewState, ModelInvite invite) {
        if (item instanceof InviteSuggestionItem.ChannelItem) {
            getViewModel().sendInviteToChannel(((InviteSuggestionItem.ChannelItem) item).getChannel().getId(), viewState, invite);
        } else if (item instanceof InviteSuggestionItem.UserItem) {
            getViewModel().sendInviteToUser(((InviteSuggestionItem.UserItem) item).getUser().getId(), viewState, invite);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.guildInviteSuggestionList");
        this.adapter = (PrivateChannelAdapter) companion.configure(new PrivateChannelAdapter(recyclerView));
        boolean booleanExtra = getMostRecentIntent().getBooleanExtra(WidgetGuildInviteShare.INTENT_IS_NUX_FLOW, false);
        long longExtra = getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", 0L);
        if (longExtra != 0) {
            getViewModel().selectChannel(longExtra);
        }
        setActionBarDisplayHomeAsUpEnabled(true, booleanExtra ? Integer.valueOf(DrawableCompat.getThemedDrawableRes$default(requireContext(), R.attr.ic_close_24dp, 0, 2, (Object) null)) : null, booleanExtra ? Integer.valueOf(R.string.close) : null);
        setActionBarTitle(R.string.invite_people);
        AppFragment.setOnBackPressed$default(this, new AnonymousClass1(booleanExtra), 0, 2, null);
        TextInputLayout textInputLayout = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.guildInviteShareCompactSearch");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new AnonymousClass2());
        BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehaviorFrom = BottomSheetBehavior.from(getBinding().j);
        Intrinsics3.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "BottomSheetBehavior.from…nviteSettingsBottomSheet)");
        this.bottomSheetBehavior = bottomSheetBehaviorFrom;
        if (bottomSheetBehaviorFrom == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        }
        initBottomSheetBehavior(bottomSheetBehaviorFrom);
        initBottomSheet();
        getBinding().d.setOnClickListener(new AnonymousClass3());
        getBinding().e.setOnClickListener(new AnonymousClass4());
        getBinding().f2419b.setOnClickListener(new AnonymousClass5());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<R> observableG = getViewModel().observeViewState().y(WidgetGuildInviteShareCompact$onViewBoundOrOnResume$$inlined$filterIs$1.INSTANCE).G(WidgetGuildInviteShareCompact$onViewBoundOrOnResume$$inlined$filterIs$2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
        PrivateChannelAdapter privateChannelAdapter = this.adapter;
        if (privateChannelAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle(observableG, this, privateChannelAdapter), WidgetGuildInviteShareCompact.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
