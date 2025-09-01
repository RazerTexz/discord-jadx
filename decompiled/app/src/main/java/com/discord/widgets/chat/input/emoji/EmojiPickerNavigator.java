package com.discord.widgets.chat.input.emoji;

import androidx.fragment.app.FragmentManager;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: EmojiPickerNavigator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J;\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\r8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/chat/input/emoji/EmojiPickerNavigator;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/discord/widgets/chat/input/emoji/EmojiPickerListener;", "emojiPickerListener", "Lcom/discord/widgets/chat/input/emoji/EmojiPickerContextType;", "emojiPickerContextType", "Lkotlin/Function0;", "", "onCancel", "launchBottomSheet", "(Landroidx/fragment/app/FragmentManager;Lcom/discord/widgets/chat/input/emoji/EmojiPickerListener;Lcom/discord/widgets/chat/input/emoji/EmojiPickerContextType;Lkotlin/jvm/functions/Function0;)V", "", "ARG_EMOJI_PICKER_CONTEXT_TYPE", "Ljava/lang/String;", "ARG_MODE", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class EmojiPickerNavigator {
    public static final String ARG_EMOJI_PICKER_CONTEXT_TYPE = "EMOJI_PICKER_CONTEXT_TYPE";
    public static final String ARG_MODE = "MODE";
    public static final EmojiPickerNavigator INSTANCE = new EmojiPickerNavigator();

    private EmojiPickerNavigator() {
    }

    public static final void launchBottomSheet(FragmentManager fragmentManager, EmojiPickerListener emojiPickerListener, EmojiPickerContextType emojiPickerContextType, Function0<Unit> onCancel) {
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(emojiPickerContextType, "emojiPickerContextType");
        WidgetEmojiPickerSheet.INSTANCE.show(fragmentManager, emojiPickerListener, emojiPickerContextType, onCancel);
    }

    public static /* synthetic */ void launchBottomSheet$default(FragmentManager fragmentManager, EmojiPickerListener emojiPickerListener, EmojiPickerContextType emojiPickerContextType, Function0 function0, int i, Object obj) {
        if ((i & 8) != 0) {
            function0 = null;
        }
        launchBottomSheet(fragmentManager, emojiPickerListener, emojiPickerContextType, function0);
    }
}
