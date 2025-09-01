package com.discord.stores;

import com.discord.R;
import com.discord.api.commands.ApplicationCommandType;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.commands.ApplicationCommand4;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreApplicationCommands.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\n\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ;\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ;\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/discord/stores/BuiltInCommands;", "Lcom/discord/stores/BuiltInCommandsProvider;", "", ModelAuditLogEntry.CHANGE_KEY_ID, "", ModelAuditLogEntry.CHANGE_KEY_NAME, "", "descriptionRes", "optionDescriptionRes", "replacement", "Lcom/discord/models/commands/ApplicationCommand;", "createAppendToEndSlashCommand", "(JLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/discord/models/commands/ApplicationCommand;", "wrapper", "createWrappedSlashCommand", "Lcom/discord/models/commands/Application;", "getFrecencyApplication", "()Lcom/discord/models/commands/Application;", "getBuiltInApplication", "", "getBuiltInCommands", "()Ljava/util/List;", "builtInCommands", "Ljava/util/List;", "builtInApplication", "Lcom/discord/models/commands/Application;", "<init>", "()V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class BuiltInCommands implements BuiltInCommandsProvider {
    public static final long BUILT_IN_APP_ID = -1;
    public static final long FRECENCY_APP_ID = -2;
    private final Application builtInApplication;
    private final List<ApplicationCommand> builtInCommands;

    /* compiled from: StoreApplicationCommands.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u00012\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "", "commandOptions", "invoke", "(Ljava/util/Map;)Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.BuiltInCommands$createAppendToEndSlashCommand$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Map<String, ? extends Object>, String> {
        public final /* synthetic */ String $replacement;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(1);
            this.$replacement = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ String invoke(Map<String, ? extends Object> map) {
            return invoke2(map);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2(Map<String, ? extends Object> map) {
            Intrinsics3.checkNotNullParameter(map, "commandOptions");
            StringBuilder sb = new StringBuilder();
            Object obj = map.get("message");
            if (obj == null) {
                obj = "";
            }
            sb.append(obj);
            sb.append(' ');
            sb.append(this.$replacement);
            return sb.toString();
        }
    }

    /* compiled from: StoreApplicationCommands.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u00012\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "", "commandOptions", "invoke", "(Ljava/util/Map;)Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.BuiltInCommands$createWrappedSlashCommand$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Map<String, ? extends Object>, String> {
        public final /* synthetic */ String $wrapper;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(1);
            this.$wrapper = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ String invoke(Map<String, ? extends Object> map) {
            return invoke2(map);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2(Map<String, ? extends Object> map) {
            Intrinsics3.checkNotNullParameter(map, "commandOptions");
            StringBuilder sb = new StringBuilder();
            sb.append(this.$wrapper);
            Object obj = map.get("message");
            if (obj == null) {
                obj = "";
            }
            sb.append(obj);
            sb.append(this.$wrapper);
            return sb.toString();
        }
    }

    public BuiltInCommands() {
        List<ApplicationCommand> listListOf = Collections2.listOf((Object[]) new ApplicationCommand[]{createAppendToEndSlashCommand(-1L, "shrug", Integer.valueOf(R.string.command_shrug_description), Integer.valueOf(R.string.command_shrug_message_description), "¯\\\\_(ツ)\\_/¯"), createAppendToEndSlashCommand(-2L, "tableflip", Integer.valueOf(R.string.command_tableflip_description), Integer.valueOf(R.string.command_tableflip_message_description), "(╯°□°）╯︵ ┻━┻"), createAppendToEndSlashCommand(-3L, "unflip", Integer.valueOf(R.string.command_tableunflip_description), Integer.valueOf(R.string.command_tableunflip_message_description), "┬─┬ ノ( ゜-゜ノ)"), createWrappedSlashCommand(-5L, "me", Integer.valueOf(R.string.command_me_description), Integer.valueOf(R.string.command_me_message_description), "_"), createWrappedSlashCommand(-6L, "spoiler", Integer.valueOf(R.string.command_spoiler_description), Integer.valueOf(R.string.command_spoiler_message_description), "||")});
        this.builtInCommands = listListOf;
        this.builtInApplication = new Application(-1L, "Built-In", null, Integer.valueOf(R.drawable.ic_slash_command_24dp), listListOf.size(), null, true, 36, null);
    }

    private final ApplicationCommand createAppendToEndSlashCommand(long id2, String name, Integer descriptionRes, Integer optionDescriptionRes, String replacement) {
        return new ApplicationCommand4(String.valueOf(id2), -1L, name, descriptionRes, CollectionsJVM.listOf(new ApplicationCommandOption(ApplicationCommandType.STRING, "message", null, optionDescriptionRes, false, false, null, null, null, false, null, null, 4036, null)), new AnonymousClass1(replacement));
    }

    private final ApplicationCommand createWrappedSlashCommand(long id2, String name, Integer descriptionRes, Integer optionDescriptionRes, String wrapper) {
        return new ApplicationCommand4(String.valueOf(id2), -1L, name, descriptionRes, CollectionsJVM.listOf(new ApplicationCommandOption(ApplicationCommandType.STRING, "message", null, optionDescriptionRes, true, false, null, null, null, false, null, null, 4036, null)), new AnonymousClass1(wrapper));
    }

    @Override // com.discord.stores.BuiltInCommandsProvider
    public Application getBuiltInApplication() {
        return this.builtInApplication;
    }

    @Override // com.discord.stores.BuiltInCommandsProvider
    public List<ApplicationCommand> getBuiltInCommands() {
        return this.builtInCommands;
    }

    @Override // com.discord.stores.BuiltInCommandsProvider
    public Application getFrecencyApplication() {
        return new Application(-2L, "Frequently Used", null, Integer.valueOf(R.drawable.ic_recent_24dp), 0, null, true, 36, null);
    }
}
