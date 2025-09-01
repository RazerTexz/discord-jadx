package com.discord.widgets.chat.input.autocomplete;

import com.discord.models.domain.emoji.Emoji;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: Autocompletable.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B%\u0012\u0006\u0010\t\u001a\u00020\b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\t\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0007R\u0019\u0010\u0012\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/EmojiUpsellPlaceholder;", "Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", "", "getInputReplacement", "()Ljava/lang/String;", "", "getInputTextMatchers", "()Ljava/util/List;", "", "lockedTotal", "I", "getLockedTotal", "()I", "Lcom/discord/models/domain/emoji/Emoji;", "lockedFirstThree", "Ljava/util/List;", "getLockedFirstThree", "", "allowEmojiToAnimate", "Z", "getAllowEmojiToAnimate", "()Z", "<init>", "(ILjava/util/List;Z)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class EmojiUpsellPlaceholder extends Autocompletable {
    public static final int EMOJI_PREVIEW_COUNT = 3;
    private final boolean allowEmojiToAnimate;
    private final List<Emoji> lockedFirstThree;
    private final int lockedTotal;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EmojiUpsellPlaceholder(int i, List<? extends Emoji> list, boolean z2) {
        super(null);
        Intrinsics3.checkNotNullParameter(list, "lockedFirstThree");
        this.lockedTotal = i;
        this.lockedFirstThree = list;
        this.allowEmojiToAnimate = z2;
    }

    public final boolean getAllowEmojiToAnimate() {
        return this.allowEmojiToAnimate;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public String getInputReplacement() {
        return "";
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public List<String> getInputTextMatchers() {
        return Collections2.emptyList();
    }

    public final List<Emoji> getLockedFirstThree() {
        return this.lockedFirstThree;
    }

    public final int getLockedTotal() {
        return this.lockedTotal;
    }
}
