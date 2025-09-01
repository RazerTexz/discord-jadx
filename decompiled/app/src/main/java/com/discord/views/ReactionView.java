package com.discord.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import b.a.i.ReactionViewBinding;
import com.discord.R;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ReactionView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J%\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010#\u001a\u0004\u0018\u00010\b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/discord/views/ReactionView;", "Landroid/widget/LinearLayout;", "", "isMe", "", "setIsMe", "(Z)V", "setTextColor", "Lcom/discord/api/message/reaction/MessageReaction;", "reaction", "", "messageId", "animateEmojis", "a", "(Lcom/discord/api/message/reaction/MessageReaction;JZ)V", "Landroid/content/res/ColorStateList;", ModelAuditLogEntry.CHANGE_KEY_COLOR, "setMeTextColor", "(Landroid/content/res/ColorStateList;)V", "", "j", "I", "curCount", "n", "Landroid/content/res/ColorStateList;", "meTextColor", "m", "textColor", "k", "Ljava/lang/Long;", "curMessageId", "Lb/a/i/i1;", "o", "Lb/a/i/i1;", "binding", "<set-?>", "l", "Lcom/discord/api/message/reaction/MessageReaction;", "getReaction", "()Lcom/discord/api/message/reaction/MessageReaction;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ReactionView extends LinearLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public int curCount;

    /* renamed from: k, reason: from kotlin metadata */
    public Long curMessageId;

    /* renamed from: l, reason: from kotlin metadata */
    public MessageReaction reaction;

    /* renamed from: m, reason: from kotlin metadata */
    public ColorStateList textColor;

    /* renamed from: n, reason: from kotlin metadata */
    public ColorStateList meTextColor;

    /* renamed from: o, reason: from kotlin metadata */
    public final ReactionViewBinding binding;

    public ReactionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ReactionView(Context context, AttributeSet attributeSet, int i, int i2) {
        attributeSet = (i2 & 2) != 0 ? null : attributeSet;
        i = (i2 & 4) != 0 ? 0 : i;
        Intrinsics3.checkNotNullParameter(context, "context");
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.reaction_view, this);
        int i3 = R.id.counter_text_1;
        TextView textView = (TextView) findViewById(R.id.counter_text_1);
        if (textView != null) {
            i3 = R.id.counter_text_2;
            TextView textView2 = (TextView) findViewById(R.id.counter_text_2);
            if (textView2 != null) {
                i3 = R.id.counter_text_switcher;
                TextSwitcher textSwitcher = (TextSwitcher) findViewById(R.id.counter_text_switcher);
                if (textSwitcher != null) {
                    i3 = R.id.emoji_text_view;
                    SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) findViewById(R.id.emoji_text_view);
                    if (simpleDraweeSpanTextView != null) {
                        ReactionViewBinding reactionViewBinding = new ReactionViewBinding(this, textView, textView2, textSwitcher, simpleDraweeSpanTextView);
                        Intrinsics3.checkNotNullExpressionValue(reactionViewBinding, "ReactionViewBinding.infl…ater.from(context), this)");
                        this.binding = reactionViewBinding;
                        int[] iArr = R.a.ReactionView;
                        Intrinsics3.checkNotNullExpressionValue(iArr, "R.styleable.ReactionView");
                        Context context2 = getContext();
                        Intrinsics3.checkNotNullExpressionValue(context2, "context");
                        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr);
                        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(attrs, styleable)");
                        this.meTextColor = typedArrayObtainStyledAttributes.getColorStateList(0);
                        this.textColor = typedArrayObtainStyledAttributes.getColorStateList(1);
                        typedArrayObtainStyledAttributes.recycle();
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i3)));
    }

    private final void setIsMe(boolean isMe) {
        setActivated(isMe);
        setSelected(isMe);
        TextView textView = this.binding.f132b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.counterText1");
        textView.setActivated(isMe);
        TextView textView2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.counterText2");
        textView2.setActivated(isMe);
    }

    private final void setTextColor(boolean isMe) {
        ColorStateList colorStateList = isMe ? this.meTextColor : this.textColor;
        if (colorStateList != null) {
            this.binding.f132b.setTextColor(colorStateList);
            this.binding.c.setTextColor(colorStateList);
        }
    }

    public final void a(MessageReaction reaction, long messageId, boolean animateEmojis) {
        Intrinsics3.checkNotNullParameter(reaction, "reaction");
        Long l = this.curMessageId;
        boolean z2 = l == null || l == null || l.longValue() != messageId;
        MessageReaction messageReaction = this.reaction;
        int count = reaction.getCount();
        ReactionViewBinding reactionViewBinding = this.binding;
        int i = this.curCount;
        if (count != i) {
            if (z2) {
                reactionViewBinding.d.setCurrentText(String.valueOf(count));
            } else {
                if (count > i) {
                    TextSwitcher textSwitcher = reactionViewBinding.d;
                    textSwitcher.setInAnimation(textSwitcher.getContext(), R.anim.anim_slide_in_up);
                    textSwitcher.setOutAnimation(textSwitcher.getContext(), R.anim.anim_slide_out_up);
                } else {
                    TextSwitcher textSwitcher2 = reactionViewBinding.d;
                    textSwitcher2.setInAnimation(textSwitcher2.getContext(), R.anim.anim_slide_in_down);
                    textSwitcher2.setOutAnimation(textSwitcher2.getContext(), R.anim.anim_slide_out_down);
                }
                reactionViewBinding.d.setText(String.valueOf(count));
            }
            this.curCount = count;
        }
        if (messageReaction == null || (!Intrinsics3.areEqual(reaction.getEmoji(), messageReaction.getEmoji()))) {
            EmojiNode.Companion companion = EmojiNode.INSTANCE;
            SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.emojiTextView");
            EmojiNode.Companion.renderEmoji$default(companion, simpleDraweeSpanTextView, reaction.getEmoji(), animateEmojis, 0, 4, null);
        }
        setIsMe(reaction.getMe());
        setTextColor(reaction.getMe());
        this.reaction = reaction;
        this.curMessageId = Long.valueOf(messageId);
    }

    public final MessageReaction getReaction() {
        return this.reaction;
    }

    public final void setMeTextColor(ColorStateList color) {
        Intrinsics3.checkNotNullParameter(color, ModelAuditLogEntry.CHANGE_KEY_COLOR);
        this.meTextColor = color;
    }
}
