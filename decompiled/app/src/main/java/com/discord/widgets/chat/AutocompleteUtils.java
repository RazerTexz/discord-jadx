package com.discord.widgets.chat;

import kotlin.Metadata;

/* compiled from: AutocompleteUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/chat/AutocompleteSelectionTypes;", "", "", "GIF", "Ljava/lang/String;", AutocompleteUtils.MENTION, "CHOICE", AutocompleteUtils.REACTION, AutocompleteUtils.STICKER, AutocompleteUtils.CHANNEL, AutocompleteUtils.COMMAND, AutocompleteUtils.EMOJI, "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.AutocompleteSelectionTypes, reason: use source file name */
/* loaded from: classes2.dex */
public final class AutocompleteUtils {
    public static final String CHANNEL = "CHANNEL";
    public static final String CHOICE = "CHOICE";
    public static final String COMMAND = "COMMAND";
    public static final String EMOJI = "EMOJI";
    public static final String GIF = "GIF";
    public static final AutocompleteUtils INSTANCE = new AutocompleteUtils();
    public static final String MENTION = "MENTION";
    public static final String REACTION = "REACTION";
    public static final String STICKER = "STICKER";

    private AutocompleteUtils() {
    }
}
