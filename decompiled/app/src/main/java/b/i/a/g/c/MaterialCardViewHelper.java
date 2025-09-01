package b.i.a.g.c;

import android.R;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.CutCornerTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RoundedCornerTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;

/* compiled from: MaterialCardViewHelper.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: b.i.a.g.c.a, reason: use source file name */
/* loaded from: classes3.dex */
public class MaterialCardViewHelper {
    public static final int[] a = {R.attr.state_checked};

    /* renamed from: b, reason: collision with root package name */
    public static final double f1606b = Math.cos(Math.toRadians(45.0d));

    @NonNull
    public final MaterialCardView c;

    @NonNull
    public final MaterialShapeDrawable e;

    @NonNull
    public final MaterialShapeDrawable f;

    @Dimension
    public int g;

    @Dimension
    public int h;

    @Dimension
    public int i;

    @Nullable
    public Drawable j;

    @Nullable
    public Drawable k;

    @Nullable
    public ColorStateList l;

    @Nullable
    public ColorStateList m;

    @Nullable
    public ShapeAppearanceModel n;

    @Nullable
    public ColorStateList o;

    @Nullable
    public Drawable p;

    @Nullable
    public LayerDrawable q;

    @Nullable
    public MaterialShapeDrawable r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public MaterialShapeDrawable f1607s;
    public boolean u;

    @NonNull
    public final Rect d = new Rect();
    public boolean t = false;

    /* compiled from: MaterialCardViewHelper.java */
    /* renamed from: b.i.a.g.c.a$a */
    public class a extends InsetDrawable {
        public a(MaterialCardViewHelper materialCardViewHelper, Drawable drawable, int i, int i2, int i3, int i4) {
            super(drawable, i, i2, i3, i4);
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumHeight() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumWidth() {
            return -1;
        }

        @Override // android.graphics.drawable.InsetDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean getPadding(Rect rect) {
            return false;
        }
    }

