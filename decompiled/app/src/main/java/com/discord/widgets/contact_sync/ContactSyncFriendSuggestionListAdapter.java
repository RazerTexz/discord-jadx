package com.discord.widgets.contact_sync;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.api.friendsuggestions.FriendSuggestion;
import com.discord.api.friendsuggestions.FriendSuggestionReason;
import com.discord.api.user.User;
import com.discord.databinding.ViewSelectableFriendSuggestionBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.nullserializable.NullSerializable;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.contact_sync.WidgetContactSyncViewModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.checkbox.MaterialCheckBox;
import d0.g0.StringNumberConversions;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: ContactSyncFriendSuggestionListAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR4\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/contact_sync/ContactSyncFriendSuggestionListAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Item;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lkotlin/Function2;", "", "", "", "onClickFriendSuggestion", "Lkotlin/jvm/functions/Function2;", "getOnClickFriendSuggestion", "()Lkotlin/jvm/functions/Function2;", "setOnClickFriendSuggestion", "(Lkotlin/jvm/functions/Function2;)V", "spacing", "I", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "ItemFriendSuggestion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ContactSyncFriendSuggestionListAdapter extends MGRecyclerAdapterSimple<WidgetContactSyncViewModel.Item> {
    private Function2<? super Long, ? super Boolean, Unit> onClickFriendSuggestion;
    private final int spacing;

    /* compiled from: ContactSyncFriendSuggestionListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0015¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/contact_sync/ContactSyncFriendSuggestionListAdapter$ItemFriendSuggestion;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/contact_sync/ContactSyncFriendSuggestionListAdapter;", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Item;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$Item;)V", "Lcom/discord/databinding/ViewSelectableFriendSuggestionBinding;", "binding", "Lcom/discord/databinding/ViewSelectableFriendSuggestionBinding;", "adapter", "<init>", "(Lcom/discord/widgets/contact_sync/ContactSyncFriendSuggestionListAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ItemFriendSuggestion extends MGRecyclerViewHolder<ContactSyncFriendSuggestionListAdapter, WidgetContactSyncViewModel.Item> {
        private final ViewSelectableFriendSuggestionBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemFriendSuggestion(ContactSyncFriendSuggestionListAdapter contactSyncFriendSuggestionListAdapter) {
            super(R.layout.view_selectable_friend_suggestion, contactSyncFriendSuggestionListAdapter);
            Intrinsics3.checkNotNullParameter(contactSyncFriendSuggestionListAdapter, "adapter");
            View view = this.itemView;
            int i = R.id.friend_suggestion_avatar;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.friend_suggestion_avatar);
            if (simpleDraweeView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R.id.friend_suggestion_discriminator;
                TextView textView = (TextView) view.findViewById(R.id.friend_suggestion_discriminator);
                if (textView != null) {
                    i = R.id.friend_suggestion_name;
                    TextView textView2 = (TextView) view.findViewById(R.id.friend_suggestion_name);
                    if (textView2 != null) {
                        i = R.id.friend_suggestion_nickname;
                        TextView textView3 = (TextView) view.findViewById(R.id.friend_suggestion_nickname);
                        if (textView3 != null) {
                            i = R.id.friend_suggestion_selected;
                            MaterialCheckBox materialCheckBox = (MaterialCheckBox) view.findViewById(R.id.friend_suggestion_selected);
                            if (materialCheckBox != null) {
                                ViewSelectableFriendSuggestionBinding viewSelectableFriendSuggestionBinding = new ViewSelectableFriendSuggestionBinding(constraintLayout, simpleDraweeView, constraintLayout, textView, textView2, textView3, materialCheckBox);
                                Intrinsics3.checkNotNullExpressionValue(viewSelectableFriendSuggestionBinding, "ViewSelectableFriendSugg…ionBinding.bind(itemView)");
                                this.binding = viewSelectableFriendSuggestionBinding;
                                return;
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ ContactSyncFriendSuggestionListAdapter access$getAdapter$p(ItemFriendSuggestion itemFriendSuggestion) {
            return (ContactSyncFriendSuggestionListAdapter) itemFriendSuggestion.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetContactSyncViewModel.Item item) {
            onConfigure2(i, item);
        }

        @SuppressLint({"SetTextI18n"})
        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, WidgetContactSyncViewModel.Item data) {
            Object next;
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            WidgetContactSyncViewModel.Item.FriendSuggestionItem friendSuggestionItem = (WidgetContactSyncViewModel.Item.FriendSuggestionItem) data;
            FriendSuggestion suggestion = friendSuggestionItem.getSuggestion();
            User suggestedUser = suggestion.getSuggestedUser();
            ConstraintLayout constraintLayout = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.friendSuggestionContainer");
            int paddingLeft = constraintLayout.getPaddingLeft();
            ConstraintLayout constraintLayout2 = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.friendSuggestionContainer");
            constraintLayout.setPadding(paddingLeft, 0, constraintLayout2.getPaddingRight(), ContactSyncFriendSuggestionListAdapter.access$getSpacing$p((ContactSyncFriendSuggestionListAdapter) this.adapter));
            TextView textView = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.friendSuggestionName");
            textView.setText(suggestedUser.getUsername());
            TextView textView2 = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.friendSuggestionDiscriminator");
            textView2.setText(MentionUtils.CHANNELS_CHAR + suggestedUser.getDiscriminator());
            Iterator<T> it = suggestion.a().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (Intrinsics3.areEqual(((FriendSuggestionReason) next).getPlatformType(), "contacts")) {
                        break;
                    }
                }
            }
            FriendSuggestionReason friendSuggestionReason = (FriendSuggestionReason) next;
            String name = friendSuggestionReason != null ? friendSuggestionReason.getName() : null;
            if (name == null) {
                TextView textView3 = this.binding.f;
                Intrinsics3.checkNotNullExpressionValue(textView3, "binding.friendSuggestionNickname");
                textView3.setVisibility(8);
            } else {
                TextView textView4 = this.binding.f;
                Intrinsics3.checkNotNullExpressionValue(textView4, "binding.friendSuggestionNickname");
                textView4.setText(name);
                TextView textView5 = this.binding.f;
                Intrinsics3.checkNotNullExpressionValue(textView5, "binding.friendSuggestionNickname");
                textView5.setVisibility(StringsJVM.isBlank(name) ^ true ? 0 : 8);
            }
            MaterialCheckBox materialCheckBox = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(materialCheckBox, "binding.friendSuggestionSelected");
            materialCheckBox.setChecked(friendSuggestionItem.getSelected());
            SimpleDraweeView simpleDraweeView = this.binding.f2207b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.friendSuggestionAvatar");
            Long lValueOf = Long.valueOf(suggestedUser.getId());
            NullSerializable<String> nullSerializableA = suggestedUser.a();
            IconUtils.setIcon$default(simpleDraweeView, IconUtils.getForUser$default(lValueOf, nullSerializableA != null ? nullSerializableA.a() : null, StringNumberConversions.toIntOrNull(suggestedUser.getDiscriminator()), false, null, 16, null), R.dimen.avatar_size_standard, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
            this.binding.g.setOnCheckedChangeListener(new ContactSyncFriendSuggestionListAdapter2(this, suggestion.getSuggestedUser().getId()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactSyncFriendSuggestionListAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        this.onClickFriendSuggestion = ContactSyncFriendSuggestionListAdapter3.INSTANCE;
        Context context = recyclerView.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "recycler.context");
        this.spacing = context.getResources().getDimensionPixelSize(R.dimen.suggestion_spacing);
    }

    public static final /* synthetic */ int access$getSpacing$p(ContactSyncFriendSuggestionListAdapter contactSyncFriendSuggestionListAdapter) {
        return contactSyncFriendSuggestionListAdapter.spacing;
    }

    public final Function2<Long, Boolean, Unit> getOnClickFriendSuggestion() {
        return this.onClickFriendSuggestion;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnClickFriendSuggestion(Function2<? super Long, ? super Boolean, Unit> function2) {
        Intrinsics3.checkNotNullParameter(function2, "<set-?>");
        this.onClickFriendSuggestion = function2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, WidgetContactSyncViewModel.Item> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        return new ItemFriendSuggestion(this);
    }
}
