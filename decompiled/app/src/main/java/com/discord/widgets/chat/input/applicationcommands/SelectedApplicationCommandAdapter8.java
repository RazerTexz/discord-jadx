package com.discord.widgets.chat.input.applicationcommands;

import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;

/* compiled from: SelectedApplicationCommandAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 )2\u00020\u0001:\u0001)BU\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b'\u0010(R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u00020\t8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u00020\u00148\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010\u0016\u001a\u0004\b!\u0010\u0018R\u001b\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/discord/widgets/chat/input/applicationcommands/SelectedApplicationCommandItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", "completed", "Z", "getCompleted", "()Z", "setCompleted", "(Z)V", "", "type", "I", "getType", "()I", "highlighted", "getHighlighted", "setHighlighted", "error", "getError", "setError", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "heading", "getHeading", "Lcom/discord/models/commands/ApplicationCommandOption;", "option", "Lcom/discord/models/commands/ApplicationCommandOption;", "getOption", "()Lcom/discord/models/commands/ApplicationCommandOption;", "key", "getKey", "Lcom/discord/models/commands/Application;", "application", "Lcom/discord/models/commands/Application;", "getApplication", "()Lcom/discord/models/commands/Application;", "<init>", "(Lcom/discord/models/commands/Application;Lcom/discord/models/commands/ApplicationCommandOption;ZZZLjava/lang/String;Ljava/lang/String;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.applicationcommands.SelectedApplicationCommandItem, reason: use source file name */
/* loaded from: classes2.dex */
public final class SelectedApplicationCommandAdapter8 implements MGRecyclerDataPayload {
    public static final int TYPE_PARAM = 1;
    public static final int TYPE_SECTION_HEADING = 2;
    public static final int TYPE_TITLE = 0;
    private final Application application;
    private boolean completed;
    private boolean error;
    private final String heading;
    private boolean highlighted;
    private final String key;
    private final ApplicationCommandOption option;
    private final String title;
    private final int type;

    public SelectedApplicationCommandAdapter8() {
        this(null, null, false, false, false, null, null, Opcodes.LAND, null);
    }

    public SelectedApplicationCommandAdapter8(Application application, ApplicationCommandOption applicationCommandOption, boolean z2, boolean z3, boolean z4, String str, String str2) {
        this.application = application;
        this.option = applicationCommandOption;
        this.highlighted = z2;
        this.error = z3;
        this.completed = z4;
        this.title = str;
        this.heading = str2;
        this.type = applicationCommandOption != null ? 1 : str != null ? 0 : 2;
        int type = getType();
        if (type != 0) {
            if (type != 1) {
                str = type != 2 ? "" : str2 != null ? str2 : "heading";
            } else if (applicationCommandOption == null || (str = applicationCommandOption.getName()) == null) {
                str = "option";
            }
        } else if (str == null) {
            str = "title";
        }
        this.key = str;
    }

    public final Application getApplication() {
        return this.application;
    }

    public final boolean getCompleted() {
        return this.completed;
    }

    public final boolean getError() {
        return this.error;
    }

    public final String getHeading() {
        return this.heading;
    }

    public final boolean getHighlighted() {
        return this.highlighted;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final ApplicationCommandOption getOption() {
        return this.option;
    }

    public final String getTitle() {
        return this.title;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public final void setCompleted(boolean z2) {
        this.completed = z2;
    }

    public final void setError(boolean z2) {
        this.error = z2;
    }

    public final void setHighlighted(boolean z2) {
        this.highlighted = z2;
    }

    public /* synthetic */ SelectedApplicationCommandAdapter8(Application application, ApplicationCommandOption applicationCommandOption, boolean z2, boolean z3, boolean z4, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : application, (i & 2) != 0 ? null : applicationCommandOption, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3, (i & 16) != 0 ? false : z4, (i & 32) != 0 ? null : str, (i & 64) != 0 ? null : str2);
    }
}
