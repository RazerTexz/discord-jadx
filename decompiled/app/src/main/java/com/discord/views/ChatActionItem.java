package com.discord.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import b.a.i.ViewChatActionItemBinding;
import com.discord.R;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ChatActionItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\f"}, d2 = {"Lcom/discord/views/ChatActionItem;", "Landroidx/cardview/widget/CardView;", "Lb/a/i/b2;", "j", "Lb/a/i/b2;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ChatActionItem extends CardView {

    /* renamed from: j, reason: from kotlin metadata */
    public final ViewChatActionItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatActionItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.view_chat_action_item, this);
        int i = R.id.chat_action_item_image;
        ImageView imageView = (ImageView) findViewById(R.id.chat_action_item_image);
        if (imageView != null) {
            i = R.id.chat_action_item_text;
            TextView textView = (TextView) findViewById(R.id.chat_action_item_text);
            if (textView != null) {
                ViewChatActionItemBinding viewChatActionItemBinding = new ViewChatActionItemBinding(this, imageView, textView);
                Intrinsics3.checkNotNullExpressionValue(viewChatActionItemBinding, "ViewChatActionItemBindin…ater.from(context), this)");
                this.binding = viewChatActionItemBinding;
                TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.a.ChatActionItem, 0, 0);
                Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…hatActionItem, 0, 0\n    )");
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatActionItemText");
                textView.setText(typedArrayObtainStyledAttributes.getString(1));
                imageView.setImageResource(typedArrayObtainStyledAttributes.getResourceId(0, R.drawable.drawable_circle_white_1));
                typedArrayObtainStyledAttributes.recycle();
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }
}
