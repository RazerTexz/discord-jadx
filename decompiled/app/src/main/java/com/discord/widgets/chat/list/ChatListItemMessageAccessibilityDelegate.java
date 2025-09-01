package com.discord.widgets.chat.list;

import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import defpackage.SpoilerSpan;
import java.util.ArrayList;
import kotlin.Metadata;

/* compiled from: ChatListItemMessageAccessibilityDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\f\u001a\u00020\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0018\u0010\r\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/chat/list/ChatListItemMessageAccessibilityDelegate;", "Landroidx/core/view/AccessibilityDelegateCompat;", "Landroid/view/View;", "host", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "info", "", "onInitializeAccessibilityNodeInfo", "(Landroid/view/View;Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;)V", "Landroid/widget/TextView;", "tagView", "Landroid/widget/TextView;", "textView", "nameView", "timestampView", "<init>", "(Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ChatListItemMessageAccessibilityDelegate extends AccessibilityDelegateCompat {
    private final TextView nameView;
    private final TextView tagView;
    private final TextView textView;
    private final TextView timestampView;

    public ChatListItemMessageAccessibilityDelegate(TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        Intrinsics3.checkNotNullParameter(textView, "textView");
        this.textView = textView;
        this.nameView = textView2;
        this.tagView = textView3;
        this.timestampView = textView4;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
        super.onInitializeAccessibilityNodeInfo(host, info);
        if (info == null || host == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.textView.getText());
        for (SpoilerSpan spoilerSpan : (SpoilerSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), SpoilerSpan.class)) {
            if (!spoilerSpan.l) {
                spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(spoilerSpan), spannableStringBuilder.getSpanEnd(spoilerSpan), FormatUtils.j(host, R.string.spoiler_hidden_a11y_label, new Object[0], null, 4));
            }
        }
        ArrayList arrayList = new ArrayList();
        TextView textView = this.nameView;
        if (textView != null) {
            CharSequence text = textView.getText();
            Intrinsics3.checkNotNullExpressionValue(text, "nameView.text");
            arrayList.add(text);
        }
        TextView textView2 = this.tagView;
        if (textView2 != null) {
            if (textView2.getVisibility() == 0) {
                CharSequence text2 = this.tagView.getText();
                Intrinsics3.checkNotNullExpressionValue(text2, "tagView.text");
                arrayList.add(text2);
            }
        }
        TextView textView3 = this.timestampView;
        if (textView3 != null) {
            CharSequence text3 = textView3.getText();
            Intrinsics3.checkNotNullExpressionValue(text3, "timestampView.text");
            arrayList.add(text3);
        }
        if (!arrayList.isEmpty()) {
            spannableStringBuilder.replace(0, 0, (CharSequence) outline.J(new StringBuilder(), _Collections.joinToString$default(arrayList, ", ", null, null, 0, null, null, 62, null), "\n"));
        }
        TextView textView4 = this.nameView;
        if (textView4 != null) {
            textView4.setImportantForAccessibility(4);
        }
        TextView textView5 = this.tagView;
        if (textView5 != null) {
            textView5.setImportantForAccessibility(4);
        }
        TextView textView6 = this.timestampView;
        if (textView6 != null) {
            textView6.setImportantForAccessibility(4);
        }
        this.textView.setImportantForAccessibility(4);
        info.setText(spannableStringBuilder);
        info.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        info.setMovementGranularities(15);
    }
}
