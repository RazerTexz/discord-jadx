package com.discord.widgets.servers.auditlog;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetServerSettingsAuditLogFilterActionListitemBinding;
import com.discord.databinding.WidgetServerSettingsAuditLogFilterUserListitemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.auditlogs.AuditLogUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.views.CheckedSetting;
import com.discord.views.user.SettingsMemberView;
import com.google.android.material.radiobutton.MaterialRadioButton;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetServerSettingsAuditLogFilterAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005!\"#$ B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ)\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ)\u0010\u000f\u001a\u00020\r2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000f\u0010\u0010R\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0011R@\u0010\u0016\u001a \u0012\b\u0012\u00060\u0013j\u0002`\u0014\u0012\f\u0012\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u0015\u0012\u0004\u0012\u00020\r0\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006%"}, d2 = {"Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLogFilterAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "", "listItems", "Lkotlin/Function0;", "", "onFilterSelectedCallback", "configure", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;)V", "Lkotlin/jvm/functions/Function0;", "Lkotlin/Function2;", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/primitives/GuildId;", "onAuditLogAvatarClicked", "Lkotlin/jvm/functions/Function2;", "getOnAuditLogAvatarClicked", "()Lkotlin/jvm/functions/Function2;", "setOnAuditLogAvatarClicked", "(Lkotlin/jvm/functions/Function2;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Companion", "AuditLogActionFilterItem", "AuditLogFilterActionViewHolder", "AuditLogFilterUserViewHolder", "AuditLogUserFilterItem", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilterAdapter extends MGRecyclerAdapterSimple<MGRecyclerDataPayload> {
    public static final int FILTER_TYPE_ACTION = 1;
    public static final int FILTER_TYPE_USER = 0;
    private Function2<? super Long, ? super Long, Unit> onAuditLogAvatarClicked;
    private Function0<Unit> onFilterSelectedCallback;

    /* compiled from: WidgetServerSettingsAuditLogFilterAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u00020\u00078\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u001c\u0010\u0012\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLogFilterAdapter$AuditLogActionFilterItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "", "actionId", "I", "getActionId", "()I", "type", "getType", "", "isChecked", "Z", "()Z", "key", "getKey", "<init>", "(ILjava/lang/String;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class AuditLogActionFilterItem implements MGRecyclerDataPayload {
        private final int actionId;
        private final boolean isChecked;
        private final String key;
        private final String text;
        private final int type;

        public AuditLogActionFilterItem(int i, String str, boolean z2) {
            Intrinsics3.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            this.actionId = i;
            this.text = str;
            this.isChecked = z2;
            this.type = 1;
            this.key = String.valueOf(i);
        }

        public final int getActionId() {
            return this.actionId;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final String getText() {
            return this.text;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        /* renamed from: isChecked, reason: from getter */
        public final boolean getIsChecked() {
            return this.isChecked;
        }
    }

    /* compiled from: WidgetServerSettingsAuditLogFilterAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLogFilterAdapter$AuditLogFilterActionViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLogFilterAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;)V", "Lcom/discord/databinding/WidgetServerSettingsAuditLogFilterActionListitemBinding;", "binding", "Lcom/discord/databinding/WidgetServerSettingsAuditLogFilterActionListitemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLogFilterAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class AuditLogFilterActionViewHolder extends MGRecyclerViewHolder<WidgetServerSettingsAuditLogFilterAdapter, MGRecyclerDataPayload> {
        private final WidgetServerSettingsAuditLogFilterActionListitemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AuditLogFilterActionViewHolder(WidgetServerSettingsAuditLogFilterAdapter widgetServerSettingsAuditLogFilterAdapter) {
            super(R.layout.widget_server_settings_audit_log_filter_action_listitem, widgetServerSettingsAuditLogFilterAdapter);
            Intrinsics3.checkNotNullParameter(widgetServerSettingsAuditLogFilterAdapter, "adapter");
            View view = this.itemView;
            int i = R.id.audit_log_filter_cs;
            CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.audit_log_filter_cs);
            if (checkedSetting != null) {
                i = R.id.audit_log_filter_image_action;
                ImageView imageView = (ImageView) view.findViewById(R.id.audit_log_filter_image_action);
                if (imageView != null) {
                    i = R.id.audit_log_filter_image_container;
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.audit_log_filter_image_container);
                    if (frameLayout != null) {
                        i = R.id.audit_log_filter_image_target;
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.audit_log_filter_image_target);
                        if (imageView2 != null) {
                            WidgetServerSettingsAuditLogFilterActionListitemBinding widgetServerSettingsAuditLogFilterActionListitemBinding = new WidgetServerSettingsAuditLogFilterActionListitemBinding((LinearLayout) view, checkedSetting, imageView, frameLayout, imageView2);
                            Intrinsics3.checkNotNullExpressionValue(widgetServerSettingsAuditLogFilterActionListitemBinding, "WidgetServerSettingsAudi…temBinding.bind(itemView)");
                            this.binding = widgetServerSettingsAuditLogFilterActionListitemBinding;
                            return;
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ WidgetServerSettingsAuditLogFilterAdapter access$getAdapter$p(AuditLogFilterActionViewHolder auditLogFilterActionViewHolder) {
            return (WidgetServerSettingsAuditLogFilterAdapter) auditLogFilterActionViewHolder.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
            onConfigure2(i, mGRecyclerDataPayload);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            AuditLogActionFilterItem auditLogActionFilterItem = (AuditLogActionFilterItem) data;
            ImageView imageView = this.binding.d;
            AuditLogUtils auditLogUtils = AuditLogUtils.INSTANCE;
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            imageView.setImageResource(auditLogUtils.getTargetTypeImage(view, auditLogActionFilterItem.getActionId()));
            this.binding.c.setImageResource(auditLogUtils.getActionTypeImage(auditLogActionFilterItem.getActionId()));
            this.binding.f2540b.setText(auditLogActionFilterItem.getText());
            CheckedSetting checkedSetting = this.binding.f2540b;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.auditLogFilterCs");
            checkedSetting.setChecked(auditLogActionFilterItem.getIsChecked());
            this.binding.f2540b.setOnCheckedListener(new WidgetServerSettingsAuditLogFilterAdapter2(this, auditLogActionFilterItem));
        }
    }

    /* compiled from: WidgetServerSettingsAuditLogFilterAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLogFilterAdapter$AuditLogFilterUserViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLogFilterAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;)V", "Lcom/discord/databinding/WidgetServerSettingsAuditLogFilterUserListitemBinding;", "binding", "Lcom/discord/databinding/WidgetServerSettingsAuditLogFilterUserListitemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLogFilterAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class AuditLogFilterUserViewHolder extends MGRecyclerViewHolder<WidgetServerSettingsAuditLogFilterAdapter, MGRecyclerDataPayload> {
        private final WidgetServerSettingsAuditLogFilterUserListitemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AuditLogFilterUserViewHolder(WidgetServerSettingsAuditLogFilterAdapter widgetServerSettingsAuditLogFilterAdapter) {
            super(R.layout.widget_server_settings_audit_log_filter_user_listitem, widgetServerSettingsAuditLogFilterAdapter);
            Intrinsics3.checkNotNullParameter(widgetServerSettingsAuditLogFilterAdapter, "adapter");
            View view = this.itemView;
            int i = R.id.audit_log_filter_radio_button;
            MaterialRadioButton materialRadioButton = (MaterialRadioButton) view.findViewById(R.id.audit_log_filter_radio_button);
            if (materialRadioButton != null) {
                i = R.id.item_icon;
                ImageView imageView = (ImageView) view.findViewById(R.id.item_icon);
                if (imageView != null) {
                    i = R.id.non_member_text;
                    TextView textView = (TextView) view.findViewById(R.id.non_member_text);
                    if (textView != null) {
                        i = R.id.settings_member_view;
                        SettingsMemberView settingsMemberView = (SettingsMemberView) view.findViewById(R.id.settings_member_view);
                        if (settingsMemberView != null) {
                            WidgetServerSettingsAuditLogFilterUserListitemBinding widgetServerSettingsAuditLogFilterUserListitemBinding = new WidgetServerSettingsAuditLogFilterUserListitemBinding((FrameLayout) view, materialRadioButton, imageView, textView, settingsMemberView);
                            Intrinsics3.checkNotNullExpressionValue(widgetServerSettingsAuditLogFilterUserListitemBinding, "WidgetServerSettingsAudi…temBinding.bind(itemView)");
                            this.binding = widgetServerSettingsAuditLogFilterUserListitemBinding;
                            return;
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ WidgetServerSettingsAuditLogFilterAdapter access$getAdapter$p(AuditLogFilterUserViewHolder auditLogFilterUserViewHolder) {
            return (WidgetServerSettingsAuditLogFilterAdapter) auditLogFilterUserViewHolder.adapter;
        }

        public static final /* synthetic */ WidgetServerSettingsAuditLogFilterUserListitemBinding access$getBinding$p(AuditLogFilterUserViewHolder auditLogFilterUserViewHolder) {
            return auditLogFilterUserViewHolder.binding;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
            onConfigure2(i, mGRecyclerDataPayload);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            AuditLogUserFilterItem auditLogUserFilterItem = (AuditLogUserFilterItem) data;
            User user = auditLogUserFilterItem.getUser();
            boolean z2 = (auditLogUserFilterItem.getId() == 0 || user == null) ? false : true;
            SettingsMemberView settingsMemberView = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(settingsMemberView, "binding.settingsMemberView");
            settingsMemberView.setVisibility(z2 ? 0 : 8);
            TextView textView = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.nonMemberText");
            textView.setVisibility(z2 ^ true ? 0 : 8);
            ImageView imageView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.itemIcon");
            imageView.setVisibility(z2 ^ true ? 0 : 8);
            if (z2) {
                SettingsMemberView settingsMemberView2 = this.binding.e;
                Intrinsics3.checkNotNull(user);
                settingsMemberView2.a(user, auditLogUserFilterItem.getGuildMember());
            } else {
                TextView textView2 = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.nonMemberText");
                CharSequence text = auditLogUserFilterItem.getText();
                if (text == null) {
                    text = "";
                }
                textView2.setText(text);
            }
            MaterialRadioButton materialRadioButton = this.binding.f2541b;
            Intrinsics3.checkNotNullExpressionValue(materialRadioButton, "binding.auditLogFilterRadioButton");
            materialRadioButton.setChecked(auditLogUserFilterItem.getIsChecked());
            this.binding.f2541b.setOnCheckedChangeListener(new WidgetServerSettingsAuditLogFilterAdapter3(this, auditLogUserFilterItem));
            this.itemView.setOnClickListener(new WidgetServerSettingsAuditLogFilterAdapter4(this));
        }
    }

    /* compiled from: WidgetServerSettingsAuditLogFilterAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0007\u0018\u00002\u00020\u0001B?\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b(\u0010)R\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0012\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001dR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001b\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLogFilterAdapter$AuditLogUserFilterItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", "type", "I", "getType", "()I", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "Lcom/discord/models/user/User;", "user", "Lcom/discord/models/user/User;", "getUser", "()Lcom/discord/models/user/User;", "", ModelAuditLogEntry.CHANGE_KEY_ID, "J", "getId", "()J", "discriminator", "Ljava/lang/Integer;", "getDiscriminator", "()Ljava/lang/Integer;", "", "isChecked", "Z", "()Z", "Lcom/discord/models/member/GuildMember;", "guildMember", "Lcom/discord/models/member/GuildMember;", "getGuildMember", "()Lcom/discord/models/member/GuildMember;", "", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "Ljava/lang/CharSequence;", "getText", "()Ljava/lang/CharSequence;", "<init>", "(Lcom/discord/models/user/User;Lcom/discord/models/member/GuildMember;JLjava/lang/CharSequence;Ljava/lang/Integer;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class AuditLogUserFilterItem implements MGRecyclerDataPayload {
        private final Integer discriminator;
        private final GuildMember guildMember;
        private final long id;
        private final boolean isChecked;
        private final String key;
        private final CharSequence text;
        private final int type;
        private final User user;

        public AuditLogUserFilterItem(User user, GuildMember guildMember, long j, CharSequence charSequence, Integer num, boolean z2) {
            this.user = user;
            this.guildMember = guildMember;
            this.id = j;
            this.text = charSequence;
            this.discriminator = num;
            this.isChecked = z2;
            this.key = String.valueOf(j);
        }

        public final Integer getDiscriminator() {
            return this.discriminator;
        }

        public final GuildMember getGuildMember() {
            return this.guildMember;
        }

        public final long getId() {
            return this.id;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final CharSequence getText() {
            return this.text;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public final User getUser() {
            return this.user;
        }

        /* renamed from: isChecked, reason: from getter */
        public final boolean getIsChecked() {
            return this.isChecked;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsAuditLogFilterAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        this.onAuditLogAvatarClicked = WidgetServerSettingsAuditLogFilterAdapter5.INSTANCE;
    }

    public static final /* synthetic */ Function0 access$getOnFilterSelectedCallback$p(WidgetServerSettingsAuditLogFilterAdapter widgetServerSettingsAuditLogFilterAdapter) {
        return widgetServerSettingsAuditLogFilterAdapter.onFilterSelectedCallback;
    }

    public static final /* synthetic */ void access$setOnFilterSelectedCallback$p(WidgetServerSettingsAuditLogFilterAdapter widgetServerSettingsAuditLogFilterAdapter, Function0 function0) {
        widgetServerSettingsAuditLogFilterAdapter.onFilterSelectedCallback = function0;
    }

    public final void configure(List<? extends MGRecyclerDataPayload> listItems, Function0<Unit> onFilterSelectedCallback) {
        Intrinsics3.checkNotNullParameter(listItems, "listItems");
        Intrinsics3.checkNotNullParameter(onFilterSelectedCallback, "onFilterSelectedCallback");
        this.onFilterSelectedCallback = onFilterSelectedCallback;
        setData(listItems);
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
            return new AuditLogFilterUserViewHolder(this);
        }
        if (viewType == 1) {
            return new AuditLogFilterActionViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
