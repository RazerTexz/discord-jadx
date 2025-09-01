package com.discord.widgets.forums;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.discord.R;
import com.discord.databinding.ForumPostTagViewBinding;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ForumPostTagView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/forums/ForumPostTagView;", "Landroid/widget/LinearLayout;", "Lcom/discord/widgets/forums/PostTagData;", "tag", "", "configureTag", "(Lcom/discord/widgets/forums/PostTagData;)V", "Lcom/discord/databinding/ForumPostTagViewBinding;", "binding", "Lcom/discord/databinding/ForumPostTagViewBinding;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ForumPostTagView extends LinearLayout {
    private static final int EMOJI_SIZE_PX = DimenUtils.dpToPixels(12);
    private static final int HORIZONTAL_PADDING = DimenUtils.dpToPixels(8);
    private static final int VERTICAL_PADDING = DimenUtils.dpToPixels(2);
    private final ForumPostTagViewBinding binding;

    public ForumPostTagView(Context context) {
        this(context, null, 0, 6, null);
    }

    public ForumPostTagView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ ForumPostTagView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void configureTag(PostData2 tag) {
        Intrinsics3.checkNotNullParameter(tag, "tag");
        EmojiNode.Companion companion = EmojiNode.INSTANCE;
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.f2110b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.tagEmoji");
        companion.renderEmoji(simpleDraweeSpanTextView, tag.getMessageReactionEmoji(), true, EMOJI_SIZE_PX);
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.tagName");
        textView.setText(tag.getTagName());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumPostTagView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.forum_post_tag_view, this);
        int i2 = R.id.tag_emoji;
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) findViewById(R.id.tag_emoji);
        if (simpleDraweeSpanTextView != null) {
            i2 = R.id.tag_name;
            TextView textView = (TextView) findViewById(R.id.tag_name);
            if (textView != null) {
                ForumPostTagViewBinding forumPostTagViewBinding = new ForumPostTagViewBinding(this, simpleDraweeSpanTextView, textView);
                Intrinsics3.checkNotNullExpressionValue(forumPostTagViewBinding, "ForumPostTagViewBinding.…ater.from(context), this)");
                this.binding = forumPostTagViewBinding;
                int i3 = HORIZONTAL_PADDING;
                int i4 = VERTICAL_PADDING;
                setPadding(i3, i4, i3, i4);
                setBackground(ContextCompat.getDrawable(context, DrawableCompat.getThemedDrawableRes$default(context, R.attr.theme_forum_post_tag_background, 0, 2, (Object) null)));
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i2)));
    }
}
