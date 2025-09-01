package com.discord.utilities.channel;

import android.content.Context;
import androidx.annotation.StringRes;
import b.a.d.AppHelpDesk;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.api.role.GuildRole;
import d0.Tuples;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Tuples2;

/* compiled from: ChannelPermissionUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a)\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"", "useNewThreadsPermissions", "Landroid/content/Context;", "context", "", "", "Lcom/discord/utilities/channel/PermissionLabelOverrides;", "getCategoryLabels", "(ZLandroid/content/Context;)Ljava/util/Map;", "Lcom/discord/api/role/GuildRole;", "role", "getChannelPermissionOwnerRoleLabel", "(Lcom/discord/api/role/GuildRole;)I", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.channel.ChannelPermissionUtilsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class ChannelPermissionUtils {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v17, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r5v14, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.lang.CharSequence] */
    public static final Map<Integer, ChannelPermissionUtils2> getCategoryLabels(boolean z2, Context context) {
        String str;
        String strH;
        String strH2;
        String str2;
        String strH3;
        String strH4;
        String str3;
        String strH5;
        String strH6;
        Intrinsics3.checkNotNullParameter(context, "context");
        Tuples2[] tuples2Arr = new Tuples2[29];
        Integer numValueOf = Integer.valueOf(R.id.channel_permission_text_read_messages);
        String string = context.getString(R.string.role_permissions_view_channel);
        String string2 = context.getString(R.string.role_permissions_view_channel_description_category);
        Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.stri…nel_description_category)");
        tuples2Arr[0] = Tuples.to(numValueOf, new ChannelPermissionUtils2(string2, string, null, null, context.getString(R.string.role_permissions_view_channel_description_text_everyone), context.getString(R.string.role_permissions_view_channel_description_voice_everyone), null, context.getString(R.string.role_permissions_view_channel_description_category_everyone), null, 332, null));
        Integer numValueOf2 = Integer.valueOf(R.id.channel_permission_general_manage_channel);
        String string3 = context.getString(R.string.manage_channels);
        String string4 = context.getString(R.string.role_permissions_manage_channel_description_category);
        Intrinsics3.checkNotNullExpressionValue(string4, "context.getString(R.stri…nel_description_category)");
        tuples2Arr[1] = Tuples.to(numValueOf2, new ChannelPermissionUtils2(string4, string3, context.getString(R.string.role_permissions_manage_channel_description_voice), context.getString(R.string.role_permissions_manage_channel_description_stage), null, null, null, null, null, 496, null));
        Integer numValueOf3 = Integer.valueOf(R.id.channel_permission_general_manage_threads);
        String string5 = context.getString(R.string.role_permissions_manage_threads_description_category);
        Intrinsics3.checkNotNullExpressionValue(string5, "context.getString(R.stri…ads_description_category)");
        tuples2Arr[2] = Tuples.to(numValueOf3, new ChannelPermissionUtils2(string5, null, null, null, null, null, null, context.getString(R.string.role_permissions_manage_threads_description_category), null, 382, null));
        Integer numValueOf4 = Integer.valueOf(R.id.channel_permission_general_manage_permissions);
        String string6 = context.getString(R.string.role_permissions_manage_roles_description_category);
        Intrinsics3.checkNotNullExpressionValue(string6, "context.getString(R.stri…les_description_category)");
        tuples2Arr[3] = Tuples.to(numValueOf4, new ChannelPermissionUtils2(string6, null, null, context.getString(R.string.role_permissions_manage_roles_description_stage), null, null, null, null, null, 502, null));
        Integer numValueOf5 = Integer.valueOf(R.id.channel_permission_general_manage_webhooks);
        String string7 = context.getString(R.string.role_permissions_manage_webhooks_description_category);
        Intrinsics3.checkNotNullExpressionValue(string7, "context.getString(R.stri…oks_description_category)");
        tuples2Arr[4] = Tuples.to(numValueOf5, new ChannelPermissionUtils2(string7, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf6 = Integer.valueOf(R.id.channel_permission_text_send_messages);
        String string8 = context.getString(R.string.role_permissions_send_messages_description_category);
        Intrinsics3.checkNotNullExpressionValue(string8, "context.getString(R.stri…ges_description_category)");
        AppHelpDesk appHelpDesk = AppHelpDesk.a;
        tuples2Arr[5] = Tuples.to(numValueOf6, new ChannelPermissionUtils2(string8, null, null, null, null, null, null, null, FormatUtils.h(context, R.string.role_permissions_send_messages_description_announcement, new Object[]{appHelpDesk.a(360032008192L, null)}, null, 4), 254, null));
        Integer numValueOf7 = Integer.valueOf(R.id.channel_permission_text_send_messages_in_threads);
        if (z2) {
            strH = context.getString(R.string.role_permissions_send_messages_in_threads_description_category);
            str = "context.getString(R.stri…ads_description_category)";
            Intrinsics3.checkNotNullExpressionValue(strH, str);
        } else {
            str = "context.getString(R.stri…ads_description_category)";
            strH = FormatUtils.h(context, R.string.interim_role_permissions_send_messages_in_threads_description_category, new Object[0], null, 4);
        }
        if (z2) {
            String string9 = context.getString(R.string.role_permissions_send_messages_in_threads_description_category);
            Intrinsics3.checkNotNullExpressionValue(string9, str);
            strH2 = string9;
        } else {
            strH2 = FormatUtils.h(context, R.string.interim_role_permissions_send_messages_in_threads_description_category, new Object[0], null, 4);
        }
        String str4 = str;
        tuples2Arr[6] = Tuples.to(numValueOf7, new ChannelPermissionUtils2(strH, null, null, null, null, null, null, strH2, null, 382, null));
        Integer numValueOf8 = Integer.valueOf(R.id.channel_permission_text_create_public_threads);
        if (z2) {
            strH3 = context.getString(R.string.role_permissions_create_public_threads_description_category);
            str2 = str4;
            Intrinsics3.checkNotNullExpressionValue(strH3, str2);
        } else {
            str2 = str4;
            strH3 = FormatUtils.h(context, R.string.interim_role_permissions_create_public_threads_description_category, new Object[0], null, 4);
        }
        if (z2) {
            String string10 = context.getString(R.string.role_permissions_create_public_threads_description_category);
            Intrinsics3.checkNotNullExpressionValue(string10, str2);
            strH4 = string10;
        } else {
            strH4 = FormatUtils.h(context, R.string.interim_role_permissions_create_public_threads_description_category, new Object[0], null, 4);
        }
        String str5 = strH4;
        String str6 = str2;
        tuples2Arr[7] = Tuples.to(numValueOf8, new ChannelPermissionUtils2(strH3, null, null, null, null, null, null, str5, null, 382, null));
        Integer numValueOf9 = Integer.valueOf(R.id.channel_permission_text_create_private_threads);
        if (z2) {
            strH5 = context.getString(R.string.role_permissions_create_private_threads_description_category);
            str3 = str6;
            Intrinsics3.checkNotNullExpressionValue(strH5, str3);
        } else {
            str3 = str6;
            strH5 = FormatUtils.h(context, R.string.interim_role_permissions_create_private_threads_description_category, new Object[0], null, 4);
        }
        if (z2) {
            String string11 = context.getString(R.string.role_permissions_create_private_threads_description_category);
            Intrinsics3.checkNotNullExpressionValue(string11, str3);
            strH6 = string11;
        } else {
            strH6 = FormatUtils.h(context, R.string.interim_role_permissions_create_private_threads_description_category, new Object[0], null, 4);
        }
        tuples2Arr[8] = Tuples.to(numValueOf9, new ChannelPermissionUtils2(strH5, null, null, null, null, null, null, strH6, null, 382, null));
        Integer numValueOf10 = Integer.valueOf(R.id.channel_permission_general_create_instant_invite);
        String string12 = context.getString(R.string.role_permissions_create_instant_invite_description_category);
        Intrinsics3.checkNotNullExpressionValue(string12, "context.getString(R.stri…ite_description_category)");
        tuples2Arr[9] = Tuples.to(numValueOf10, new ChannelPermissionUtils2(string12, null, context.getString(R.string.role_permissions_create_instant_invite_description_voice), null, null, null, null, null, null, 506, null));
        Integer numValueOf11 = Integer.valueOf(R.id.channel_permission_text_embed_links);
        String string13 = context.getString(R.string.role_permissions_embed_links_description_category);
        Intrinsics3.checkNotNullExpressionValue(string13, "context.getString(R.stri…nks_description_category)");
        tuples2Arr[10] = Tuples.to(numValueOf11, new ChannelPermissionUtils2(string13, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf12 = Integer.valueOf(R.id.channel_permission_text_attach_files);
        String string14 = context.getString(R.string.role_permissions_attach_files_description_category);
        Intrinsics3.checkNotNullExpressionValue(string14, "context.getString(R.stri…les_description_category)");
        tuples2Arr[11] = Tuples.to(numValueOf12, new ChannelPermissionUtils2(string14, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf13 = Integer.valueOf(R.id.channel_permission_text_add_reactions);
        String string15 = context.getString(R.string.role_permissions_add_reactions_description_category);
        Intrinsics3.checkNotNullExpressionValue(string15, "context.getString(R.stri…ons_description_category)");
        tuples2Arr[12] = Tuples.to(numValueOf13, new ChannelPermissionUtils2(string15, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf14 = Integer.valueOf(R.id.channel_permission_text_use_external_emojis);
        String string16 = context.getString(R.string.role_permissions_use_external_emojis_description_category);
        Intrinsics3.checkNotNullExpressionValue(string16, "context.getString(R.stri…jis_description_category)");
        tuples2Arr[13] = Tuples.to(numValueOf14, new ChannelPermissionUtils2(string16, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf15 = Integer.valueOf(R.id.channel_permission_text_use_external_stickers);
        String string17 = context.getString(R.string.role_permissions_use_external_stickers_description_category);
        Intrinsics3.checkNotNullExpressionValue(string17, "context.getString(R.stri…ers_description_category)");
        tuples2Arr[14] = Tuples.to(numValueOf15, new ChannelPermissionUtils2(string17, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf16 = Integer.valueOf(R.id.channel_permission_text_mention_everyone);
        String string18 = context.getString(R.string.role_permissions_mention_everyone_description_category);
        Intrinsics3.checkNotNullExpressionValue(string18, "context.getString(R.stri…one_description_category)");
        tuples2Arr[15] = Tuples.to(numValueOf16, new ChannelPermissionUtils2(string18, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf17 = Integer.valueOf(R.id.channel_permission_text_manage_messages);
        String string19 = context.getString(R.string.role_permissions_manage_messages_description_category);
        Intrinsics3.checkNotNullExpressionValue(string19, "context.getString(R.stri…ges_description_category)");
        tuples2Arr[16] = Tuples.to(numValueOf17, new ChannelPermissionUtils2(string19, null, null, null, null, null, null, null, FormatUtils.h(context, R.string.role_permissions_manage_messages_description_announcement, new Object[]{appHelpDesk.a(360032008192L, null)}, null, 4), 254, null));
        Integer numValueOf18 = Integer.valueOf(R.id.channel_permission_text_read_message_history);
        String string20 = context.getString(R.string.role_permissions_read_message_history_description_category);
        Intrinsics3.checkNotNullExpressionValue(string20, "context.getString(R.stri…ory_description_category)");
        tuples2Arr[17] = Tuples.to(numValueOf18, new ChannelPermissionUtils2(string20, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf19 = Integer.valueOf(R.id.channel_permission_text_send_tts_messages);
        String string21 = context.getString(R.string.role_permissions_send_tts_messages_description_category);
        Intrinsics3.checkNotNullExpressionValue(string21, "context.getString(R.stri…ges_description_category)");
        tuples2Arr[18] = Tuples.to(numValueOf19, new ChannelPermissionUtils2(string21, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf20 = Integer.valueOf(R.id.channel_permission_voice_connect);
        String string22 = context.getString(R.string.role_permissions_connect_description_category);
        Intrinsics3.checkNotNullExpressionValue(string22, "context.getString(R.stri…ect_description_category)");
        tuples2Arr[19] = Tuples.to(numValueOf20, new ChannelPermissionUtils2(string22, null, null, context.getString(R.string.role_permissions_connect_description_stage), null, context.getString(R.string.role_permissions_connect_description_voice_everyone), context.getString(R.string.role_permissions_connect_description_stage_everyone), context.getString(R.string.role_permissions_connect_description_category_everyone), null, 278, null));
        Integer numValueOf21 = Integer.valueOf(R.id.channel_permission_voice_speak);
        String string23 = context.getString(R.string.role_permissions_speak_description_category);
        Intrinsics3.checkNotNullExpressionValue(string23, "context.getString(R.stri…eak_description_category)");
        tuples2Arr[20] = Tuples.to(numValueOf21, new ChannelPermissionUtils2(string23, null, null, context.getString(R.string.role_permissions_speak_description_stage), null, null, null, null, null, 502, null));
        Integer numValueOf22 = Integer.valueOf(R.id.channel_permission_voice_video);
        String string24 = context.getString(R.string.role_permissions_stream_description_category);
        Intrinsics3.checkNotNullExpressionValue(string24, "context.getString(R.stri…eam_description_category)");
        tuples2Arr[21] = Tuples.to(numValueOf22, new ChannelPermissionUtils2(string24, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf23 = Integer.valueOf(R.id.channel_permission_voice_use_vad);
        String string25 = context.getString(R.string.role_permissions_use_vad_description_category);
        Intrinsics3.checkNotNullExpressionValue(string25, "context.getString(R.stri…vad_description_category)");
        tuples2Arr[22] = Tuples.to(numValueOf23, new ChannelPermissionUtils2(string25, null, null, context.getString(R.string.role_permissions_use_vad_description_stage), null, null, null, null, null, 502, null));
        tuples2Arr[23] = Tuples.to(Integer.valueOf(R.id.channel_permission_voice_priority_speaker), new ChannelPermissionUtils2(FormatUtils.h(context, R.string.role_permissions_priority_speaker_description_category_mobile, new Object[]{FormatUtils.h(context, R.string.keybind_push_to_talk_priority, new Object[0], null, 4)}, null, 4), null, null, null, null, null, null, FormatUtils.h(context, R.string.role_permissions_priority_speaker_description_category_mobile, new Object[]{FormatUtils.h(context, R.string.keybind_push_to_talk_priority, new Object[0], null, 4)}, null, 4), null, 382, null));
        tuples2Arr[24] = Tuples.to(Integer.valueOf(R.id.channel_permission_voice_mute_members), new ChannelPermissionUtils2(FormatUtils.h(context, R.string.role_permissions_mute_members_description_category, new Object[0], null, 4), null, null, FormatUtils.h(context, R.string.role_permissions_mute_members_description_stage, new Object[0], null, 4), null, null, null, null, null, 502, null));
        Integer numValueOf24 = Integer.valueOf(R.id.channel_permission_voice_deafen_members);
        String string26 = context.getString(R.string.role_permissions_deafen_members_description_category);
        Intrinsics3.checkNotNullExpressionValue(string26, "context.getString(R.stri…ers_description_category)");
        tuples2Arr[25] = Tuples.to(numValueOf24, new ChannelPermissionUtils2(string26, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf25 = Integer.valueOf(R.id.channel_permission_voice_move_members);
        String string27 = context.getString(R.string.role_permissions_move_members_description_category);
        Intrinsics3.checkNotNullExpressionValue(string27, "context.getString(R.stri…ers_description_category)");
        tuples2Arr[26] = Tuples.to(numValueOf25, new ChannelPermissionUtils2(string27, null, null, context.getString(R.string.role_permissions_move_members_description_stage), null, null, null, null, null, 502, null));
        Integer numValueOf26 = Integer.valueOf(R.id.channel_permission_stage_request_to_speak);
        String string28 = context.getString(R.string.role_permissions_request_to_speak_description_category);
        Intrinsics3.checkNotNullExpressionValue(string28, "context.getString(R.stri…eak_description_category)");
        tuples2Arr[27] = Tuples.to(numValueOf26, new ChannelPermissionUtils2(string28, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf27 = Integer.valueOf(R.id.channel_permission_events_manage_events);
        String string29 = context.getString(R.string.role_permissions_manage_events_description_category);
        Intrinsics3.checkNotNullExpressionValue(string29, "context.getString(R.stri…nts_description_category)");
        tuples2Arr[28] = Tuples.to(numValueOf27, new ChannelPermissionUtils2(string29, null, null, null, null, null, null, null, null, 510, null));
        return Maps6.hashMapOf(tuples2Arr);
    }

    @StringRes
    public static final int getChannelPermissionOwnerRoleLabel(GuildRole guildRole) {
        Intrinsics3.checkNotNullParameter(guildRole, "role");
        return (guildRole.getPermissions() & 8) == 8 ? R.string.private_channel_add_members_modal_row_administrator : R.string.private_channel_add_members_modal_row_role;
    }
}
