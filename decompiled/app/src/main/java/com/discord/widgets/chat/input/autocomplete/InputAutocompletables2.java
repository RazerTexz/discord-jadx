package com.discord.widgets.chat.input.autocomplete;

import com.discord.stores.StoreStream;
import com.discord.widgets.chat.input.autocomplete.sources.ApplicationCommandsAutocompletableSource;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: InputAutocompletables.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/sources/ApplicationCommandsAutocompletableSource;", "invoke", "()Lcom/discord/widgets/chat/input/autocomplete/sources/ApplicationCommandsAutocompletableSource;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.autocomplete.ChatInputAutocompletables$APPLICATION_COMMANDS_SOURCE$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class InputAutocompletables2 extends Lambda implements Function0<ApplicationCommandsAutocompletableSource> {
    public static final InputAutocompletables2 INSTANCE = new InputAutocompletables2();

    public InputAutocompletables2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ApplicationCommandsAutocompletableSource invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ApplicationCommandsAutocompletableSource invoke() {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return new ApplicationCommandsAutocompletableSource(companion.getUsers(), companion.getGuilds(), companion.getApplicationCommands());
    }
}
