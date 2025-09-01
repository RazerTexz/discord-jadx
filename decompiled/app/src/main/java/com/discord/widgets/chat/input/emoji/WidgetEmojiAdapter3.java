package com.discord.widgets.chat.input.emoji;

import android.view.View;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.widgets.chat.input.emoji.WidgetEmojiAdapter;
import com.discord.widgets.emoji.WidgetEmojiSheet;
import d0.Result2;
import d0.Result3;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetEmojiAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.emoji.WidgetEmojiAdapter$EmojiViewHolder$onConfigure$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetEmojiAdapter3 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ WidgetEmojiAdapter.EmojiItem $emojiItem;
    public final /* synthetic */ WidgetEmojiAdapter.EmojiViewHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEmojiAdapter3(WidgetEmojiAdapter.EmojiViewHolder emojiViewHolder, WidgetEmojiAdapter.EmojiItem emojiItem) {
        super(1);
        this.this$0 = emojiViewHolder;
        this.$emojiItem = emojiItem;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Object objM97constructorimpl;
        Emoji emoji;
        Intrinsics3.checkNotNullParameter(view, "it");
        try {
            Result2.a aVar = Result2.j;
            emoji = this.$emojiItem.getEmoji();
        } catch (Throwable th) {
            Result2.a aVar2 = Result2.j;
            objM97constructorimpl = Result2.m97constructorimpl(Result3.createFailure(th));
        }
        if (emoji == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.discord.models.domain.emoji.ModelEmojiCustom");
        }
        objM97constructorimpl = Result2.m97constructorimpl(EmojiNode.INSTANCE.generateEmojiIdAndType((ModelEmojiCustom) emoji));
        if (Result2.m99exceptionOrNullimpl(objM97constructorimpl) != null) {
            try {
                Result2.a aVar3 = Result2.j;
                Emoji emoji2 = this.$emojiItem.getEmoji();
                if (emoji2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.discord.models.domain.emoji.ModelEmojiUnicode");
                }
                objM97constructorimpl = Result2.m97constructorimpl(EmojiNode.INSTANCE.generateEmojiIdAndType((ModelEmojiUnicode) emoji2));
            } catch (Throwable th2) {
                Result2.a aVar4 = Result2.j;
                objM97constructorimpl = Result2.m97constructorimpl(Result3.createFailure(th2));
            }
        }
        if (Result2.m102isSuccessimpl(objM97constructorimpl)) {
            WidgetEmojiAdapter.access$getHideKeyboard$p(WidgetEmojiAdapter.EmojiViewHolder.access$getAdapter$p(this.this$0)).invoke();
            WidgetEmojiSheet.INSTANCE.show(WidgetEmojiAdapter.access$getFragmentManager$p(WidgetEmojiAdapter.EmojiViewHolder.access$getAdapter$p(this.this$0)), (EmojiNode.EmojiIdAndType) objM97constructorimpl);
        }
    }
}
