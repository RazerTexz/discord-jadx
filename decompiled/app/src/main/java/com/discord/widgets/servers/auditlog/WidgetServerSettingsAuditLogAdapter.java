package com.discord.widgets.servers.auditlog;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.databinding.WidgetServerSettingsAuditLogListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.auditlogs.AuditLogUtils;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetServerSettingsAuditLogAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005!\"#$ B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ)\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n¢\u0006\u0004\b\r\u0010\u000eR@\u0010\u0013\u001a \u0012\b\u0012\u00060\u0010j\u0002`\u0011\u0012\f\u0012\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0012\u0012\u0004\u0012\u00020\f0\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006%"}, d2 = {"Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLogAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "", "auditLogEntryItems", "", "configure", "(Ljava/util/List;)V", "Lkotlin/Function2;", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/primitives/GuildId;", "onAuditLogAvatarClicked", "Lkotlin/jvm/functions/Function2;", "getOnAuditLogAvatarClicked", "()Lkotlin/jvm/functions/Function2;", "setOnAuditLogAvatarClicked", "(Lkotlin/jvm/functions/Function2;)V", "", "ensureExpandedIsVisible", "Z", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Companion", "AuditLogEntryItem", "AuditLogEntryViewHolder", "AuditLogLoadingItem", "AuditLogLoadingViewHolder", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogAdapter extends MGRecyclerAdapterSimple<MGRecyclerDataPayload> {
    private static final int ENTRY_ITEM = 0;
    private static final int LOADING_ITEM = 1;
    private boolean ensureExpandedIsVisible;
    private Function2<? super Long, ? super Long, Unit> onAuditLogAvatarClicked;

    /* compiled from: WidgetServerSettingsAuditLogAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000b¢\u0006\u0004\b*\u0010+R\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u001b\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0010\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\nR\u0019\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\u00020\u00198\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\r\u001a\u0004\b\u001f\u0010\u000fR\u001b\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010&\u001a\u00020%8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLogAdapter$AuditLogEntryItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "", "isSelected", "Z", "()Z", "", "headerText", "Ljava/lang/CharSequence;", "getHeaderText", "()Ljava/lang/CharSequence;", "hasChangesToRender", "getHasChangesToRender", "timeStampText", "getTimeStampText", "Lcom/discord/models/member/GuildMember;", "guildMember", "Lcom/discord/models/member/GuildMember;", "getGuildMember", "()Lcom/discord/models/member/GuildMember;", "", "type", "I", "getType", "()I", "changeText", "getChangeText", "Lcom/discord/models/user/User;", "user", "Lcom/discord/models/user/User;", "getUser", "()Lcom/discord/models/user/User;", "Lcom/discord/models/domain/ModelAuditLogEntry;", "auditLogEntry", "Lcom/discord/models/domain/ModelAuditLogEntry;", "getAuditLogEntry", "()Lcom/discord/models/domain/ModelAuditLogEntry;", "<init>", "(Lcom/discord/models/domain/ModelAuditLogEntry;ZLcom/discord/models/user/User;Lcom/discord/models/member/GuildMember;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZLjava/lang/CharSequence;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class AuditLogEntryItem implements MGRecyclerDataPayload {
        private final ModelAuditLogEntry auditLogEntry;
        private final CharSequence changeText;
        private final GuildMember guildMember;
        private final boolean hasChangesToRender;
        private final CharSequence headerText;
        private final boolean isSelected;
        private final String key;
        private final CharSequence timeStampText;
        private final int type;
        private final User user;

        public AuditLogEntryItem(ModelAuditLogEntry modelAuditLogEntry, boolean z2, User user, GuildMember guildMember, CharSequence charSequence, CharSequence charSequence2, boolean z3, CharSequence charSequence3) {
            Intrinsics3.checkNotNullParameter(modelAuditLogEntry, "auditLogEntry");
            Intrinsics3.checkNotNullParameter(charSequence3, "timeStampText");
            this.auditLogEntry = modelAuditLogEntry;
            this.isSelected = z2;
            this.user = user;
            this.guildMember = guildMember;
            this.headerText = charSequence;
            this.changeText = charSequence2;
            this.hasChangesToRender = z3;
            this.timeStampText = charSequence3;
            this.key = String.valueOf(modelAuditLogEntry.getId());
        }

        public final ModelAuditLogEntry getAuditLogEntry() {
            return this.auditLogEntry;
        }

        public final CharSequence getChangeText() {
            return this.changeText;
        }

        public final GuildMember getGuildMember() {
            return this.guildMember;
        }

        public final boolean getHasChangesToRender() {
            return this.hasChangesToRender;
        }

        public final CharSequence getHeaderText() {
            return this.headerText;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final CharSequence getTimeStampText() {
            return this.timeStampText;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public final User getUser() {
            return this.user;
        }

        /* renamed from: isSelected, reason: from getter */
        public final boolean getIsSelected() {
            return this.isSelected;
        }
    }

    /* compiled from: WidgetServerSettingsAuditLogAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLogAdapter$AuditLogEntryViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLogAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;)V", "Lcom/discord/databinding/WidgetServerSettingsAuditLogListItemBinding;", "binding", "Lcom/discord/databinding/WidgetServerSettingsAuditLogListItemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLogAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class AuditLogEntryViewHolder extends MGRecyclerViewHolder<WidgetServerSettingsAuditLogAdapter, MGRecyclerDataPayload> {
        private final WidgetServerSettingsAuditLogListItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AuditLogEntryViewHolder(WidgetServerSettingsAuditLogAdapter widgetServerSettingsAuditLogAdapter) {
            super(R.layout.widget_server_settings_audit_log_list_item, widgetServerSettingsAuditLogAdapter);
            Intrinsics3.checkNotNullParameter(widgetServerSettingsAuditLogAdapter, "adapter");
            View view = this.itemView;
            int i = R.id.audit_log_listitem_action_container;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.audit_log_listitem_action_container);
            if (frameLayout != null) {
                i = R.id.audit_log_listitem_actiontype_image;
                ImageView imageView = (ImageView) view.findViewById(R.id.audit_log_listitem_actiontype_image);
                if (imageView != null) {
                    i = R.id.audit_log_listitem_arrow;
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.audit_log_listitem_arrow);
                    if (imageView2 != null) {
                        i = R.id.audit_log_listitem_avatar;
                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.audit_log_listitem_avatar);
                        if (simpleDraweeView != null) {
                            i = R.id.audit_log_listitem_change_text;
                            TextView textView = (TextView) view.findViewById(R.id.audit_log_listitem_change_text);
                            if (textView != null) {
                                i = R.id.audit_log_listitem_date_text;
                                TextView textView2 = (TextView) view.findViewById(R.id.audit_log_listitem_date_text);
                                if (textView2 != null) {
                                    i = R.id.audit_log_listitem_header_text;
                                    TextView textView3 = (TextView) view.findViewById(R.id.audit_log_listitem_header_text);
                                    if (textView3 != null) {
                                        i = R.id.audit_log_listitem_targettype_image;
                                        ImageView imageView3 = (ImageView) view.findViewById(R.id.audit_log_listitem_targettype_image);
                                        if (imageView3 != null) {
                                            i = R.id.audit_log_listitem_top_container;
                                            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.audit_log_listitem_top_container);
                                            if (relativeLayout != null) {
                                                WidgetServerSettingsAuditLogListItemBinding widgetServerSettingsAuditLogListItemBinding = new WidgetServerSettingsAuditLogListItemBinding((CardView) view, frameLayout, imageView, imageView2, simpleDraweeView, textView, textView2, textView3, imageView3, relativeLayout);
                                                Intrinsics3.checkNotNullExpressionValue(widgetServerSettingsAuditLogListItemBinding, "WidgetServerSettingsAudi…temBinding.bind(itemView)");
                                                this.binding = widgetServerSettingsAuditLogListItemBinding;
                                                return;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ WidgetServerSettingsAuditLogAdapter access$getAdapter$p(AuditLogEntryViewHolder auditLogEntryViewHolder) {
            return (WidgetServerSettingsAuditLogAdapter) auditLogEntryViewHolder.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
            onConfigure2(i, mGRecyclerDataPayload);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            AuditLogEntryItem auditLogEntryItem = (AuditLogEntryItem) data;
            ModelAuditLogEntry auditLogEntry = auditLogEntryItem.getAuditLogEntry();
            User user = auditLogEntryItem.getUser();
            GuildMember guildMember = auditLogEntryItem.getGuildMember();
            ImageView imageView = this.binding.f2542b;
            AuditLogUtils auditLogUtils = AuditLogUtils.INSTANCE;
            imageView.setImageResource(auditLogUtils.getActionTypeImage(auditLogEntry.getActionTypeId()));
            ImageView imageView2 = this.binding.h;
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            imageView2.setImageResource(auditLogUtils.getTargetTypeImage(view, auditLogEntry.getActionTypeId()));
            SimpleDraweeView simpleDraweeView = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.auditLogListitemAvatar");
            IconUtils.setIcon$default(simpleDraweeView, user, 0, null, null, guildMember, 28, null);
            this.binding.d.setOnClickListener(new WidgetServerSettingsAuditLogAdapter2(this, user, guildMember));
            TextView textView = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.auditLogListitemDateText");
            textView.setText(auditLogEntryItem.getTimeStampText());
            TextView textView2 = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.auditLogListitemHeaderText");
            CharSequence headerText = auditLogEntryItem.getHeaderText();
            textView2.setText(headerText != null ? FormatUtils.l(headerText, new Object[0], null, 2) : null);
            TextView textView3 = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.auditLogListitemChangeText");
            textView3.setVisibility(auditLogEntryItem.getIsSelected() && auditLogEntryItem.getHasChangesToRender() ? 0 : 8);
            ImageView imageView3 = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.auditLogListitemArrow");
            imageView3.setVisibility(auditLogEntryItem.getHasChangesToRender() ? 0 : 4);
            if (auditLogEntryItem.getIsSelected() && auditLogEntryItem.getHasChangesToRender()) {
                TextView textView4 = this.binding.e;
                Intrinsics3.checkNotNullExpressionValue(textView4, "binding.auditLogListitemChangeText");
                textView4.setText(auditLogEntryItem.getChangeText());
                this.binding.c.setImageResource(R.drawable.ic_chevron_down_grey_12dp);
                RelativeLayout relativeLayout = this.binding.i;
                View view2 = this.itemView;
                Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
                relativeLayout.setBackgroundColor(ColorCompat.getThemedColor(view2, R.attr.primary_700_alpha_60));
                if (WidgetServerSettingsAuditLogAdapter.access$getEnsureExpandedIsVisible$p((WidgetServerSettingsAuditLogAdapter) this.adapter)) {
                    WidgetServerSettingsAuditLogAdapter.access$setEnsureExpandedIsVisible$p((WidgetServerSettingsAuditLogAdapter) this.adapter, false);
                    ((WidgetServerSettingsAuditLogAdapter) this.adapter).getRecycler().post(new WidgetServerSettingsAuditLogAdapter3(this));
                }
            } else {
                this.binding.c.setImageResource(R.drawable.ic_chevron_right_grey_12dp);
                RelativeLayout relativeLayout2 = this.binding.i;
                View view3 = this.itemView;
                Intrinsics3.checkNotNullExpressionValue(view3, "itemView");
                relativeLayout2.setBackgroundColor(ColorCompat.getThemedColor(view3, R.attr.primary_630));
            }
            this.itemView.setOnClickListener(new WidgetServerSettingsAuditLogAdapter4(this, data));
        }
    }

    /* compiled from: WidgetServerSettingsAuditLogAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLogAdapter$AuditLogLoadingItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", "type", "I", "getType", "()I", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class AuditLogLoadingItem implements MGRecyclerDataPayload {
        private final int type = 1;
        private final String key = "loading";

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }
    }

    /* compiled from: WidgetServerSettingsAuditLogAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLogAdapter$AuditLogLoadingViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLogAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "adapter", "<init>", "(Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLogAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class AuditLogLoadingViewHolder extends MGRecyclerViewHolder<WidgetServerSettingsAuditLogAdapter, MGRecyclerDataPayload> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AuditLogLoadingViewHolder(WidgetServerSettingsAuditLogAdapter widgetServerSettingsAuditLogAdapter) {
            super(R.layout.widget_server_settings_audit_log_loading_listitem, widgetServerSettingsAuditLogAdapter);
            Intrinsics3.checkNotNullParameter(widgetServerSettingsAuditLogAdapter, "adapter");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsAuditLogAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        this.onAuditLogAvatarClicked = WidgetServerSettingsAuditLogAdapter5.INSTANCE;
    }

    public static final /* synthetic */ boolean access$getEnsureExpandedIsVisible$p(WidgetServerSettingsAuditLogAdapter widgetServerSettingsAuditLogAdapter) {
        return widgetServerSettingsAuditLogAdapter.ensureExpandedIsVisible;
    }

    public static final /* synthetic */ void access$setEnsureExpandedIsVisible$p(WidgetServerSettingsAuditLogAdapter widgetServerSettingsAuditLogAdapter, boolean z2) {
        widgetServerSettingsAuditLogAdapter.ensureExpandedIsVisible = z2;
    }

    public final void configure(List<? extends MGRecyclerDataPayload> auditLogEntryItems) {
        Intrinsics3.checkNotNullParameter(auditLogEntryItems, "auditLogEntryItems");
        setData(auditLogEntryItems);
    }

    public final Function2<Long, Long, Unit> getOnAuditLogAvatarClicked() {
        return this.onAuditLogAvatarClicked;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnAuditLogAvatarClicked(Function2<? super Long, ? super Long, Unit> function2) {
        Intrinsics3.checkNotNullParameter(function2, "<set-?>");
        this.onAuditLogAvatarClicked = function2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, MGRecyclerDataPayload> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new AuditLogEntryViewHolder(this);
        }
        if (viewType == 1) {
            return new AuditLogLoadingViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