    public MaterialCardViewHelper(@NonNull MaterialCardView materialCardView, AttributeSet attributeSet, int i, @StyleRes int i2) {
        this.c = materialCardView;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(materialCardView.getContext(), attributeSet, i, i2);
        this.e = materialShapeDrawable;
        materialShapeDrawable.initializeElevationOverlay(materialCardView.getContext());
        materialShapeDrawable.setShadowColor(-12303292);
        ShapeAppearanceModel.Builder builder = materialShapeDrawable.getShapeAppearanceModel().toBuilder();
        TypedArray typedArrayObtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, com.google.android.material.R.styleable.CardView, i, com.google.android.material.R.style.CardView);
        int i3 = com.google.android.material.R.styleable.CardView_cardCornerRadius;
        if (typedArrayObtainStyledAttributes.hasValue(i3)) {
            builder.setAllCornerSizes(typedArrayObtainStyledAttributes.getDimension(i3, 0.0f));
        }
        this.f = new MaterialShapeDrawable();
        h(builder.build());
        typedArrayObtainStyledAttributes.recycle();
    }

    public final float a() {
        return Math.max(Math.max(b(this.n.getTopLeftCorner(), this.e.getTopLeftCornerResolvedSize()), b(this.n.getTopRightCorner(), this.e.getTopRightCornerResolvedSize())), Math.max(b(this.n.getBottomRightCorner(), this.e.getBottomRightCornerResolvedSize()), b(this.n.getBottomLeftCorner(), this.e.getBottomLeftCornerResolvedSize())));
    }

    public final float b(CornerTreatment cornerTreatment, float f) {
        if (cornerTreatment instanceof RoundedCornerTreatment) {
            return (float) ((1.0d - f1606b) * f);
        }
        if (cornerTreatment instanceof CutCornerTreatment) {
            return f / 2.0f;
        }
        return 0.0f;
    }

    public final float c() {
        return this.c.getMaxCardElevation() + (j() ? a() : 0.0f);
    }

    public final float d() {
        return (this.c.getMaxCardElevation() * 1.5f) + (j() ? a() : 0.0f);
    }

    @NonNull
    public final Drawable e() {
        Drawable rippleDrawable;
        if (this.p == null) {
            if (RippleUtils.USE_FRAMEWORK_RIPPLE) {
                this.f1607s = new MaterialShapeDrawable(this.n);
                rippleDrawable = new RippleDrawable(this.l, null, this.f1607s);
            } else {
                StateListDrawable stateListDrawable = new StateListDrawable();
                MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.n);
                this.r = materialShapeDrawable;
                materialShapeDrawable.setFillColor(this.l);
                stateListDrawable.addState(new int[]{R.attr.state_pressed}, this.r);
                rippleDrawable = stateListDrawable;
            }
            this.p = rippleDrawable;
        }
        if (this.q == null) {
            StateListDrawable stateListDrawable2 = new StateListDrawable();
            Drawable drawable = this.k;
            if (drawable != null) {
                stateListDrawable2.addState(a, drawable);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.p, this.f, stateListDrawable2});
            this.q = layerDrawable;
            layerDrawable.setId(2, com.google.android.material.R.id.mtrl_card_checked_layer_id);
        }
        return this.q;
    }

    @NonNull
    public final Drawable f(Drawable drawable) {
        int iCeil;
        int i;
        if (this.c.getUseCompatPadding()) {
            int iCeil2 = (int) Math.ceil(d());
            iCeil = (int) Math.ceil(c());
            i = iCeil2;
        } else {
            iCeil = 0;
            i = 0;
        }
        return new a(this, drawable, iCeil, i, iCeil, i);
    }

    public void g(@Nullable Drawable drawable) {
        this.k = drawable;
        if (drawable != null) {
            Drawable drawableWrap = DrawableCompat.wrap(drawable.mutate());
            this.k = drawableWrap;
            DrawableCompat.setTintList(drawableWrap, this.m);
        }
        if (this.q != null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawable2 = this.k;
            if (drawable2 != null) {
                stateListDrawable.addState(a, drawable2);
            }
            this.q.setDrawableByLayerId(com.google.android.material.R.id.mtrl_card_checked_layer_id, stateListDrawable);
        }
    }

    public void h(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.n = shapeAppearanceModel;
        this.e.setShapeAppearanceModel(shapeAppearanceModel);
        this.e.setShadowBitmapDrawingEnable(!r0.isRoundRect());
        MaterialShapeDrawable materialShapeDrawable = this.f;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
        MaterialShapeDrawable materialShapeDrawable2 = this.f1607s;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.setShapeAppearanceModel(shapeAppearanceModel);
        }
        MaterialShapeDrawable materialShapeDrawable3 = this.r;
        if (materialShapeDrawable3 != null) {
            materialShapeDrawable3.setShapeAppearanceModel(shapeAppearanceModel);
        }
    }

    public final boolean i() {
        return this.c.getPreventCornerOverlap() && !this.e.isRoundRect();
    }

    public final boolean j() {
        return this.c.getPreventCornerOverlap() && this.e.isRoundRect() && this.c.getUseCompatPadding();
    }

    public void k() {
        float cardViewRadius = 0.0f;
        float fA = i() || j() ? a() : 0.0f;
        if (this.c.getPreventCornerOverlap() && this.c.getUseCompatPadding()) {
            cardViewRadius = (float) ((1.0d - f1606b) * this.c.getCardViewRadius());
        }
        int i = (int) (fA - cardViewRadius);
        MaterialCardView materialCardView = this.c;
        Rect rect = this.d;
        materialCardView.setAncestorContentPadding(rect.left + i, rect.top + i, rect.right + i, rect.bottom + i);
    }

    public void l() {
        if (!this.t) {
            this.c.setBackgroundInternal(f(this.e));
        }
        this.c.setForeground(f(this.j));
    }

    public final void m() {
        Drawable drawable;
        if (RippleUtils.USE_FRAMEWORK_RIPPLE && (drawable = this.p) != null) {
            ((RippleDrawable) drawable).setColor(this.l);
            return;
        }
        MaterialShapeDrawable materialShapeDrawable = this.r;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setFillColor(this.l);
        }
    }

    public void n() {
        this.f.setStroke(this.i, this.o);
    }
}
