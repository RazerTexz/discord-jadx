package com.discord.widgets.chat.list.sheet;

import com.discord.api.commands.ApplicationCommandData;
import com.discord.api.commands.ApplicationCommandData3;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheetViewModel;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetApplicationCommandBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0005\u001a\u00020\u0002*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\u0005\u001a\u00020\u0002*\u00020\u00072\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0004\b\u0005\u0010\b¨\u0006\t"}, d2 = {"Lcom/discord/api/commands/ApplicationCommandData;", "", "", "Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$SlashCommandParam;", "commandValues", "toSlashCommandCopyString", "(Lcom/discord/api/commands/ApplicationCommandData;Ljava/util/Map;)Ljava/lang/String;", "Lcom/discord/api/commands/ApplicationCommandValue;", "(Lcom/discord/api/commands/ApplicationCommandValue;Ljava/util/Map;)Ljava/lang/String;", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheetKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetApplicationCommandBottomSheet5 {

    /* compiled from: WidgetApplicationCommandBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/commands/ApplicationCommandValue;", "it", "", "invoke", "(Lcom/discord/api/commands/ApplicationCommandValue;)Ljava/lang/CharSequence;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheetKt$toSlashCommandCopyString$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ApplicationCommandData3, CharSequence> {
        public final /* synthetic */ Map $commandValues;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Map map) {
            super(1);
            this.$commandValues = map;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final CharSequence invoke2(ApplicationCommandData3 applicationCommandData3) {
            Intrinsics3.checkNotNullParameter(applicationCommandData3, "it");
            return WidgetApplicationCommandBottomSheet5.toSlashCommandCopyString(applicationCommandData3, (Map<String, WidgetApplicationCommandBottomSheetViewModel.SlashCommandParam>) this.$commandValues);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(ApplicationCommandData3 applicationCommandData3) {
            return invoke2(applicationCommandData3);
        }
    }

    /* compiled from: WidgetApplicationCommandBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/commands/ApplicationCommandValue;", "it", "", "invoke", "(Lcom/discord/api/commands/ApplicationCommandValue;)Ljava/lang/CharSequence;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheetKt$toSlashCommandCopyString$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<ApplicationCommandData3, CharSequence> {
        public final /* synthetic */ Map $commandValues;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Map map) {
            super(1);
            this.$commandValues = map;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final CharSequence invoke2(ApplicationCommandData3 applicationCommandData3) {
            Intrinsics3.checkNotNullParameter(applicationCommandData3, "it");
            return WidgetApplicationCommandBottomSheet5.toSlashCommandCopyString(applicationCommandData3, (Map<String, WidgetApplicationCommandBottomSheetViewModel.SlashCommandParam>) this.$commandValues);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(ApplicationCommandData3 applicationCommandData3) {
            return invoke2(applicationCommandData3);
        }
    }

    public static final String toSlashCommandCopyString(ApplicationCommandData applicationCommandData, Map<String, WidgetApplicationCommandBottomSheetViewModel.SlashCommandParam> map) {
        String strJoinToString$default;
        Intrinsics3.checkNotNullParameter(applicationCommandData, "$this$toSlashCommandCopyString");
        Intrinsics3.checkNotNullParameter(map, "commandValues");
        StringBuilder sb = new StringBuilder();
        sb.append(MentionUtils.SLASH_CHAR);
        sb.append(applicationCommandData.getName());
        sb.append(' ');
        List<ApplicationCommandData3> listB = applicationCommandData.b();
        if (listB == null || (strJoinToString$default = _Collections.joinToString$default(listB, " ", null, null, 0, null, new AnonymousClass1(map), 30, null)) == null) {
            strJoinToString$default = "";
        }
        sb.append(strJoinToString$default);
        return sb.toString();
    }

    public static final String toSlashCommandCopyString(ApplicationCommandData3 applicationCommandData3, Map<String, WidgetApplicationCommandBottomSheetViewModel.SlashCommandParam> map) {
        Intrinsics3.checkNotNullParameter(applicationCommandData3, "$this$toSlashCommandCopyString");
        Intrinsics3.checkNotNullParameter(map, "commandValues");
        if (applicationCommandData3.c() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(applicationCommandData3.getName());
            sb.append(' ');
            List<ApplicationCommandData3> listC = applicationCommandData3.c();
            sb.append(listC != null ? _Collections.joinToString$default(listC, " ", null, null, 0, null, new AnonymousClass2(map), 30, null) : null);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(applicationCommandData3.getName());
        sb2.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
        WidgetApplicationCommandBottomSheetViewModel.SlashCommandParam slashCommandParam = map.get(applicationCommandData3.getName());
        sb2.append(slashCommandParam != null ? slashCommandParam.getCopyText() : null);
        return sb2.toString();
    }
}
