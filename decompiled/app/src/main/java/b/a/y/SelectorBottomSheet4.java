package b.a.y;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import b.a.i.BottomSheetSimpleSelectorItemBinding;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textview.MaterialTextView;
import d0.z.d.Intrinsics3;

/* compiled from: SelectorBottomSheet.kt */
/* renamed from: b.a.y.e0, reason: use source file name */
/* loaded from: classes2.dex */
public final class SelectorBottomSheet4 extends SimpleRecyclerAdapter.ViewHolder<SelectorBottomSheet2> {
    public final SelectorBottomSheet5 a;

    /* renamed from: b, reason: collision with root package name */
    public final DialogInterface f310b;
    public final BottomSheetSimpleSelectorItemBinding c;

    /* JADX WARN: Illegal instructions before constructor call */
    public SelectorBottomSheet4(SelectorBottomSheet5 selectorBottomSheet5, DialogInterface dialogInterface, BottomSheetSimpleSelectorItemBinding bottomSheetSimpleSelectorItemBinding) {
        Intrinsics3.checkNotNullParameter(selectorBottomSheet5, "onSelectedListener");
        Intrinsics3.checkNotNullParameter(dialogInterface, "dialogInterface");
        Intrinsics3.checkNotNullParameter(bottomSheetSimpleSelectorItemBinding, "itemBinding");
        ConstraintLayout constraintLayout = bottomSheetSimpleSelectorItemBinding.a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "itemBinding.root");
        super(constraintLayout);
        this.a = selectorBottomSheet5;
        this.f310b = dialogInterface;
        this.c = bottomSheetSimpleSelectorItemBinding;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
    @Override // com.discord.utilities.views.SimpleRecyclerAdapter.ViewHolder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void bind(SelectorBottomSheet2 selectorBottomSheet2) {
        int themedColor;
        Drawable drawable;
        SelectorBottomSheet2 selectorBottomSheet22 = selectorBottomSheet2;
        Intrinsics3.checkNotNullParameter(selectorBottomSheet22, "data");
        MaterialTextView materialTextView = this.c.d;
        Intrinsics3.checkNotNullExpressionValue(materialTextView, "itemBinding.selectComponentSheetItemTitle");
        FormatUtils.a(materialTextView, selectorBottomSheet22.e());
        MaterialTextView materialTextView2 = this.c.f95b;
        Intrinsics3.checkNotNullExpressionValue(materialTextView2, "itemBinding.selectComponentSheetItemDescription");
        ViewExtensions.setTextAndVisibilityBy(materialTextView2, selectorBottomSheet22.a());
        SimpleDraweeView simpleDraweeView = this.c.c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "itemBinding.selectComponentSheetItemIcon");
        simpleDraweeView.setVisibility(selectorBottomSheet22.d() != null || selectorBottomSheet22.b() != null ? 0 : 8);
        String strD = selectorBottomSheet22.d();
        if (strD != null) {
            SimpleDraweeView simpleDraweeView2 = this.c.c;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "itemBinding.selectComponentSheetItemIcon");
            MGImages.setImage$default(simpleDraweeView2, strD, R.dimen.emoji_size, R.dimen.emoji_size, true, null, null, 96, null);
        } else {
            Integer numB = selectorBottomSheet22.b();
            if (numB != null) {
                this.c.c.setImageResource(numB.intValue());
            }
        }
        Integer numC = selectorBottomSheet22.c();
        if (numC != null) {
            this.c.c.setColorFilter(numC.intValue());
        }
        MaterialTextView materialTextView3 = this.c.d;
        materialTextView3.setText(selectorBottomSheet22.e());
        Integer numG = selectorBottomSheet22.g();
        if (numG != null) {
            themedColor = numG.intValue();
        } else {
            Intrinsics3.checkNotNullExpressionValue(materialTextView3, "this");
            themedColor = ColorCompat.getThemedColor(materialTextView3, R.attr.colorHeaderPrimary);
        }
        materialTextView3.setTextColor(themedColor);
        Integer numF = selectorBottomSheet22.f();
        if (numF != null) {
            numF.intValue();
            Drawable drawable2 = ContextCompat.getDrawable(materialTextView3.getContext(), selectorBottomSheet22.f().intValue());
            if (drawable2 != null) {
                MaterialTextView materialTextView4 = this.c.d;
                Intrinsics3.checkNotNullExpressionValue(materialTextView4, "itemBinding.selectComponentSheetItemTitle");
                DrawableCompat.setTint(drawable2, ColorCompat.getThemedColor(materialTextView4, R.attr.colorHeaderPrimary));
                drawable = drawable2;
            } else {
                drawable = null;
            }
        }
        com.discord.utilities.drawable.DrawableCompat.setCompoundDrawablesCompat$default(materialTextView3, (Drawable) null, (Drawable) null, drawable, (Drawable) null, 11, (Object) null);
        this.c.a.setOnClickListener(new SelectorBottomSheet3(this));
    }
}
