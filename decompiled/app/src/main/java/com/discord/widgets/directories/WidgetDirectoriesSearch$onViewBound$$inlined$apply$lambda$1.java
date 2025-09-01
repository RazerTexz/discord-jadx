package com.discord.widgets.directories;

import android.text.Editable;
import android.text.TextWatcher;
import androidx.core.app.NotificationCompat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TextView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J1\u0010\r\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000eJ1\u0010\u0010\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u000e¨\u0006\u0011¸\u0006\u0012"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", "s", "", "afterTextChanged", "(Landroid/text/Editable;)V", "", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "", "start", "count", "after", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "before", "onTextChanged", "core-ktx_release", "com/discord/widgets/directories/WidgetDirectoriesSearch$$special$$inlined$doOnTextChanged$1"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetDirectoriesSearch$onViewBound$$inlined$apply$lambda$1 implements TextWatcher {
    public final /* synthetic */ WidgetDirectoriesSearch this$0;

    public WidgetDirectoriesSearch$onViewBound$$inlined$apply$lambda$1(WidgetDirectoriesSearch widgetDirectoriesSearch) {
        this.this$0 = widgetDirectoriesSearch;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s2) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence text, int start, int count, int after) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence text, int start, int before, int count) {
        FloatingActionButton floatingActionButton = this.this$0.getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(floatingActionButton, "binding.search");
        WidgetDirectoriesSearchViewModel viewModel = this.this$0.getViewModel();
        if (text == null) {
            text = "";
        }
        floatingActionButton.setVisibility(viewModel.shouldNotSearch(text) ^ true ? 0 : 8);
    }
}
