package com.discord.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import b.a.i.SearchInputViewBinding;
import com.discord.R;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.view.text.TextWatcher;
import com.google.android.material.textfield.TextInputEditText;
import d0.z.d.Intrinsics3;
import defpackage.p;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.functions.Action1;

/* compiled from: SearchInputView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\u0006\u0010%\u001a\u00020$\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&¢\u0006\u0004\b(\u0010)J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\u0006R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R(\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006*"}, d2 = {"Lcom/discord/views/SearchInputView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "searchQuery", "", "setText", "(Ljava/lang/String;)V", "", "hint", "setHint", "(Ljava/lang/CharSequence;)V", "Landroid/view/View;", "getEditText", "()Landroid/view/View;", "Landroidx/fragment/app/Fragment;", "fragment", "Lkotlin/Function1;", "onAfterTextChanged", "a", "(Landroidx/fragment/app/Fragment;Lkotlin/jvm/functions/Function1;)V", "b", "Lb/a/i/j1;", "k", "Lb/a/i/j1;", "binding", "Lkotlin/Function0;", "m", "Lkotlin/jvm/functions/Function0;", "getOnClearClicked", "()Lkotlin/jvm/functions/Function0;", "setOnClearClicked", "(Lkotlin/jvm/functions/Function0;)V", "onClearClicked", "l", "Ljava/lang/String;", "searchIconContentDescription", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SearchInputView extends ConstraintLayout {
    public static final /* synthetic */ int j = 0;

    /* renamed from: k, reason: from kotlin metadata */
    public final SearchInputViewBinding binding;

    /* renamed from: l, reason: from kotlin metadata */
    public String searchIconContentDescription;

    /* renamed from: m, reason: from kotlin metadata */
    public Function0<Unit> onClearClicked;

    /* compiled from: SearchInputView.kt */
    public static final class a<T> implements Action1<String> {
        public final /* synthetic */ Function1 k;

        public a(Function1 function1) {
            this.k = function1;
        }

        @Override // rx.functions.Action1
        public void call(String str) {
            String str2 = str;
            Function1 function1 = this.k;
            Intrinsics3.checkNotNullExpressionValue(str2, "searchQuery");
            function1.invoke(str2);
            SearchInputView searchInputView = SearchInputView.this;
            int i = SearchInputView.j;
            searchInputView.b(str2);
        }
    }

    /* compiled from: SearchInputView.kt */
    public static final class b implements View.OnClickListener {
        public final /* synthetic */ String k;

        public b(boolean z2, String str) {
            this.k = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.k.length() > 0) {
                SearchInputView.this.getOnClearClicked().invoke();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchInputView(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.search_input_view, this);
        int i = R.id.search_clear;
        ImageView imageView = (ImageView) findViewById(R.id.search_clear);
        if (imageView != null) {
            i = R.id.search_input_edit_text;
            TextInputEditText textInputEditText = (TextInputEditText) findViewById(R.id.search_input_edit_text);
            if (textInputEditText != null) {
                SearchInputViewBinding searchInputViewBinding = new SearchInputViewBinding(this, imageView, textInputEditText);
                Intrinsics3.checkNotNullExpressionValue(searchInputViewBinding, "SearchInputViewBinding.i…ater.from(context), this)");
                this.binding = searchInputViewBinding;
                this.searchIconContentDescription = "";
                this.onClearClicked = new p(1, this);
                Drawable drawable = null;
                Drawable drawable2 = ResourcesCompat.getDrawable(getResources(), R.drawable.drawable_bg_corners_4dp, null);
                if (drawable2 != null) {
                    drawable2.setTint(ColorCompat.getThemedColor(this, R.attr.colorBackgroundTertiary));
                    drawable = drawable2;
                }
                setBackground(drawable);
                TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.a.SearchInputView);
                Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…tyleable.SearchInputView)");
                String string = typedArrayObtainStyledAttributes.getString(0);
                String string2 = typedArrayObtainStyledAttributes.getString(1);
                this.searchIconContentDescription = string2 == null ? "" : string2;
                typedArrayObtainStyledAttributes.recycle();
                Intrinsics3.checkNotNullExpressionValue(textInputEditText, "searchInputEditText");
                textInputEditText.setHint(string);
                setText("");
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    public final void a(Fragment fragment, Function1<? super String, Unit> onAfterTextChanged) {
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        Intrinsics3.checkNotNullParameter(onAfterTextChanged, "onAfterTextChanged");
        TextWatcher.Companion companion = TextWatcher.INSTANCE;
        TextInputEditText textInputEditText = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.searchInputEditText");
        companion.addBindedTextWatcher(fragment, textInputEditText, new a(onAfterTextChanged));
    }

    public final void b(String searchQuery) {
        boolean z2 = searchQuery.length() == 0;
        SearchInputViewBinding searchInputViewBinding = this.binding;
        searchInputViewBinding.f139b.setImageResource(z2 ? R.drawable.ic_search_16dp : R.drawable.ic_clear_white_24dp);
        ImageView imageView = searchInputViewBinding.f139b;
        Intrinsics3.checkNotNullExpressionValue(imageView, "searchClear");
        imageView.setImageTintList(z2 ? ColorStateList.valueOf(ColorCompat.getThemedColor(getContext(), R.attr.colorTextMuted)) : ColorStateList.valueOf(ColorCompat.getThemedColor(getContext(), R.attr.colorTextNormal)));
        ImageView imageView2 = searchInputViewBinding.f139b;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "searchClear");
        imageView2.setContentDescription(z2 ? this.searchIconContentDescription : getContext().getString(R.string.reset));
        ImageView imageView3 = searchInputViewBinding.f139b;
        Intrinsics3.checkNotNullExpressionValue(imageView3, "searchClear");
        imageView3.setImportantForAccessibility(z2 ? 2 : 0);
        searchInputViewBinding.f139b.setOnClickListener(new b(z2, searchQuery));
    }

    public final View getEditText() {
        TextInputEditText textInputEditText = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.searchInputEditText");
        return textInputEditText;
    }

    public final Function0<Unit> getOnClearClicked() {
        return this.onClearClicked;
    }

    public final void setHint(CharSequence hint) {
        Intrinsics3.checkNotNullParameter(hint, "hint");
        TextInputEditText textInputEditText = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.searchInputEditText");
        textInputEditText.setHint(hint);
    }

    public final void setOnClearClicked(Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function0, "<set-?>");
        this.onClearClicked = function0;
    }

    public final void setText(String searchQuery) {
        Intrinsics3.checkNotNullParameter(searchQuery, "searchQuery");
        this.binding.c.setText(searchQuery);
        b(searchQuery);
    }
}
