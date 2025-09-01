package com.discord.widgets.channels.permissions;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.IdRes;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChannelSettingsEditPermissionsBinding;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.channel.ChannelPermissionUtils;
import com.discord.utilities.channel.ChannelPermissionUtils2;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.spans.TypefaceSpanCompat;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.TernaryCheckBox;
import com.discord.views.user.SettingsMemberView;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissionsModel;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import d0.LazyJVM;
import d0.t.Sets5;
import d0.t.SetsJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.functions.Action2;

/* compiled from: WidgetChannelSettingsEditPermissions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0007\u0018\u0000 C2\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\bB\u0010'J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J1\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\u0014\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\n\u0010\u0013\u001a\u00060\u0011j\u0002`\u00122\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0018\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001d\u001a\u00020\u00042\n\u0010\u001b\u001a\u00060\u0011j\u0002`\u001a2\u0006\u0010\u001c\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ+\u0010 \u001a\u00020\u00042\n\u0010\u001b\u001a\u00060\u0011j\u0002`\u001a2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\tH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0004H\u0016¢\u0006\u0004\b&\u0010'R\u001d\u0010\u001b\u001a\u00020\u00118B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001d\u00101\u001a\u00020,8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0018\u00103\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u001d\u00107\u001a\u00020\u00118B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010)\u001a\u0004\b6\u0010+R\u001d\u0010\u001f\u001a\u00020\t8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010)\u001a\u0004\b9\u0010:R\u001d\u0010\u001c\u001a\u00020\u00118B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010)\u001a\u0004\b<\u0010+R#\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00070=8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010)\u001a\u0004\b?\u0010@¨\u0006D"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsEditPermissions;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsEditPermissionsModel;", "model", "", "configureUI", "(Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsEditPermissionsModel;)V", "Lcom/discord/views/TernaryCheckBox;", "checkBox", "", "channelType", "", "isEveryoneRole", "Lcom/discord/utilities/channel/PermissionLabelOverrides;", "labels", "updateCheckboxLabels", "(Lcom/discord/views/TernaryCheckBox;IZLcom/discord/utilities/channel/PermissionLabelOverrides;)V", "", "Lcom/discord/api/permission/PermissionBit;", "permission", "setupPermissionEnabledState", "(Lcom/discord/views/TernaryCheckBox;JLcom/discord/widgets/channels/permissions/WidgetChannelSettingsEditPermissionsModel;)V", "Lcom/discord/api/permission/PermissionOverwrite;", "permissionOverwrite", "setupPermissionCheckedState", "(Lcom/discord/views/TernaryCheckBox;Lcom/discord/api/permission/PermissionOverwrite;)V", "Lcom/discord/primitives/ChannelId;", "channelId", "targetId", "deletePermissionOverwrites", "(JJ)V", "type", "updatePermissionOverwrites", "(JJI)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "channelId$delegate", "Lkotlin/Lazy;", "getChannelId", "()J", "Lcom/discord/databinding/WidgetChannelSettingsEditPermissionsBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetChannelSettingsEditPermissionsBinding;", "binding", "Lcom/discord/utilities/stateful/StatefulViews;", "state", "Lcom/discord/utilities/stateful/StatefulViews;", "guildId$delegate", "getGuildId", "guildId", "type$delegate", "getType", "()I", "targetId$delegate", "getTargetId", "", "permissionCheckboxes$delegate", "getPermissionCheckboxes", "()Ljava/util/List;", "permissionCheckboxes", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelSettingsEditPermissions extends AppFragment {
    private static final String INTENT_EXTRA_CHANNEL_ID = "INTENT_EXTRA_CHANNEL_ID";
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String INTENT_EXTRA_TARGET_ID = "INTENT_EXTRA_TARGET_ID";
    private static final String INTENT_EXTRA_TYPE = "INTENT_EXTRA_TYPE";
    public static final int TYPE_ROLE = 1;
    public static final int TYPE_USER = 0;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* renamed from: permissionCheckboxes$delegate, reason: from kotlin metadata */
    private final Lazy permissionCheckboxes;
    private StatefulViews state;

    /* renamed from: targetId$delegate, reason: from kotlin metadata */
    private final Lazy targetId;

    /* renamed from: type$delegate, reason: from kotlin metadata */
    private final Lazy type;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetChannelSettingsEditPermissions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelSettingsEditPermissionsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<Long> STAGE_HIDDEN_PERMISSIONS = Sets5.setOf((Object[]) new Long[]{512L, 256L, Long.valueOf(Permission.SPEAK), Long.valueOf(Permission.USE_VAD)});
    private static final Set<Long> STAGE_DISABLED_PERMISSIONS = SetsJVM.setOf(Long.valueOf(Permission.REQUEST_TO_SPEAK));

    /* compiled from: WidgetChannelSettingsEditPermissions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\"\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b%\u0010&J7\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u00020\u00042\b\b\u0001\u0010\r\u001a\u00020\bH\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0014\u001a\u00020\n*\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0001\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J/\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00118\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00118\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u00118\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00118\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001aR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010 R\u0016\u0010\"\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010$\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b$\u0010#¨\u0006'"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsEditPermissions$Companion;", "", "Landroid/content/Context;", "context", "", "guildId", "channelId", "targetId", "", "type", "", "create", "(Landroid/content/Context;JJJI)V", "permissionSettingId", "getPermission", "(I)J", "Landroid/widget/TextView;", "", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "fontResId", "setTextWithFont", "(Landroid/widget/TextView;Ljava/lang/String;I)V", "createForRole", "(Landroid/content/Context;JJJ)V", "createForUser", WidgetChannelSettingsEditPermissions.INTENT_EXTRA_CHANNEL_ID, "Ljava/lang/String;", "INTENT_EXTRA_GUILD_ID", "INTENT_EXTRA_TARGET_ID", WidgetChannelSettingsEditPermissions.INTENT_EXTRA_TYPE, "", "STAGE_DISABLED_PERMISSIONS", "Ljava/util/Set;", "STAGE_HIDDEN_PERMISSIONS", "TYPE_ROLE", "I", "TYPE_USER", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ long access$getPermission(Companion companion, int i) {
            return companion.getPermission(i);
        }

        public static final /* synthetic */ void access$setTextWithFont(Companion companion, TextView textView, String str, int i) {
            companion.setTextWithFont(textView, str, i);
        }

        private final void create(Context context, long guildId, long channelId, long targetId, int type) {
            Intent intent = new Intent();
            intent.putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            intent.putExtra(WidgetChannelSettingsEditPermissions.INTENT_EXTRA_CHANNEL_ID, channelId);
            intent.putExtra("INTENT_EXTRA_TARGET_ID", targetId);
            intent.putExtra(WidgetChannelSettingsEditPermissions.INTENT_EXTRA_TYPE, type);
            AppScreen2.d(context, WidgetChannelSettingsEditPermissions.class, intent);
        }

        @SuppressLint({"NonConstantResourceId"})
        private final long getPermission(@IdRes int permissionSettingId) {
            switch (permissionSettingId) {
                case R.id.channel_permission_events_manage_events /* 2131362385 */:
                    return Permission.MANAGE_EVENTS;
                case R.id.channel_permission_general_create_instant_invite /* 2131362386 */:
                    return 1L;
                case R.id.channel_permission_general_manage_channel /* 2131362387 */:
                    return 16L;
                case R.id.channel_permission_general_manage_permissions /* 2131362388 */:
                    return Permission.MANAGE_ROLES;
                case R.id.channel_permission_general_manage_threads /* 2131362389 */:
                    return Permission.MANAGE_THREADS;
                case R.id.channel_permission_general_manage_webhooks /* 2131362390 */:
                    return Permission.MANAGE_WEBHOOKS;
                case R.id.channel_permission_owner_view /* 2131362391 */:
                default:
                    throw new IllegalArgumentException(outline.q("Invalid ID: ", permissionSettingId));
                case R.id.channel_permission_stage_request_to_speak /* 2131362392 */:
                    return Permission.REQUEST_TO_SPEAK;
                case R.id.channel_permission_text_add_reactions /* 2131362393 */:
                    return 64L;
                case R.id.channel_permission_text_attach_files /* 2131362394 */:
                    return Permission.ATTACH_FILES;
                case R.id.channel_permission_text_create_private_threads /* 2131362395 */:
                    return Permission.CREATE_PRIVATE_THREADS;
                case R.id.channel_permission_text_create_public_threads /* 2131362396 */:
                    return Permission.CREATE_PUBLIC_THREADS;
                case R.id.channel_permission_text_embed_links /* 2131362397 */:
                    return Permission.EMBED_LINKS;
                case R.id.channel_permission_text_manage_messages /* 2131362398 */:
                    return Permission.MANAGE_MESSAGES;
                case R.id.channel_permission_text_mention_everyone /* 2131362399 */:
                    return Permission.MENTION_EVERYONE;
                case R.id.channel_permission_text_read_message_history /* 2131362400 */:
                    return Permission.READ_MESSAGE_HISTORY;
                case R.id.channel_permission_text_read_messages /* 2131362401 */:
                    return Permission.VIEW_CHANNEL;
                case R.id.channel_permission_text_send_messages /* 2131362402 */:
                    return Permission.SEND_MESSAGES;
                case R.id.channel_permission_text_send_messages_in_threads /* 2131362403 */:
                    return Permission.SEND_MESSAGES_IN_THREADS;
                case R.id.channel_permission_text_send_tts_messages /* 2131362404 */:
                    return Permission.SEND_TTS_MESSAGES;
                case R.id.channel_permission_text_use_external_emojis /* 2131362405 */:
                    return Permission.USE_EXTERNAL_EMOJIS;
                case R.id.channel_permission_text_use_external_stickers /* 2131362406 */:
                    return Permission.USE_EXTERNAL_STICKERS;
                case R.id.channel_permission_use_application_commands /* 2131362407 */:
                    return Permission.USE_APPLICATION_COMMANDS;
                case R.id.channel_permission_voice_connect /* 2131362408 */:
                    return Permission.CONNECT;
                case R.id.channel_permission_voice_deafen_members /* 2131362409 */:
                    return Permission.DEAFEN_MEMBERS;
                case R.id.channel_permission_voice_move_members /* 2131362410 */:
                    return Permission.MOVE_MEMBERS;
                case R.id.channel_permission_voice_mute_members /* 2131362411 */:
                    return Permission.MUTE_MEMBERS;
                case R.id.channel_permission_voice_priority_speaker /* 2131362412 */:
                    return 256L;
                case R.id.channel_permission_voice_speak /* 2131362413 */:
                    return Permission.SPEAK;
                case R.id.channel_permission_voice_use_vad /* 2131362414 */:
                    return Permission.USE_VAD;
                case R.id.channel_permission_voice_video /* 2131362415 */:
                    return 512L;
            }
        }

        private final void setTextWithFont(TextView textView, String str, @AttrRes int i) {
            FontUtils fontUtils = FontUtils.INSTANCE;
            Context context = textView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            Typeface themedFont = fontUtils.getThemedFont(context, i);
            if (themedFont != null) {
                TypefaceSpanCompat typefaceSpanCompat = new TypefaceSpanCompat(themedFont);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
                spannableStringBuilder.setSpan(typefaceSpanCompat, 0, spannableStringBuilder.length(), 33);
                textView.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
            }
        }

        public final void createForRole(Context context, long guildId, long channelId, long targetId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            create(context, guildId, channelId, targetId, 1);
        }

        public final void createForUser(Context context, long guildId, long channelId, long targetId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            create(context, guildId, channelId, targetId, 0);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelSettingsEditPermissions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "menuItem", "Landroid/content/Context;", "<anonymous parameter 1>", "", NotificationCompat.CATEGORY_CALL, "(Landroid/view/MenuItem;Landroid/content/Context;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissions$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2> implements Action2<MenuItem, Context> {
        public final /* synthetic */ WidgetChannelSettingsEditPermissionsModel $model;

        public AnonymousClass1(WidgetChannelSettingsEditPermissionsModel widgetChannelSettingsEditPermissionsModel) {
            this.$model = widgetChannelSettingsEditPermissionsModel;
        }

        @Override // rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
            if (menuItem.getItemId() != R.id.menu_edit_overwrite_delete) {
                return;
            }
            WidgetChannelSettingsEditPermissions.access$deletePermissionOverwrites(WidgetChannelSettingsEditPermissions.this, this.$model.getChannel().getId(), WidgetChannelSettingsEditPermissions.access$getTargetId$p(WidgetChannelSettingsEditPermissions.this));
        }
    }

    /* compiled from: WidgetChannelSettingsEditPermissions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissions$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ WidgetChannelSettingsEditPermissionsModel $model;

        public AnonymousClass2(WidgetChannelSettingsEditPermissionsModel widgetChannelSettingsEditPermissionsModel) {
            this.$model = widgetChannelSettingsEditPermissionsModel;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelSettingsEditPermissions.access$updatePermissionOverwrites(WidgetChannelSettingsEditPermissions.this, this.$model.getChannel().getId(), this.$model.getTargetId(), this.$model.getType());
        }
    }

    /* compiled from: WidgetChannelSettingsEditPermissions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissions$deletePermissionOverwrites$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) throws Exception {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r4) throws Exception {
            StatefulViews statefulViewsAccess$getState$p = WidgetChannelSettingsEditPermissions.access$getState$p(WidgetChannelSettingsEditPermissions.this);
            if (statefulViewsAccess$getState$p != null) {
                StatefulViews.clear$default(statefulViewsAccess$getState$p, false, 1, null);
            }
            AppActivity appActivity = WidgetChannelSettingsEditPermissions.this.getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
            }
        }
    }

    /* compiled from: WidgetChannelSettingsEditPermissions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsEditPermissionsModel;", "p1", "", "invoke", "(Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsEditPermissionsModel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissions$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetChannelSettingsEditPermissionsModel, Unit> {
        public AnonymousClass1(WidgetChannelSettingsEditPermissions widgetChannelSettingsEditPermissions) {
            super(1, widgetChannelSettingsEditPermissions, WidgetChannelSettingsEditPermissions.class, "configureUI", "configureUI(Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsEditPermissionsModel;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelSettingsEditPermissionsModel widgetChannelSettingsEditPermissionsModel) {
            invoke2(widgetChannelSettingsEditPermissionsModel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChannelSettingsEditPermissionsModel widgetChannelSettingsEditPermissionsModel) {
            WidgetChannelSettingsEditPermissions.access$configureUI((WidgetChannelSettingsEditPermissions) this.receiver, widgetChannelSettingsEditPermissionsModel);
        }
    }

    /* compiled from: WidgetChannelSettingsEditPermissions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/discord/widgets/channels/permissions/WidgetChannelSettingsEditPermissions$setupPermissionCheckedState$1", "Lcom/discord/views/TernaryCheckBox$b;", "", "switchStatus", "", "onSwitchStatusChanged", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissions$setupPermissionCheckedState$1, reason: invalid class name */
    public static final class AnonymousClass1 implements TernaryCheckBox.b {
        public final /* synthetic */ int $checkboxId;

        public AnonymousClass1(int i) {
            this.$checkboxId = i;
        }

        @Override // com.discord.views.TernaryCheckBox.b
        public void onSwitchStatusChanged(int switchStatus) {
            StatefulViews statefulViewsAccess$getState$p = WidgetChannelSettingsEditPermissions.access$getState$p(WidgetChannelSettingsEditPermissions.this);
            if (statefulViewsAccess$getState$p != null) {
                statefulViewsAccess$getState$p.put(this.$checkboxId, Integer.valueOf(switchStatus));
            }
            StatefulViews statefulViewsAccess$getState$p2 = WidgetChannelSettingsEditPermissions.access$getState$p(WidgetChannelSettingsEditPermissions.this);
            if (statefulViewsAccess$getState$p2 != null) {
                statefulViewsAccess$getState$p2.configureSaveActionView(WidgetChannelSettingsEditPermissions.access$getBinding$p(WidgetChannelSettingsEditPermissions.this).H);
            }
        }
    }

    /* compiled from: WidgetChannelSettingsEditPermissions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/restapi/RestAPIParams$ChannelPermissionOverwrites;", "invoke", "()Lcom/discord/restapi/RestAPIParams$ChannelPermissionOverwrites;", "getRequestBody"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissions$updatePermissionOverwrites$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<RestAPIParams.ChannelPermissionOverwrites> {
        public final /* synthetic */ long $targetId;
        public final /* synthetic */ int $type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i, long j) {
            super(0);
            this.$type = i;
            this.$targetId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ RestAPIParams.ChannelPermissionOverwrites invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final RestAPIParams.ChannelPermissionOverwrites invoke() {
            Iterator it = WidgetChannelSettingsEditPermissions.access$getPermissionCheckboxes$p(WidgetChannelSettingsEditPermissions.this).iterator();
            long jAccess$getPermission = 0;
            long jAccess$getPermission2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                TernaryCheckBox ternaryCheckBox = (TernaryCheckBox) it.next();
                if (ternaryCheckBox.b()) {
                    jAccess$getPermission |= Companion.access$getPermission(WidgetChannelSettingsEditPermissions.INSTANCE, ternaryCheckBox.getId());
                } else {
                    if (ternaryCheckBox.switchStatus == -1) {
                        jAccess$getPermission2 |= Companion.access$getPermission(WidgetChannelSettingsEditPermissions.INSTANCE, ternaryCheckBox.getId());
                    }
                }
            }
            return this.$type == 1 ? RestAPIParams.ChannelPermissionOverwrites.INSTANCE.createForRole(this.$targetId, Long.valueOf(jAccess$getPermission), Long.valueOf(jAccess$getPermission2)) : RestAPIParams.ChannelPermissionOverwrites.INSTANCE.createForMember(this.$targetId, Long.valueOf(jAccess$getPermission), Long.valueOf(jAccess$getPermission2));
        }
    }

    /* compiled from: WidgetChannelSettingsEditPermissions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissions$updatePermissionOverwrites$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
        }
    }

    public WidgetChannelSettingsEditPermissions() {
        super(R.layout.widget_channel_settings_edit_permissions);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChannelSettingsEditPermissions2.INSTANCE, null, 2, null);
        this.permissionCheckboxes = LazyJVM.lazy(new WidgetChannelSettingsEditPermissions5(this));
        this.guildId = LazyJVM.lazy(new WidgetChannelSettingsEditPermissions4(this));
        this.channelId = LazyJVM.lazy(new WidgetChannelSettingsEditPermissions3(this));
        this.targetId = LazyJVM.lazy(new WidgetChannelSettingsEditPermissions6(this));
        this.type = LazyJVM.lazy(new WidgetChannelSettingsEditPermissions7(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetChannelSettingsEditPermissions widgetChannelSettingsEditPermissions, WidgetChannelSettingsEditPermissionsModel widgetChannelSettingsEditPermissionsModel) {
        widgetChannelSettingsEditPermissions.configureUI(widgetChannelSettingsEditPermissionsModel);
    }

    public static final /* synthetic */ void access$deletePermissionOverwrites(WidgetChannelSettingsEditPermissions widgetChannelSettingsEditPermissions, long j, long j2) {
        widgetChannelSettingsEditPermissions.deletePermissionOverwrites(j, j2);
    }

    public static final /* synthetic */ WidgetChannelSettingsEditPermissionsBinding access$getBinding$p(WidgetChannelSettingsEditPermissions widgetChannelSettingsEditPermissions) {
        return widgetChannelSettingsEditPermissions.getBinding();
    }

    public static final /* synthetic */ List access$getPermissionCheckboxes$p(WidgetChannelSettingsEditPermissions widgetChannelSettingsEditPermissions) {
        return widgetChannelSettingsEditPermissions.getPermissionCheckboxes();
    }

    public static final /* synthetic */ StatefulViews access$getState$p(WidgetChannelSettingsEditPermissions widgetChannelSettingsEditPermissions) {
        return widgetChannelSettingsEditPermissions.state;
    }

    public static final /* synthetic */ long access$getTargetId$p(WidgetChannelSettingsEditPermissions widgetChannelSettingsEditPermissions) {
        return widgetChannelSettingsEditPermissions.getTargetId();
    }

    public static final /* synthetic */ void access$setState$p(WidgetChannelSettingsEditPermissions widgetChannelSettingsEditPermissions, StatefulViews statefulViews) {
        widgetChannelSettingsEditPermissions.state = statefulViews;
    }

    public static final /* synthetic */ void access$updatePermissionOverwrites(WidgetChannelSettingsEditPermissions widgetChannelSettingsEditPermissions, long j, long j2, int i) {
        widgetChannelSettingsEditPermissions.updatePermissionOverwrites(j, j2, i);
    }

    private final void configureUI(WidgetChannelSettingsEditPermissionsModel model) {
        PermissionOverwrite permissionOverwrite;
        PermissionOverwrite next;
        Object next2;
        if (model == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
                return;
            }
            return;
        }
        List<PermissionOverwrite> listV = model.getChannel().v();
        if (listV != null) {
            Iterator<T> it = listV.iterator();
            while (true) {
                if (it.hasNext()) {
                    next2 = it.next();
                    if (((PermissionOverwrite) next2).getId() == getTargetId()) {
                        break;
                    }
                } else {
                    next2 = null;
                    break;
                }
            }
            permissionOverwrite = (PermissionOverwrite) next2;
        } else {
            permissionOverwrite = null;
        }
        int i = permissionOverwrite != null ? R.menu.menu_edit_permission_overwrite : R.menu.menu_empty;
        setActionBarTitle(ChannelUtils.k(model.getChannel()) ? R.string.category_settings : R.string.channel_settings);
        setActionBarSubtitle(ChannelUtils.d(model.getChannel(), requireContext(), true));
        AppFragment.setActionBarOptionsMenu$default(this, i, new AnonymousClass1(model), null, 4, null);
        if (model instanceof WidgetChannelSettingsEditPermissionsModel.ModelForRole) {
            SettingsMemberView settingsMemberView = getBinding().M;
            Intrinsics3.checkNotNullExpressionValue(settingsMemberView, "binding.memberView");
            settingsMemberView.setVisibility(8);
            TextView textView = getBinding().J;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelPermissionsTargetName");
            textView.setVisibility(0);
            Companion companion = INSTANCE;
            TextView textView2 = getBinding().J;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.channelPermissionsTargetName");
            WidgetChannelSettingsEditPermissionsModel.ModelForRole modelForRole = (WidgetChannelSettingsEditPermissionsModel.ModelForRole) model;
            Companion.access$setTextWithFont(companion, textView2, modelForRole.getGuildRole().getName(), R.attr.font_primary_semibold);
            getBinding().J.setTextColor(RoleUtils.getRoleColor$default(modelForRole.getGuildRole(), requireContext(), null, 2, null));
        } else if (model instanceof WidgetChannelSettingsEditPermissionsModel.ModelForUser) {
            SettingsMemberView settingsMemberView2 = getBinding().M;
            Intrinsics3.checkNotNullExpressionValue(settingsMemberView2, "binding.memberView");
            settingsMemberView2.setVisibility(0);
            TextView textView3 = getBinding().J;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.channelPermissionsTargetName");
            textView3.setVisibility(8);
            WidgetChannelSettingsEditPermissionsModel.ModelForUser modelForUser = (WidgetChannelSettingsEditPermissionsModel.ModelForUser) model;
            getBinding().M.a(modelForUser.getUser(), modelForUser.getGuildMember());
            Companion companion2 = INSTANCE;
            TextView textView4 = getBinding().J;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.channelPermissionsTargetName");
            Companion.access$setTextWithFont(companion2, textView4, modelForUser.getUser().getUsername(), R.attr.font_primary_normal);
        }
        TextView textView5 = getBinding().F;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.channelPermissionsChannelName");
        textView5.setText(ChannelUtils.d(model.getChannel(), requireContext(), true));
        boolean z2 = ChannelUtils.J(model.getChannel()) && TextInVoiceFeatureFlag.INSTANCE.getINSTANCE().isEnabled(Long.valueOf(model.getChannel().getGuildId()));
        LinearLayout linearLayout = getBinding().K;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.channelPermissionsTextContainer");
        linearLayout.setVisibility(ChannelUtils.v(model.getChannel()) || ChannelUtils.k(model.getChannel()) || z2 ? 0 : 8);
        LinearLayout linearLayout2 = getBinding().L;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.channelPermissionsVoiceContainer");
        linearLayout2.setVisibility(ChannelUtils.w(model.getChannel()) || ChannelUtils.k(model.getChannel()) ? 0 : 8);
        LinearLayout linearLayout3 = getBinding().I;
        Intrinsics3.checkNotNullExpressionValue(linearLayout3, "binding.channelPermissionsStageContainer");
        linearLayout3.setVisibility(ChannelUtils.D(model.getChannel()) || ChannelUtils.k(model.getChannel()) ? 0 : 8);
        LinearLayout linearLayout4 = getBinding().G;
        Intrinsics3.checkNotNullExpressionValue(linearLayout4, "binding.channelPermissionsEventsContainer");
        linearLayout4.setVisibility(ChannelUtils.w(model.getChannel()) || ChannelUtils.k(model.getChannel()) ? 0 : 8);
        TernaryCheckBox ternaryCheckBox = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(ternaryCheckBox, "binding.channelPermissionGeneralManageWebhooks");
        ternaryCheckBox.setVisibility(ChannelUtils.v(model.getChannel()) || ChannelUtils.k(model.getChannel()) ? 0 : 8);
        if (ChannelUtils.k(model.getChannel())) {
            getBinding().N.setText(R.string.role_permissions_section_general_category);
        }
        Map<Integer, ChannelPermissionUtils2> categoryLabels = ChannelPermissionUtils.getCategoryLabels(model.getUseNewThreadsPermissions(), requireContext());
        boolean z3 = model.getType() == 1 && model.getTargetId() == model.getChannel().getGuildId();
        List<PermissionOverwrite> listV2 = model.getChannel().v();
        Intrinsics3.checkNotNull(listV2);
        Iterator<PermissionOverwrite> it2 = listV2.iterator();
        while (true) {
            if (it2.hasNext()) {
                next = it2.next();
                if (next.e() == model.getTargetId()) {
                    break;
                }
            } else {
                next = null;
                break;
            }
        }
        if (!model.getUseNewThreadsPermissions()) {
            getBinding().f2274s.setLabel(getString(R.string.interim_send_messages_in_threads));
            getBinding().f2274s.setSubtext(FormatUtils.k(this, R.string.interim_role_permissions_send_messages_in_threads_description_text, new Object[0], null, 4));
            getBinding().l.setLabel(getString(R.string.interim_create_public_threads));
            getBinding().l.setSubtext(FormatUtils.k(this, R.string.interim_role_permissions_create_public_threads_description_text, new Object[0], null, 4));
            getBinding().k.setLabel(getString(R.string.interim_create_private_threads));
            getBinding().k.setSubtext(FormatUtils.k(this, R.string.interim_role_permissions_create_private_threads_description_text, new Object[0], null, 4));
        }
        for (TernaryCheckBox ternaryCheckBox2 : getPermissionCheckboxes()) {
            int id2 = ternaryCheckBox2.getId();
            long jAccess$getPermission = Companion.access$getPermission(INSTANCE, id2);
            if (model.getChannel().getType() == 13 && STAGE_HIDDEN_PERMISSIONS.contains(Long.valueOf(jAccess$getPermission))) {
                ternaryCheckBox2.setVisibility(8);
            }
            setupPermissionEnabledState(ternaryCheckBox2, jAccess$getPermission, model);
            setupPermissionCheckedState(ternaryCheckBox2, next);
            if (id2 == R.id.channel_permission_voice_priority_speaker) {
                ternaryCheckBox2.setSubtext(FormatUtils.j(ternaryCheckBox2, R.string.role_permissions_priority_speaker_description_voice_mobile, new Object[]{getString(R.string.keybind_push_to_talk_priority)}, null, 4));
            }
            if (id2 == R.id.channel_permission_text_create_private_threads) {
                ternaryCheckBox2.setVisibility(ChannelUtils.i(model.getChannel()) ^ true ? 0 : 8);
            }
            if (id2 == R.id.channel_permission_general_manage_threads) {
                ternaryCheckBox2.setVisibility(ChannelUtils.w(model.getChannel()) ^ true ? 0 : 8);
            }
            updateCheckboxLabels(ternaryCheckBox2, model.getChannel().getType(), z3, categoryLabels.get(Integer.valueOf(id2)));
        }
        getBinding().H.setOnClickListener(new AnonymousClass2(model));
        StatefulViews statefulViews = this.state;
        if (statefulViews != null) {
            statefulViews.configureSaveActionView(getBinding().H);
        }
    }

    public static final void createForRole(Context context, long j, long j2, long j3) {
        INSTANCE.createForRole(context, j, j2, j3);
    }

    public static final void createForUser(Context context, long j, long j2, long j3) {
        INSTANCE.createForUser(context, j, j2, j3);
    }

    private final void deletePermissionOverwrites(long channelId, long targetId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deletePermissionOverwrites(channelId, targetId), false, 1, null), this, null, 2, null), WidgetChannelSettingsEditPermissions.class, getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 60, (Object) null);
    }

    private final WidgetChannelSettingsEditPermissionsBinding getBinding() {
        return (WidgetChannelSettingsEditPermissionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final List<TernaryCheckBox> getPermissionCheckboxes() {
        return (List) this.permissionCheckboxes.getValue();
    }

    private final long getTargetId() {
        return ((Number) this.targetId.getValue()).longValue();
    }

    private final int getType() {
        return ((Number) this.type.getValue()).intValue();
    }

    private final void setupPermissionCheckedState(TernaryCheckBox checkBox, PermissionOverwrite permissionOverwrite) {
        long deny;
        long allow = 0;
        if (permissionOverwrite != null) {
            allow = permissionOverwrite.getAllow();
            deny = permissionOverwrite.getDeny();
        } else {
            deny = 0;
        }
        int id2 = checkBox.getId();
        long jAccess$getPermission = Companion.access$getPermission(INSTANCE, id2);
        if (jAccess$getPermission == (allow & jAccess$getPermission)) {
            checkBox.f();
        } else if (jAccess$getPermission == (jAccess$getPermission & deny)) {
            checkBox.e();
        } else {
            checkBox.d();
        }
        StatefulViews statefulViews = this.state;
        if (statefulViews != null) {
        }
        checkBox.setOnSwitchStatusChangedListener(new AnonymousClass1(id2));
    }

    private final void setupPermissionEnabledState(TernaryCheckBox checkBox, long permission, WidgetChannelSettingsEditPermissionsModel model) {
        if (ChannelUtils.D(model.getChannel()) && STAGE_DISABLED_PERMISSIONS.contains(Long.valueOf(permission))) {
            checkBox.setDisabled(R.string.stage_channel_cannot_overwrite_permission);
            return;
        }
        if (model instanceof WidgetChannelSettingsEditPermissionsModel.ModelForUser) {
            WidgetChannelSettingsEditPermissionsModel.ModelForUser modelForUser = (WidgetChannelSettingsEditPermissionsModel.ModelForUser) model;
            if (modelForUser.isMe()) {
                if (checkBox.b()) {
                    checkBox.setDisabled(R.string.cannot_deny_self_simple);
                    return;
                } else {
                    checkBox.setOffDisabled(R.string.cannot_deny_self_simple);
                    return;
                }
            }
            if ((modelForUser.getMyPermissionsForChannel() & permission) == permission) {
                checkBox.c();
                return;
            } else {
                checkBox.setDisabled(R.string.cannot_deny_missing_permission);
                return;
            }
        }
        if (model instanceof WidgetChannelSettingsEditPermissionsModel.ModelForRole) {
            WidgetChannelSettingsEditPermissionsModel.ModelForRole modelForRole = (WidgetChannelSettingsEditPermissionsModel.ModelForRole) model;
            if (!modelForRole.getMeHasRole()) {
                checkBox.setEnabled((modelForRole.getMyPermissionsForChannel() & permission) == permission);
                return;
            }
            int i = checkBox.switchStatus;
            if (i == 0) {
                if (modelForRole.canDenyRolePermission(permission)) {
                    checkBox.c();
                    return;
                } else if ((modelForRole.getMyPermissionsForChannel() & permission) == permission) {
                    checkBox.setOffDisabled(R.string.cannot_deny_singular_permission);
                    return;
                } else {
                    checkBox.setOffDisabled(R.string.cannot_deny_missing_permission);
                    return;
                }
            }
            if (i == -1) {
                checkBox.c();
                return;
            }
            if (checkBox.b()) {
                if (!modelForRole.canNeutralizeRolePermission(permission)) {
                    checkBox.setDisabled(R.string.cannot_deny_singular_permission);
                    return;
                }
                if (modelForRole.canNeutralizeRolePermission(permission) && !modelForRole.canDenyRolePermission(permission)) {
                    checkBox.setOffDisabled(R.string.cannot_deny_singular_permission);
                } else if (modelForRole.canNeutralizeRolePermission(permission) && modelForRole.canDenyRolePermission(permission)) {
                    checkBox.c();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateCheckboxLabels(TernaryCheckBox checkBox, int channelType, boolean isEveryoneRole, ChannelPermissionUtils2 labels) {
        CharSequence textChannelEveryoneSubtext;
        if (labels != null) {
            if (channelType != 0) {
                if (channelType == 2) {
                    textChannelEveryoneSubtext = isEveryoneRole ? labels.getVoiceChannelEveryoneSubtext() : null;
                    if (textChannelEveryoneSubtext == null) {
                        textChannelEveryoneSubtext = labels.getVoiceChannelSubtext();
                    }
                } else if (channelType == 13) {
                    if (isEveryoneRole) {
                        textChannelEveryoneSubtext = labels.getStageChannelEveryoneSubtext();
                        if (textChannelEveryoneSubtext == null) {
                            textChannelEveryoneSubtext = labels.getVoiceChannelEveryoneSubtext();
                        }
                    } else {
                        textChannelEveryoneSubtext = null;
                    }
                    if (textChannelEveryoneSubtext == null) {
                        textChannelEveryoneSubtext = labels.getStageChannelSubtext();
                    }
                    if (textChannelEveryoneSubtext == null) {
                        textChannelEveryoneSubtext = labels.getVoiceChannelSubtext();
                    }
                } else if (channelType == 4) {
                    String categoryLabel = labels.getCategoryLabel();
                    categoryEveryoneSubtext = isEveryoneRole ? labels.getCategoryEveryoneSubtext() : null;
                    if (categoryEveryoneSubtext == null) {
                        categoryEveryoneSubtext = labels.getCategorySubtext();
                    }
                    CharSequence charSequence = categoryEveryoneSubtext;
                    categoryEveryoneSubtext = categoryLabel;
                    textChannelEveryoneSubtext = charSequence;
                } else if (channelType != 5) {
                    textChannelEveryoneSubtext = null;
                } else {
                    textChannelEveryoneSubtext = labels.getAnnouncementChannelSubtext();
                    LinkifiedTextView linkifiedTextView = checkBox.binding.f;
                    Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.settingSubtext");
                    linkifiedTextView.setMovementMethod(LinkMovementMethod.getInstance());
                }
            } else if (isEveryoneRole) {
                textChannelEveryoneSubtext = labels.getTextChannelEveryoneSubtext();
            }
            if (categoryEveryoneSubtext != null) {
                checkBox.setLabel(categoryEveryoneSubtext);
            }
            if (textChannelEveryoneSubtext != null) {
                checkBox.setSubtext(textChannelEveryoneSubtext);
            }
        }
    }

    private final void updatePermissionOverwrites(long channelId, long targetId, int type) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updatePermissionOverwrites(channelId, targetId, new AnonymousClass1(type, targetId).invoke()), false, 1, null), this, null, 2, null), WidgetChannelSettingsEditPermissions.class, requireContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnonymousClass2.INSTANCE, 60, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        StatefulViews statefulViews = new StatefulViews(getPermissionCheckboxes());
        this.state = statefulViews;
        if (statefulViews != null) {
            statefulViews.setupUnsavedChangesConfirmation(this);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(WidgetChannelSettingsEditPermissionsModel.INSTANCE.get(getGuildId(), getChannelId(), getTargetId(), getType()), this, null, 2, null), WidgetChannelSettingsEditPermissions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
