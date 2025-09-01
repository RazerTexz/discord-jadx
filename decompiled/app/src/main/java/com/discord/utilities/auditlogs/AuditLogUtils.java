package com.discord.utilities.auditlogs;

import android.content.Context;
import android.content.res.Resources;
import android.text.format.DateUtils;
import android.view.View;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreStream;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;

/* compiled from: AuditLogUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b1\u00102J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0005\u0010\u0006JG\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022$\u0010\r\u001a \u0012\u0004\u0012\u00020\b\u0012\u0016\u0012\u0014\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t0\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0019\u001a\u00020\f2\n\u0010\u0016\u001a\u00060\nj\u0002`\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJU\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00172$\u0010\r\u001a \u0012\u0004\u0012\u00020\b\u0012\u0016\u0012\u0014\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t0\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u000e¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b \u0010!J\u001f\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b&\u0010!J\u0015\u0010'\u001a\u00060\nj\u0002`\u0015*\u00020\u0002¢\u0006\u0004\b'\u0010(J\u001d\u0010)\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b)\u0010*R#\u00100\u001a\b\u0012\u0004\u0012\u00020\u00040+8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/¨\u00063"}, d2 = {"Lcom/discord/utilities/auditlogs/AuditLogUtils;", "", "Lcom/discord/models/domain/ModelAuditLogEntry;", "auditLogEntry", "", "getEntryTitle", "(Lcom/discord/models/domain/ModelAuditLogEntry;)I", "", "Lcom/discord/models/domain/ModelAuditLogEntry$TargetType;", "", "", "Lcom/discord/stores/TargetId;", "", "targets", "", "channelPrefix", "getTargetText", "(Lcom/discord/models/domain/ModelAuditLogEntry;Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;", "keyForValue", "getTargetValue", "(Lcom/discord/models/domain/ModelAuditLogEntry;Ljava/lang/String;)Ljava/lang/Object;", "Lcom/discord/primitives/Timestamp;", "timestamp", "Landroid/content/Context;", "context", "getTimestampText", "(JLandroid/content/Context;)Ljava/lang/CharSequence;", "username", "prefix", "getHeaderString", "(Lcom/discord/models/domain/ModelAuditLogEntry;Ljava/lang/CharSequence;Landroid/content/Context;Ljava/util/Map;Ljava/lang/String;)Ljava/lang/CharSequence;", "actionTypeId", "getActionName", "(I)I", "Landroid/view/View;", "view", "getTargetTypeImage", "(Landroid/view/View;I)I", "getActionTypeImage", "getTimestampStart", "(Lcom/discord/models/domain/ModelAuditLogEntry;)J", "getTimestampString", "(Lcom/discord/models/domain/ModelAuditLogEntry;Landroid/content/Context;)Ljava/lang/CharSequence;", "", "ALL_ACTION_TYPES$delegate", "Lkotlin/Lazy;", "getALL_ACTION_TYPES", "()Ljava/util/List;", "ALL_ACTION_TYPES", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class AuditLogUtils {
    public static final AuditLogUtils INSTANCE = new AuditLogUtils();

    /* renamed from: ALL_ACTION_TYPES$delegate, reason: from kotlin metadata */
    private static final Lazy ALL_ACTION_TYPES = LazyJVM.lazy(AuditLogUtils2.INSTANCE);

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            ModelAuditLogEntry.TargetType.values();
            int[] iArr = new int[15];
            $EnumSwitchMapping$0 = iArr;
            iArr[ModelAuditLogEntry.TargetType.ALL.ordinal()] = 1;
            iArr[ModelAuditLogEntry.TargetType.GUILD.ordinal()] = 2;
            ModelAuditLogEntry.TargetType targetType = ModelAuditLogEntry.TargetType.CHANNEL;
            iArr[targetType.ordinal()] = 3;
            iArr[ModelAuditLogEntry.TargetType.CHANNEL_OVERWRITE.ordinal()] = 4;
            iArr[ModelAuditLogEntry.TargetType.USER.ordinal()] = 5;
            ModelAuditLogEntry.TargetType targetType2 = ModelAuditLogEntry.TargetType.ROLE;
            iArr[targetType2.ordinal()] = 6;
            ModelAuditLogEntry.TargetType targetType3 = ModelAuditLogEntry.TargetType.INVITE;
            iArr[targetType3.ordinal()] = 7;
            ModelAuditLogEntry.TargetType targetType4 = ModelAuditLogEntry.TargetType.WEBHOOK;
            iArr[targetType4.ordinal()] = 8;
            iArr[ModelAuditLogEntry.TargetType.EMOJI.ordinal()] = 9;
            ModelAuditLogEntry.TargetType targetType5 = ModelAuditLogEntry.TargetType.INTEGRATION;
            iArr[targetType5.ordinal()] = 10;
            iArr[ModelAuditLogEntry.TargetType.STAGE_INSTANCE.ordinal()] = 11;
            iArr[ModelAuditLogEntry.TargetType.GUILD_SCHEDULED_EVENT.ordinal()] = 12;
            iArr[ModelAuditLogEntry.TargetType.STICKER.ordinal()] = 13;
            iArr[ModelAuditLogEntry.TargetType.THREAD.ordinal()] = 14;
            ModelAuditLogEntry.ActionType.values();
            int[] iArr2 = new int[4];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[ModelAuditLogEntry.ActionType.CREATE.ordinal()] = 1;
            iArr2[ModelAuditLogEntry.ActionType.UPDATE.ordinal()] = 2;
            iArr2[ModelAuditLogEntry.ActionType.DELETE.ordinal()] = 3;
            ModelAuditLogEntry.TargetType.values();
            int[] iArr3 = new int[15];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[targetType.ordinal()] = 1;
            iArr3[targetType2.ordinal()] = 2;
            iArr3[targetType3.ordinal()] = 3;
            iArr3[targetType4.ordinal()] = 4;
            iArr3[targetType5.ordinal()] = 5;
        }
    }

    private AuditLogUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @StringRes
    private final int getEntryTitle(ModelAuditLogEntry auditLogEntry) {
        int actionTypeId = auditLogEntry.getActionTypeId();
        ModelAuditLogEntry.Change change = null;
        switch (actionTypeId) {
            case 1:
                return R.string.guild_settings_audit_log_guild_update;
            case 20:
                return R.string.guild_settings_audit_log_member_kick;
            case 21:
                return R.string.guild_settings_audit_log_member_prune;
            case 22:
                return R.string.guild_settings_audit_log_member_ban_add;
            case 23:
                return R.string.guild_settings_audit_log_member_ban_remove;
            case 24:
                return R.string.guild_settings_audit_log_member_update;
            case 25:
                return R.string.guild_settings_audit_log_member_role_update;
            case 26:
                return R.string.guild_settings_audit_log_member_move;
            case 27:
                return R.string.guild_settings_audit_log_member_disconnect;
            case 28:
                return R.string.guild_settings_audit_log_bot_add;
            case 110:
                List<ModelAuditLogEntry.Change> changes = auditLogEntry.getChanges();
                if (changes != null) {
                    Iterator<T> it = changes.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Object next = it.next();
                            ModelAuditLogEntry.Change change2 = (ModelAuditLogEntry.Change) next;
                            Intrinsics3.checkNotNullExpressionValue(change2, "it");
                            if (Intrinsics3.areEqual(change2.getKey(), "type")) {
                                change = next;
                            }
                        }
                    }
                    change = change;
                }
                if (change == null) {
                    return 0;
                }
                Object newValue = change.getNewValue();
                Objects.requireNonNull(newValue, "null cannot be cast to non-null type kotlin.Long");
                int iLongValue = (int) ((Long) newValue).longValue();
                return iLongValue != 10 ? iLongValue != 12 ? R.string.guild_settings_audit_log_thread_create : R.string.guild_settings_audit_log_private_thread_create : R.string.guild_settings_audit_log_announcement_thread_create;
            case 111:
                return R.string.guild_settings_audit_log_thread_update;
            case 112:
                return R.string.guild_settings_audit_log_thread_delete;
            default:
                switch (actionTypeId) {
                    case 10:
                        List<ModelAuditLogEntry.Change> changes2 = auditLogEntry.getChanges();
                        if (changes2 != null) {
                            Iterator<T> it2 = changes2.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    Object next2 = it2.next();
                                    ModelAuditLogEntry.Change change3 = (ModelAuditLogEntry.Change) next2;
                                    Intrinsics3.checkNotNullExpressionValue(change3, "it");
                                    if (Intrinsics3.areEqual(change3.getKey(), "type")) {
                                        change = next2;
                                    }
                                }
                            }
                            change = change;
                        }
                        if (change == null) {
                            return 0;
                        }
                        Object newValue2 = change.getNewValue();
                        Objects.requireNonNull(newValue2, "null cannot be cast to non-null type kotlin.Long");
                        int iLongValue2 = (int) ((Long) newValue2).longValue();
                        return iLongValue2 != 2 ? iLongValue2 != 4 ? iLongValue2 != 13 ? R.string.guild_settings_audit_log_channel_text_create : R.string.guild_settings_audit_log_channel_stage_create : R.string.guild_settings_audit_log_channel_category_create : R.string.guild_settings_audit_log_channel_voice_create;
                    case 11:
                        return R.string.guild_settings_audit_log_channel_update;
                    case 12:
                        return R.string.guild_settings_audit_log_channel_delete;
                    case 13:
                        return R.string.guild_settings_audit_log_channel_overwrite_create;
                    case 14:
                        return R.string.guild_settings_audit_log_channel_overwrite_update;
                    case 15:
                        return R.string.guild_settings_audit_log_channel_overwrite_delete;
                    default:
                        switch (actionTypeId) {
                            case 30:
                                return R.string.guild_settings_audit_log_role_create;
                            case 31:
                                return R.string.guild_settings_audit_log_role_update;
                            case 32:
                                return R.string.guild_settings_audit_log_role_delete;
                            default:
                                switch (actionTypeId) {
                                    case 40:
                                        return R.string.guild_settings_audit_log_invite_create;
                                    case 41:
                                        return R.string.guild_settings_audit_log_invite_update;
                                    case 42:
                                        return R.string.guild_settings_audit_log_invite_delete;
                                    default:
                                        switch (actionTypeId) {
                                            case 50:
                                                return R.string.guild_settings_audit_log_webhook_create;
                                            case 51:
                                                return R.string.guild_settings_audit_log_webhook_update;
                                            case 52:
                                                return R.string.guild_settings_audit_log_webhook_delete;
                                            default:
                                                switch (actionTypeId) {
                                                    case 60:
                                                        return R.string.guild_settings_audit_log_emoji_create;
                                                    case 61:
                                                        return R.string.guild_settings_audit_log_emoji_update;
                                                    case 62:
                                                        return R.string.guild_settings_audit_log_emoji_delete;
                                                    default:
                                                        switch (actionTypeId) {
                                                            case 72:
                                                                return R.string.guild_settings_audit_log_message_delete;
                                                            case 73:
                                                                return R.string.guild_settings_audit_log_message_bulk_delete;
                                                            case 74:
                                                                return R.string.guild_settings_audit_log_message_pin;
                                                            case 75:
                                                                return R.string.guild_settings_audit_log_message_unpin;
                                                            default:
                                                                switch (actionTypeId) {
                                                                    case 80:
                                                                        return R.string.guild_settings_audit_log_integration_create;
                                                                    case 81:
                                                                        return R.string.guild_settings_audit_log_integration_update;
                                                                    case 82:
                                                                        return R.string.guild_settings_audit_log_integration_delete;
                                                                    case 83:
                                                                        return R.string.guild_settings_audit_log_stage_instance_create;
                                                                    case 84:
                                                                        return R.string.guild_settings_audit_log_stage_instance_update;
                                                                    case 85:
                                                                        return auditLogEntry.getUserId() == 0 ? R.string.guild_settings_audit_log_stage_instance_delete_no_user : R.string.guild_settings_audit_log_stage_instance_delete;
                                                                    default:
                                                                        switch (actionTypeId) {
                                                                            case 90:
                                                                                return R.string.guild_settings_audit_log_sticker_create;
                                                                            case 91:
                                                                                return R.string.guild_settings_audit_log_sticker_update;
                                                                            case 92:
                                                                                return R.string.guild_settings_audit_log_sticker_delete;
                                                                            default:
                                                                                switch (actionTypeId) {
                                                                                    case 100:
                                                                                        return R.string.guild_settings_audit_log_scheduled_event_create;
                                                                                    case 101:
                                                                                        return R.string.guild_settings_audit_log_scheduled_event_update;
                                                                                    case 102:
                                                                                        return R.string.guild_settings_audit_log_scheduled_event_delete;
                                                                                    default:
                                                                                        AppLog appLog = AppLog.g;
                                                                                        StringBuilder sbU = outline.U("Unknown audit log action type: ");
                                                                                        sbU.append(auditLogEntry.getActionTypeId());
                                                                                        Logger.e$default(appLog, sbU.toString(), null, null, 6, null);
                                                                                        return R.string.guild_settings_audit_log_unknown_action;
                                                                                }
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
    }

    public static /* synthetic */ CharSequence getHeaderString$default(AuditLogUtils auditLogUtils, ModelAuditLogEntry modelAuditLogEntry, CharSequence charSequence, Context context, Map map, String str, int i, Object obj) {
        if ((i & 16) != 0) {
            str = "";
        }
        return auditLogUtils.getHeaderString(modelAuditLogEntry, charSequence, context, map, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String getTargetText(ModelAuditLogEntry auditLogEntry, Map<ModelAuditLogEntry.TargetType, ? extends Map<Long, CharSequence>> targets, String channelPrefix) {
        CharSequence targetValue;
        ModelAuditLogEntry.TargetType targetType = auditLogEntry.getTargetType();
        if (targetType == ModelAuditLogEntry.TargetType.CHANNEL_OVERWRITE) {
            targetType = ModelAuditLogEntry.TargetType.CHANNEL;
        }
        Map<Long, CharSequence> map = targets.get(targetType);
        if (map == null || (targetValue = map.get(Long.valueOf(auditLogEntry.getTargetId()))) == null) {
            if (targetType != null) {
                int iOrdinal = targetType.ordinal();
                if (iOrdinal == 3) {
                    StringBuilder sbU = outline.U(channelPrefix);
                    sbU.append(getTargetValue(auditLogEntry, ModelAuditLogEntry.CHANGE_KEY_NAME));
                    targetValue = sbU.toString();
                } else if (iOrdinal == 10) {
                    targetValue = getTargetValue(auditLogEntry, "type");
                } else if (iOrdinal != 6) {
                    targetValue = iOrdinal != 7 ? iOrdinal != 8 ? null : getTargetValue(auditLogEntry, ModelAuditLogEntry.CHANGE_KEY_NAME) : getTargetValue(auditLogEntry, ModelAuditLogEntry.CHANGE_KEY_CODE);
                } else {
                    ModelAuditLogEntry.Options options = auditLogEntry.getOptions();
                    if (options == null || (targetValue = options.getRoleName()) == null) {
                        targetValue = getTargetValue(auditLogEntry, ModelAuditLogEntry.CHANGE_KEY_NAME);
                    }
                }
            }
        }
        if (targetValue == null) {
            targetValue = Long.valueOf(auditLogEntry.getTargetId());
        }
        return targetValue.toString();
    }

    public static /* synthetic */ String getTargetText$default(AuditLogUtils auditLogUtils, ModelAuditLogEntry modelAuditLogEntry, Map map, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = "";
        }
        return auditLogUtils.getTargetText(modelAuditLogEntry, map, str);
    }

    private final Object getTargetValue(ModelAuditLogEntry modelAuditLogEntry, String str) {
        Object next;
        List<ModelAuditLogEntry.Change> changes = modelAuditLogEntry.getChanges();
        if (changes == null) {
            return null;
        }
        Iterator<T> it = changes.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            ModelAuditLogEntry.Change change = (ModelAuditLogEntry.Change) next;
            Intrinsics3.checkNotNullExpressionValue(change, "it");
            if (Intrinsics3.areEqual(change.getKey(), str)) {
                break;
            }
        }
        ModelAuditLogEntry.Change change2 = (ModelAuditLogEntry.Change) next;
        if (change2 != null) {
            return change2.getValue();
        }
        return null;
    }

    private final CharSequence getTimestampText(long timestamp, Context context) {
        Clock clock = ClockFactory.get();
        long jCurrentTimeMillis = clock.currentTimeMillis() - timestamp;
        CharSequence relativeTimeSpanString = DateUtils.getRelativeTimeSpanString(timestamp, clock.currentTimeMillis(), 86400000L, 131092);
        if (TimeUnit.MILLISECONDS.toDays(jCurrentTimeMillis) < 7) {
            return FormatUtils.h(context, R.string.guild_settings_audit_log_time_at_android, new Object[]{relativeTimeSpanString, DateUtils.formatDateTime(context, timestamp, 1)}, null, 4);
        }
        Intrinsics3.checkNotNullExpressionValue(relativeTimeSpanString, "timeString");
        return relativeTimeSpanString;
    }

    public final List<Integer> getALL_ACTION_TYPES() {
        return (List) ALL_ACTION_TYPES.getValue();
    }

    @StringRes
    public final int getActionName(int actionTypeId) {
        if (actionTypeId == 0) {
            return R.string.guild_settings_filter_all_actions;
        }
        if (actionTypeId == 1) {
            return R.string.guild_settings_action_filter_guild_update;
        }
        switch (actionTypeId) {
            case 10:
                return R.string.guild_settings_action_filter_channel_create;
            case 11:
                return R.string.guild_settings_action_filter_channel_update;
            case 12:
                return R.string.guild_settings_action_filter_channel_delete;
            case 13:
                return R.string.guild_settings_action_filter_channel_overwrite_create;
            case 14:
                return R.string.guild_settings_action_filter_channel_overwrite_update;
            case 15:
                return R.string.guild_settings_action_filter_channel_overwrite_delete;
            default:
                switch (actionTypeId) {
                    case 20:
                        return R.string.guild_settings_action_filter_member_kick;
                    case 21:
                        return R.string.guild_settings_action_filter_member_prune;
                    case 22:
                        return R.string.guild_settings_action_filter_member_ban_add;
                    case 23:
                        return R.string.guild_settings_action_filter_member_ban_remove;
                    case 24:
                        return R.string.guild_settings_action_filter_member_update;
                    case 25:
                        return R.string.guild_settings_action_filter_member_role_update;
                    case 26:
                        return R.string.guild_settings_action_filter_member_move;
                    case 27:
                        return R.string.guild_settings_action_filter_member_disconnect;
                    case 28:
                        return R.string.guild_settings_action_filter_bot_add;
                    case 100:
                        return R.string.guild_settings_action_filter_guild_scheduled_event_create;
                    case 101:
                        return R.string.guild_settings_action_filter_guild_scheduled_event_update;
                    case 102:
                        return R.string.guild_settings_action_filter_guild_scheduled_event_delete;
                    case 110:
                        return R.string.guild_settings_action_filter_thread_create;
                    case 111:
                        return R.string.guild_settings_action_filter_thread_update;
                    case 112:
                        return R.string.guild_settings_action_filter_thread_delete;
                    default:
                        switch (actionTypeId) {
                            case 30:
                                return R.string.guild_settings_action_filter_role_create;
                            case 31:
                                return R.string.guild_settings_action_filter_role_update;
                            case 32:
                                return R.string.guild_settings_action_filter_role_delete;
                            default:
                                switch (actionTypeId) {
                                    case 40:
                                        return R.string.guild_settings_action_filter_invite_create;
                                    case 41:
                                        return R.string.guild_settings_action_filter_invite_update;
                                    case 42:
                                        return R.string.guild_settings_action_filter_invite_delete;
                                    default:
                                        switch (actionTypeId) {
                                            case 50:
                                                return R.string.guild_settings_action_filter_webhook_create;
                                            case 51:
                                                return R.string.guild_settings_action_filter_webhook_update;
                                            case 52:
                                                return R.string.guild_settings_action_filter_webhook_delete;
                                            default:
                                                switch (actionTypeId) {
                                                    case 60:
                                                        return R.string.guild_settings_action_filter_emoji_create;
                                                    case 61:
                                                        return R.string.guild_settings_action_filter_emoji_update;
                                                    case 62:
                                                        return R.string.guild_settings_action_filter_emoji_delete;
                                                    default:
                                                        switch (actionTypeId) {
                                                            case 72:
                                                                return R.string.guild_settings_action_filter_message_delete;
                                                            case 73:
                                                                return R.string.guild_settings_action_filter_message_bulk_delete;
                                                            case 74:
                                                                return R.string.guild_settings_action_filter_message_pin;
                                                            case 75:
                                                                return R.string.guild_settings_action_filter_message_unpin;
                                                            default:
                                                                switch (actionTypeId) {
                                                                    case 80:
                                                                        return R.string.guild_settings_action_filter_integration_create;
                                                                    case 81:
                                                                        return R.string.guild_settings_action_filter_integration_update;
                                                                    case 82:
                                                                        return R.string.guild_settings_action_filter_integration_delete;
                                                                    case 83:
                                                                        return R.string.guild_settings_action_filter_stage_instance_create;
                                                                    case 84:
                                                                        return R.string.guild_settings_action_filter_stage_instance_update;
                                                                    case 85:
                                                                        return R.string.guild_settings_action_filter_stage_instance_delete;
                                                                    default:
                                                                        switch (actionTypeId) {
                                                                            case 90:
                                                                                return R.string.guild_settings_action_filter_sticker_create;
                                                                            case 91:
                                                                                return R.string.guild_settings_action_filter_sticker_update;
                                                                            case 92:
                                                                                return R.string.guild_settings_action_filter_sticker_delete;
                                                                            default:
                                                                                return 0;
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
    }

    @DrawableRes
    public final int getActionTypeImage(int actionTypeId) {
        ModelAuditLogEntry.ActionType actionType = ModelAuditLogEntry.getActionType(actionTypeId);
        if (actionType != null) {
            int iOrdinal = actionType.ordinal();
            if (iOrdinal == 1) {
                return R.drawable.ic_audit_audit_create_24dp;
            }
            if (iOrdinal == 2) {
                return R.drawable.ic_audit_audit_update_24dp;
            }
            if (iOrdinal == 3) {
                return R.drawable.ic_audit_audit_delete_24dp;
            }
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final CharSequence getHeaderString(ModelAuditLogEntry auditLogEntry, CharSequence username, Context context, Map<ModelAuditLogEntry.TargetType, ? extends Map<Long, CharSequence>> targets, String prefix) {
        Object oldValue;
        CharSequence charSequenceValueOf;
        Object value;
        CharSequence charSequenceValueOf2;
        CharSequence charSequenceValueOf3;
        CharSequence charSequenceValueOf4;
        String strValueOf;
        Object next;
        Intrinsics3.checkNotNullParameter(auditLogEntry, "auditLogEntry");
        Intrinsics3.checkNotNullParameter(username, "username");
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(targets, "targets");
        Intrinsics3.checkNotNullParameter(prefix, "prefix");
        int actionTypeId = auditLogEntry.getActionTypeId();
        if (actionTypeId == 21) {
            int entryTitle = getEntryTitle(auditLogEntry);
            Object[] objArr = new Object[2];
            objArr[0] = username;
            Resources resources = context.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "context.resources");
            ModelAuditLogEntry.Options options = auditLogEntry.getOptions();
            int membersRemoved = options != null ? options.getMembersRemoved() : 0;
            Object[] objArr2 = new Object[1];
            ModelAuditLogEntry.Options options2 = auditLogEntry.getOptions();
            objArr2[0] = Integer.valueOf(options2 != null ? options2.getMembersRemoved() : 0);
            objArr[1] = StringResourceUtils.getQuantityString(resources, context, R.plurals.guild_settings_audit_log_member_prune_count, membersRemoved, objArr2);
            return FormatUtils.h(context, entryTitle, objArr, null, 4);
        }
        if (actionTypeId == 42) {
            int entryTitle2 = getEntryTitle(auditLogEntry);
            Object[] objArr3 = new Object[2];
            objArr3[0] = username;
            List<ModelAuditLogEntry.Change> changes = auditLogEntry.getChanges();
            if (changes != null) {
                for (ModelAuditLogEntry.Change change : changes) {
                    Intrinsics3.checkNotNullExpressionValue(change, "it");
                    if (Intrinsics3.areEqual(change.getKey(), ModelAuditLogEntry.CHANGE_KEY_CODE)) {
                        oldValue = change != null ? change.getOldValue() : null;
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            objArr3[1] = String.valueOf(oldValue);
            return FormatUtils.h(context, entryTitle2, objArr3, null, 4);
        }
        if (actionTypeId == 26) {
            ModelAuditLogEntry.Options options3 = auditLogEntry.getOptions();
            Long lValueOf = options3 != null ? Long.valueOf(options3.getChannelId()) : null;
            int entryTitle3 = getEntryTitle(auditLogEntry);
            Object[] objArr4 = new Object[3];
            objArr4[0] = username;
            ModelAuditLogEntry.Options options4 = auditLogEntry.getOptions();
            int count = options4 != null ? options4.getCount() : 0;
            Object[] objArr5 = new Object[1];
            ModelAuditLogEntry.Options options5 = auditLogEntry.getOptions();
            objArr5[0] = Integer.valueOf(options5 != null ? options5.getCount() : 0);
            objArr4[1] = StringResourceUtils.getI18nPluralString(context, R.plurals.guild_settings_audit_log_member_move_count, count, objArr5);
            Map<Long, CharSequence> map = targets.get(ModelAuditLogEntry.TargetType.CHANNEL);
            if (map == null || (charSequenceValueOf = map.get(lValueOf)) == null) {
                charSequenceValueOf = lValueOf != null ? String.valueOf(lValueOf.longValue()) : null;
            }
            objArr4[2] = charSequenceValueOf;
            return FormatUtils.h(context, entryTitle3, objArr4, null, 4);
        }
        if (actionTypeId == 27) {
            int entryTitle4 = getEntryTitle(auditLogEntry);
            Object[] objArr6 = new Object[2];
            objArr6[0] = username;
            ModelAuditLogEntry.Options options6 = auditLogEntry.getOptions();
            int count2 = options6 != null ? options6.getCount() : 0;
            Object[] objArr7 = new Object[1];
            ModelAuditLogEntry.Options options7 = auditLogEntry.getOptions();
            objArr7[0] = Integer.valueOf(options7 != null ? options7.getCount() : 0);
            objArr6[1] = StringResourceUtils.getI18nPluralString(context, R.plurals.guild_settings_audit_log_member_disconnect_count, count2, objArr7);
            return FormatUtils.h(context, entryTitle4, objArr6, null, 4);
        }
        switch (actionTypeId) {
            case 60:
            case 61:
            case 62:
                int entryTitle5 = getEntryTitle(auditLogEntry);
                Object[] objArr8 = new Object[2];
                objArr8[0] = username;
                List<ModelAuditLogEntry.Change> changes2 = auditLogEntry.getChanges();
                if (changes2 != null) {
                    for (ModelAuditLogEntry.Change change2 : changes2) {
                        Intrinsics3.checkNotNullExpressionValue(change2, "it");
                        if (Intrinsics3.areEqual(change2.getKey(), ModelAuditLogEntry.CHANGE_KEY_NAME)) {
                            value = change2 != null ? change2.getValue() : null;
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
                objArr8[1] = String.valueOf(value);
                return FormatUtils.h(context, entryTitle5, objArr8, null, 4);
            default:
                switch (actionTypeId) {
                    case 72:
                        ModelAuditLogEntry.Options options8 = auditLogEntry.getOptions();
                        Long lValueOf2 = options8 != null ? Long.valueOf(options8.getChannelId()) : null;
                        int entryTitle6 = getEntryTitle(auditLogEntry);
                        Object[] objArr9 = new Object[4];
                        objArr9[0] = username;
                        ModelAuditLogEntry.Options options9 = auditLogEntry.getOptions();
                        int count3 = options9 != null ? options9.getCount() : 0;
                        Object[] objArr10 = new Object[1];
                        ModelAuditLogEntry.Options options10 = auditLogEntry.getOptions();
                        objArr10[0] = Integer.valueOf(options10 != null ? options10.getCount() : 0);
                        objArr9[1] = StringResourceUtils.getI18nPluralString(context, R.plurals.guild_settings_audit_log_message_delete_count, count3, objArr10);
                        objArr9[2] = getTargetText(auditLogEntry, targets, prefix);
                        Map<Long, CharSequence> map2 = targets.get(ModelAuditLogEntry.TargetType.CHANNEL);
                        if (map2 == null || (charSequenceValueOf2 = map2.get(lValueOf2)) == null) {
                            charSequenceValueOf2 = lValueOf2 != null ? String.valueOf(lValueOf2.longValue()) : null;
                        }
                        objArr9[3] = charSequenceValueOf2;
                        return FormatUtils.h(context, entryTitle6, objArr9, null, 4);
                    case 73:
                        int entryTitle7 = getEntryTitle(auditLogEntry);
                        Object[] objArr11 = new Object[3];
                        objArr11[0] = username;
                        ModelAuditLogEntry.Options options11 = auditLogEntry.getOptions();
                        int count4 = options11 != null ? options11.getCount() : 0;
                        Object[] objArr12 = new Object[1];
                        ModelAuditLogEntry.Options options12 = auditLogEntry.getOptions();
                        objArr12[0] = Integer.valueOf(options12 != null ? options12.getCount() : 0);
                        objArr11[1] = StringResourceUtils.getI18nPluralString(context, R.plurals.guild_settings_audit_log_message_bulk_delete_count, count4, objArr12);
                        objArr11[2] = getTargetText(auditLogEntry, targets, prefix);
                        return FormatUtils.h(context, entryTitle7, objArr11, null, 4);
                    case 74:
                    case 75:
                        ModelAuditLogEntry.Options options13 = auditLogEntry.getOptions();
                        Long lValueOf3 = options13 != null ? Long.valueOf(options13.getChannelId()) : null;
                        int entryTitle8 = getEntryTitle(auditLogEntry);
                        Object[] objArr13 = new Object[3];
                        objArr13[0] = username;
                        objArr13[1] = getTargetText(auditLogEntry, targets, prefix);
                        Map<Long, CharSequence> map3 = targets.get(ModelAuditLogEntry.TargetType.CHANNEL);
                        if (map3 == null || (charSequenceValueOf3 = map3.get(lValueOf3)) == null) {
                            charSequenceValueOf3 = lValueOf3 != null ? String.valueOf(lValueOf3.longValue()) : null;
                        }
                        objArr13[2] = charSequenceValueOf3;
                        return FormatUtils.h(context, entryTitle8, objArr13, null, 4);
                    default:
                        switch (actionTypeId) {
                            case 83:
                            case 84:
                            case 85:
                                ModelAuditLogEntry.Options options14 = auditLogEntry.getOptions();
                                Long lValueOf4 = options14 != null ? Long.valueOf(options14.getChannelId()) : null;
                                Map<Long, CharSequence> map4 = targets.get(ModelAuditLogEntry.TargetType.CHANNEL);
                                if (map4 == null || (charSequenceValueOf4 = map4.get(lValueOf4)) == null) {
                                    charSequenceValueOf4 = lValueOf4 != null ? String.valueOf(lValueOf4.longValue()) : null;
                                }
                                return auditLogEntry.getUserId() == 0 ? FormatUtils.h(context, getEntryTitle(auditLogEntry), new Object[]{charSequenceValueOf4}, null, 4) : FormatUtils.h(context, getEntryTitle(auditLogEntry), new Object[]{username, charSequenceValueOf4}, null, 4);
                            default:
                                switch (actionTypeId) {
                                    case 90:
                                    case 91:
                                    case 92:
                                        int entryTitle9 = getEntryTitle(auditLogEntry);
                                        Object[] objArr14 = new Object[2];
                                        objArr14[0] = username;
                                        Sticker guildSticker = StoreStream.INSTANCE.getGuildStickers().getGuildSticker(auditLogEntry.getTargetId());
                                        if (guildSticker == null || (strValueOf = guildSticker.getName()) == null) {
                                            List<ModelAuditLogEntry.Change> changes3 = auditLogEntry.getChanges();
                                            if (changes3 != null) {
                                                Iterator<T> it = changes3.iterator();
                                                while (true) {
                                                    if (it.hasNext()) {
                                                        next = it.next();
                                                        ModelAuditLogEntry.Change change3 = (ModelAuditLogEntry.Change) next;
                                                        Intrinsics3.checkNotNullExpressionValue(change3, "it");
                                                        if (Intrinsics3.areEqual(change3.getKey(), ModelAuditLogEntry.CHANGE_KEY_NAME)) {
                                                        }
                                                    } else {
                                                        next = null;
                                                    }
                                                }
                                                ModelAuditLogEntry.Change change4 = (ModelAuditLogEntry.Change) next;
                                                Object value2 = change4 != null ? change4.getValue() : null;
                                                strValueOf = String.valueOf(value2);
                                            }
                                        }
                                        objArr14[1] = strValueOf;
                                        return FormatUtils.h(context, entryTitle9, objArr14, null, 4);
                                    default:
                                        return FormatUtils.h(context, getEntryTitle(auditLogEntry), new Object[]{username, getTargetText(auditLogEntry, targets, prefix)}, null, 4);
                                }
                        }
                }
        }
    }

    @DrawableRes
    public final int getTargetTypeImage(View view, int actionTypeId) {
        Intrinsics3.checkNotNullParameter(view, "view");
        ModelAuditLogEntry.TargetType targetType = ModelAuditLogEntry.getTargetType(actionTypeId);
        Intrinsics3.checkNotNullExpressionValue(targetType, "ModelAuditLogEntry.getTargetType(actionTypeId)");
        if (actionTypeId == 72) {
            return DrawableCompat.getThemedDrawableRes(view, R.attr.ic_audit_message, 0);
        }
        int iOrdinal = targetType.ordinal();
        if (iOrdinal == 0) {
            return DrawableCompat.getThemedDrawableRes(view, R.attr.ic_audit_all, 0);
        }
        switch (iOrdinal) {
            case 2:
                return DrawableCompat.getThemedDrawableRes(view, R.attr.ic_audit_server, 0);
            case 3:
            case 4:
                return DrawableCompat.getThemedDrawableRes(view, R.attr.ic_audit_channel, 0);
            case 5:
                return DrawableCompat.getThemedDrawableRes(view, R.attr.ic_audit_member, 0);
            case 6:
                return DrawableCompat.getThemedDrawableRes(view, R.attr.ic_audit_role, 0);
            case 7:
                return DrawableCompat.getThemedDrawableRes(view, R.attr.ic_audit_invite, 0);
            case 8:
                return DrawableCompat.getThemedDrawableRes(view, R.attr.ic_audit_webhook, 0);
            case 9:
                return DrawableCompat.getThemedDrawableRes(view, R.attr.ic_audit_emoji, 0);
            case 10:
                return DrawableCompat.getThemedDrawableRes(view, R.attr.ic_audit_integration, 0);
            case 11:
                return DrawableCompat.getThemedDrawableRes(view, R.attr.ic_audit_stage_instance, 0);
            case 12:
                return DrawableCompat.getThemedDrawableRes(view, R.attr.ic_audit_calendar, 0);
            case 13:
                return DrawableCompat.getThemedDrawableRes(view, R.attr.ic_audit_sticker, 0);
            case 14:
                return DrawableCompat.getThemedDrawableRes(view, R.attr.ic_audit_thread, 0);
            default:
                return 0;
        }
    }

    public final long getTimestampStart(ModelAuditLogEntry modelAuditLogEntry) {
        Intrinsics3.checkNotNullParameter(modelAuditLogEntry, "$this$getTimestampStart");
        return (modelAuditLogEntry.getId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH;
    }

    public final CharSequence getTimestampString(ModelAuditLogEntry auditLogEntry, Context context) {
        Intrinsics3.checkNotNullParameter(auditLogEntry, "auditLogEntry");
        Intrinsics3.checkNotNullParameter(context, "context");
        if (auditLogEntry.getTimestampEnd() == null) {
            return getTimestampText(getTimestampStart(auditLogEntry), context);
        }
        CharSequence timestampText = getTimestampText(getTimestampStart(auditLogEntry), context);
        Long timestampEnd = auditLogEntry.getTimestampEnd();
        if (timestampEnd == null) {
            timestampEnd = 0L;
        }
        Intrinsics3.checkNotNullExpressionValue(timestampEnd, "auditLogEntry.timestampEnd ?: 0L");
        return timestampText + " - " + getTimestampText(timestampEnd.longValue(), context);
    }
}
