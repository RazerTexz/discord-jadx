package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.PluralsRes;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.StyleableRes;
import androidx.annotation.XmlRes;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes3.dex */
public class BadgeDrawable extends Drawable implements TextDrawableHelper.TextDrawableDelegate {
    private static final int BADGE_NUMBER_NONE = -1;
    public static final int BOTTOM_END = 8388693;
    public static final int BOTTOM_START = 8388691;
    public static final String DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX = "+";
    private static final int DEFAULT_MAX_BADGE_CHARACTER_COUNT = 4;

    @StyleRes
    private static final int DEFAULT_STYLE = R.style.Widget_MaterialComponents_Badge;

    @AttrRes
    private static final int DEFAULT_THEME_ATTR = R.attr.badgeStyle;
    private static final int MAX_CIRCULAR_BADGE_NUMBER_COUNT = 9;
    public static final int TOP_END = 8388661;
    public static final int TOP_START = 8388659;

    @Nullable
    private WeakReference<View> anchorViewRef;

    @NonNull
    private final Rect badgeBounds;
    private float badgeCenterX;
    private float badgeCenterY;
    private final float badgeRadius;
    private final float badgeWidePadding;
    private final float badgeWithTextRadius;

    @NonNull
    private final WeakReference<Context> contextRef;
    private float cornerRadius;

    @Nullable
    private WeakReference<FrameLayout> customBadgeParentRef;
    private float halfBadgeHeight;
    private float halfBadgeWidth;
    private int maxBadgeNumber;

    @NonNull
    private final SavedState savedState;

    @NonNull
    private final MaterialShapeDrawable shapeDrawable;

    @NonNull
    private final TextDrawableHelper textDrawableHelper;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BadgeGravity {
    }

    public class a implements Runnable {
        public final /* synthetic */ View j;
        public final /* synthetic */ FrameLayout k;

        public a(View view, FrameLayout frameLayout) {
            this.j = view;
            this.k = frameLayout;
        }

        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            BadgeDrawable.this.updateBadgeCoordinates(this.j, this.k);
        }
    }

    private BadgeDrawable(@NonNull Context context) throws Resources.NotFoundException {
        this.contextRef = new WeakReference<>(context);
        ThemeEnforcement.checkMaterialTheme(context);
        Resources resources = context.getResources();
        this.badgeBounds = new Rect();
        this.shapeDrawable = new MaterialShapeDrawable();
        this.badgeRadius = resources.getDimensionPixelSize(R.dimen.mtrl_badge_radius);
        this.badgeWidePadding = resources.getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding);
        this.badgeWithTextRadius = resources.getDimensionPixelSize(R.dimen.mtrl_badge_with_text_radius);
        TextDrawableHelper textDrawableHelper = new TextDrawableHelper(this);
        this.textDrawableHelper = textDrawableHelper;
        textDrawableHelper.getTextPaint().setTextAlign(Paint.Align.CENTER);
        this.savedState = new SavedState(context);
        setTextAppearanceResource(R.style.TextAppearance_MaterialComponents_Badge);
    }

    private void calculateCenterAndBounds(@NonNull Context context, @NonNull Rect rect, @NonNull View view) throws Resources.NotFoundException {
        int iAccess$500 = SavedState.access$500(this.savedState);
        if (iAccess$500 == 8388691 || iAccess$500 == 8388693) {
            this.badgeCenterY = rect.bottom - SavedState.access$700(this.savedState);
        } else {
            this.badgeCenterY = SavedState.access$700(this.savedState) + rect.top;
        }
        if (getNumber() <= 9) {
            float f = !hasNumber() ? this.badgeRadius : this.badgeWithTextRadius;
            this.cornerRadius = f;
            this.halfBadgeHeight = f;
            this.halfBadgeWidth = f;
        } else {
            float f2 = this.badgeWithTextRadius;
            this.cornerRadius = f2;
            this.halfBadgeHeight = f2;
            this.halfBadgeWidth = (this.textDrawableHelper.getTextWidth(getBadgeText()) / 2.0f) + this.badgeWidePadding;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(hasNumber() ? R.dimen.mtrl_badge_text_horizontal_edge_offset : R.dimen.mtrl_badge_horizontal_edge_offset);
        int iAccess$5002 = SavedState.access$500(this.savedState);
        if (iAccess$5002 == 8388659 || iAccess$5002 == 8388691) {
            this.badgeCenterX = ViewCompat.getLayoutDirection(view) == 0 ? (rect.left - this.halfBadgeWidth) + dimensionPixelSize + SavedState.access$600(this.savedState) : ((rect.right + this.halfBadgeWidth) - dimensionPixelSize) - SavedState.access$600(this.savedState);
        } else {
            this.badgeCenterX = ViewCompat.getLayoutDirection(view) == 0 ? ((rect.right + this.halfBadgeWidth) - dimensionPixelSize) - SavedState.access$600(this.savedState) : (rect.left - this.halfBadgeWidth) + dimensionPixelSize + SavedState.access$600(this.savedState);
        }
    }

    @NonNull
    public static BadgeDrawable create(@NonNull Context context) {
        return createFromAttributes(context, null, DEFAULT_THEME_ATTR, DEFAULT_STYLE);
    }

    @NonNull
    private static BadgeDrawable createFromAttributes(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2) throws Resources.NotFoundException {
        BadgeDrawable badgeDrawable = new BadgeDrawable(context);
        badgeDrawable.loadDefaultStateFromAttributes(context, attributeSet, i, i2);
        return badgeDrawable;
    }

    @NonNull
    public static BadgeDrawable createFromResource(@NonNull Context context, @XmlRes int i) throws XmlPullParserException, Resources.NotFoundException, IOException {
        AttributeSet drawableXml = DrawableUtils.parseDrawableXml(context, i, "badge");
        int styleAttribute = drawableXml.getStyleAttribute();
        if (styleAttribute == 0) {
            styleAttribute = DEFAULT_STYLE;
        }
        return createFromAttributes(context, drawableXml, DEFAULT_THEME_ATTR, styleAttribute);
    }

    @NonNull
    public static BadgeDrawable createFromSavedState(@NonNull Context context, @NonNull SavedState savedState) throws Resources.NotFoundException {
        BadgeDrawable badgeDrawable = new BadgeDrawable(context);
        badgeDrawable.restoreFromSavedState(savedState);
        return badgeDrawable;
    }

    private void drawText(Canvas canvas) {
        Rect rect = new Rect();
        String badgeText = getBadgeText();
        this.textDrawableHelper.getTextPaint().getTextBounds(badgeText, 0, badgeText.length(), rect);
        canvas.drawText(badgeText, this.badgeCenterX, this.badgeCenterY + (rect.height() / 2), this.textDrawableHelper.getTextPaint());
    }

    @NonNull
    private String getBadgeText() {
        if (getNumber() <= this.maxBadgeNumber) {
            return NumberFormat.getInstance().format(getNumber());
        }
        Context context = this.contextRef.get();
        return context == null ? "" : context.getString(R.string.mtrl_exceed_max_badge_number_suffix, Integer.valueOf(this.maxBadgeNumber), DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
    }

    private void loadDefaultStateFromAttributes(Context context, AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R.styleable.Badge, i, i2, new int[0]);
        setMaxCharacterCount(typedArrayObtainStyledAttributes.getInt(R.styleable.Badge_maxCharacterCount, 4));
        int i3 = R.styleable.Badge_number;
        if (typedArrayObtainStyledAttributes.hasValue(i3)) {
            setNumber(typedArrayObtainStyledAttributes.getInt(i3, 0));
        }
        setBackgroundColor(readColorFromAttributes(context, typedArrayObtainStyledAttributes, R.styleable.Badge_backgroundColor));
        int i4 = R.styleable.Badge_badgeTextColor;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            setBadgeTextColor(readColorFromAttributes(context, typedArrayObtainStyledAttributes, i4));
        }
        setBadgeGravity(typedArrayObtainStyledAttributes.getInt(R.styleable.Badge_badgeGravity, TOP_END));
        setHorizontalOffset(typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.Badge_horizontalOffset, 0));
        setVerticalOffset(typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.Badge_verticalOffset, 0));
        typedArrayObtainStyledAttributes.recycle();
    }

    private static int readColorFromAttributes(Context context, @NonNull TypedArray typedArray, @StyleableRes int i) {
        return MaterialResources.getColorStateList(context, typedArray, i).getDefaultColor();
    }

    private void restoreFromSavedState(@NonNull SavedState savedState) throws Resources.NotFoundException {
        setMaxCharacterCount(SavedState.access$100(savedState));
        if (SavedState.access$200(savedState) != -1) {
            setNumber(SavedState.access$200(savedState));
        }
        setBackgroundColor(SavedState.access$300(savedState));
        setBadgeTextColor(SavedState.access$400(savedState));
        setBadgeGravity(SavedState.access$500(savedState));
        setHorizontalOffset(SavedState.access$600(savedState));
        setVerticalOffset(SavedState.access$700(savedState));
        setVisible(SavedState.access$000(savedState));
    }

    private void setTextAppearance(@Nullable TextAppearance textAppearance) throws Resources.NotFoundException {
        Context context;
        if (this.textDrawableHelper.getTextAppearance() == textAppearance || (context = this.contextRef.get()) == null) {
            return;
        }
        this.textDrawableHelper.setTextAppearance(textAppearance, context);
        updateCenterAndBounds();
    }

    private void setTextAppearanceResource(@StyleRes int i) throws Resources.NotFoundException {
        Context context = this.contextRef.get();
        if (context == null) {
            return;
        }
        setTextAppearance(new TextAppearance(context, i));
    }

    private void tryWrapAnchorInCompatParent(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup == null || viewGroup.getId() != R.id.mtrl_anchor_parent) {
            WeakReference<FrameLayout> weakReference = this.customBadgeParentRef;
            if (weakReference == null || weakReference.get() != viewGroup) {
                updateAnchorParentToNotClip(view);
                FrameLayout frameLayout = new FrameLayout(view.getContext());
                frameLayout.setId(R.id.mtrl_anchor_parent);
                frameLayout.setClipChildren(false);
                frameLayout.setClipToPadding(false);
                frameLayout.setLayoutParams(view.getLayoutParams());
                frameLayout.setMinimumWidth(view.getWidth());
                frameLayout.setMinimumHeight(view.getHeight());
                int iIndexOfChild = viewGroup.indexOfChild(view);
                viewGroup.removeViewAt(iIndexOfChild);
                view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                frameLayout.addView(view);
                viewGroup.addView(frameLayout, iIndexOfChild);
                this.customBadgeParentRef = new WeakReference<>(frameLayout);
                frameLayout.post(new a(view, frameLayout));
            }
        }
    }

    private static void updateAnchorParentToNotClip(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
    }

    private void updateCenterAndBounds() throws Resources.NotFoundException {
        Context context = this.contextRef.get();
        WeakReference<View> weakReference = this.anchorViewRef;
        View view = weakReference != null ? weakReference.get() : null;
        if (context == null || view == null) {
            return;
        }
        Rect rect = new Rect();
        rect.set(this.badgeBounds);
        Rect rect2 = new Rect();
        view.getDrawingRect(rect2);
        WeakReference<FrameLayout> weakReference2 = this.customBadgeParentRef;
        FrameLayout frameLayout = weakReference2 != null ? weakReference2.get() : null;
        if (frameLayout != null || BadgeUtils.USE_COMPAT_PARENT) {
            if (frameLayout == null) {
                frameLayout = (ViewGroup) view.getParent();
            }
            frameLayout.offsetDescendantRectToMyCoords(view, rect2);
        }
        calculateCenterAndBounds(context, rect2, view);
        BadgeUtils.updateBadgeBounds(this.badgeBounds, this.badgeCenterX, this.badgeCenterY, this.halfBadgeWidth, this.halfBadgeHeight);
        this.shapeDrawable.setCornerSize(this.cornerRadius);
        if (rect.equals(this.badgeBounds)) {
            return;
        }
        this.shapeDrawable.setBounds(this.badgeBounds);
    }

    private void updateMaxBadgeNumber() {
        this.maxBadgeNumber = ((int) Math.pow(10.0d, getMaxCharacterCount() - 1.0d)) - 1;
    }

    public void clearNumber() {
        SavedState.access$202(this.savedState, -1);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (getBounds().isEmpty() || getAlpha() == 0 || !isVisible()) {
            return;
        }
        this.shapeDrawable.draw(canvas);
        if (hasNumber()) {
            drawText(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return SavedState.access$800(this.savedState);
    }

    @ColorInt
    public int getBackgroundColor() {
        return this.shapeDrawable.getFillColor().getDefaultColor();
    }

    public int getBadgeGravity() {
        return SavedState.access$500(this.savedState);
    }

    @ColorInt
    public int getBadgeTextColor() {
        return this.textDrawableHelper.getTextPaint().getColor();
    }

    @Nullable
    public CharSequence getContentDescription() {
        Context context;
        if (!isVisible()) {
            return null;
        }
        if (!hasNumber()) {
            return SavedState.access$900(this.savedState);
        }
        if (SavedState.access$1000(this.savedState) <= 0 || (context = this.contextRef.get()) == null) {
            return null;
        }
        return getNumber() <= this.maxBadgeNumber ? context.getResources().getQuantityString(SavedState.access$1000(this.savedState), getNumber(), Integer.valueOf(getNumber())) : context.getString(SavedState.access$1100(this.savedState), Integer.valueOf(this.maxBadgeNumber));
    }

    @Nullable
    public FrameLayout getCustomBadgeParent() {
        WeakReference<FrameLayout> weakReference = this.customBadgeParentRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int getHorizontalOffset() {
        return SavedState.access$600(this.savedState);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.badgeBounds.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.badgeBounds.width();
    }

    public int getMaxCharacterCount() {
        return SavedState.access$100(this.savedState);
    }

    public int getNumber() {
        if (hasNumber()) {
            return SavedState.access$200(this.savedState);
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @NonNull
    public SavedState getSavedState() {
        return this.savedState;
    }

    public int getVerticalOffset() {
        return SavedState.access$700(this.savedState);
    }

    public boolean hasNumber() {
        return SavedState.access$200(this.savedState) != -1;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onTextSizeChange() {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        SavedState.access$802(this.savedState, i);
        this.textDrawableHelper.getTextPaint().setAlpha(i);
        invalidateSelf();
    }

    public void setBackgroundColor(@ColorInt int i) {
        SavedState.access$302(this.savedState, i);
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i);
        if (this.shapeDrawable.getFillColor() != colorStateListValueOf) {
            this.shapeDrawable.setFillColor(colorStateListValueOf);
            invalidateSelf();
        }
    }

    public void setBadgeGravity(int i) throws Resources.NotFoundException {
        if (SavedState.access$500(this.savedState) != i) {
            SavedState.access$502(this.savedState, i);
            WeakReference<View> weakReference = this.anchorViewRef;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            View view = this.anchorViewRef.get();
            WeakReference<FrameLayout> weakReference2 = this.customBadgeParentRef;
            updateBadgeCoordinates(view, weakReference2 != null ? weakReference2.get() : null);
        }
    }

    public void setBadgeTextColor(@ColorInt int i) {
        SavedState.access$402(this.savedState, i);
        if (this.textDrawableHelper.getTextPaint().getColor() != i) {
            this.textDrawableHelper.getTextPaint().setColor(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void setContentDescriptionExceedsMaxBadgeNumberStringResource(@StringRes int i) {
        SavedState.access$1102(this.savedState, i);
    }

    public void setContentDescriptionNumberless(CharSequence charSequence) {
        SavedState.access$902(this.savedState, charSequence);
    }

    public void setContentDescriptionQuantityStringsResource(@PluralsRes int i) {
        SavedState.access$1002(this.savedState, i);
    }

    public void setHorizontalOffset(int i) throws Resources.NotFoundException {
        SavedState.access$602(this.savedState, i);
        updateCenterAndBounds();
    }

    public void setMaxCharacterCount(int i) throws Resources.NotFoundException {
        if (SavedState.access$100(this.savedState) != i) {
            SavedState.access$102(this.savedState, i);
            updateMaxBadgeNumber();
            this.textDrawableHelper.setTextWidthDirty(true);
            updateCenterAndBounds();
            invalidateSelf();
        }
    }

    public void setNumber(int i) throws Resources.NotFoundException {
        int iMax = Math.max(0, i);
        if (SavedState.access$200(this.savedState) != iMax) {
            SavedState.access$202(this.savedState, iMax);
            this.textDrawableHelper.setTextWidthDirty(true);
            updateCenterAndBounds();
            invalidateSelf();
        }
    }

    public void setVerticalOffset(int i) throws Resources.NotFoundException {
        SavedState.access$702(this.savedState, i);
        updateCenterAndBounds();
    }

    public void setVisible(boolean z2) {
        setVisible(z2, false);
        SavedState.access$002(this.savedState, z2);
        if (!BadgeUtils.USE_COMPAT_PARENT || getCustomBadgeParent() == null || z2) {
            return;
        }
        ((ViewGroup) getCustomBadgeParent().getParent()).invalidate();
    }

    @Deprecated
    public void updateBadgeCoordinates(@NonNull View view, @Nullable ViewGroup viewGroup) throws Resources.NotFoundException {
        if (!(viewGroup instanceof FrameLayout)) {
            throw new IllegalArgumentException("customBadgeParent must be a FrameLayout");
        }
        updateBadgeCoordinates(view, (FrameLayout) viewGroup);
    }

    public void updateBadgeCoordinates(@NonNull View view) throws Resources.NotFoundException {
        updateBadgeCoordinates(view, (FrameLayout) null);
    }

    public void updateBadgeCoordinates(@NonNull View view, @Nullable FrameLayout frameLayout) throws Resources.NotFoundException {
        this.anchorViewRef = new WeakReference<>(view);
        boolean z2 = BadgeUtils.USE_COMPAT_PARENT;
        if (z2 && frameLayout == null) {
            tryWrapAnchorInCompatParent(view);
        } else {
            this.customBadgeParentRef = new WeakReference<>(frameLayout);
        }
        if (!z2) {
            updateAnchorParentToNotClip(view);
        }
        updateCenterAndBounds();
        invalidateSelf();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        private int alpha;

        @ColorInt
        private int backgroundColor;
        private int badgeGravity;

        @ColorInt
        private int badgeTextColor;

        @StringRes
        private int contentDescriptionExceedsMaxBadgeNumberRes;

        @Nullable
        private CharSequence contentDescriptionNumberless;

        @PluralsRes
        private int contentDescriptionQuantityStrings;

        @Dimension(unit = 1)
        private int horizontalOffset;
        private boolean isVisible;
        private int maxCharacterCount;
        private int number;

        @Dimension(unit = 1)
        private int verticalOffset;

        public static class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            @NonNull
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(@NonNull Context context) {
            this.alpha = 255;
            this.number = -1;
            this.badgeTextColor = new TextAppearance(context, R.style.TextAppearance_MaterialComponents_Badge).textColor.getDefaultColor();
            this.contentDescriptionNumberless = context.getString(R.string.mtrl_badge_numberless_content_description);
            this.contentDescriptionQuantityStrings = R.plurals.mtrl_badge_content_description;
            this.contentDescriptionExceedsMaxBadgeNumberRes = R.string.mtrl_exceed_max_badge_number_content_description;
            this.isVisible = true;
        }

        public static /* synthetic */ boolean access$000(SavedState savedState) {
            return savedState.isVisible;
        }

        public static /* synthetic */ boolean access$002(SavedState savedState, boolean z2) {
            savedState.isVisible = z2;
            return z2;
        }

        public static /* synthetic */ int access$100(SavedState savedState) {
            return savedState.maxCharacterCount;
        }

        public static /* synthetic */ int access$1000(SavedState savedState) {
            return savedState.contentDescriptionQuantityStrings;
        }

        public static /* synthetic */ int access$1002(SavedState savedState, int i) {
            savedState.contentDescriptionQuantityStrings = i;
            return i;
        }

        public static /* synthetic */ int access$102(SavedState savedState, int i) {
            savedState.maxCharacterCount = i;
            return i;
        }

        public static /* synthetic */ int access$1100(SavedState savedState) {
            return savedState.contentDescriptionExceedsMaxBadgeNumberRes;
        }

        public static /* synthetic */ int access$1102(SavedState savedState, int i) {
            savedState.contentDescriptionExceedsMaxBadgeNumberRes = i;
            return i;
        }

        public static /* synthetic */ int access$200(SavedState savedState) {
            return savedState.number;
        }

        public static /* synthetic */ int access$202(SavedState savedState, int i) {
            savedState.number = i;
            return i;
        }

        public static /* synthetic */ int access$300(SavedState savedState) {
            return savedState.backgroundColor;
        }

        public static /* synthetic */ int access$302(SavedState savedState, int i) {
            savedState.backgroundColor = i;
            return i;
        }

        public static /* synthetic */ int access$400(SavedState savedState) {
            return savedState.badgeTextColor;
        }

        public static /* synthetic */ int access$402(SavedState savedState, int i) {
            savedState.badgeTextColor = i;
            return i;
        }

        public static /* synthetic */ int access$500(SavedState savedState) {
            return savedState.badgeGravity;
        }

        public static /* synthetic */ int access$502(SavedState savedState, int i) {
            savedState.badgeGravity = i;
            return i;
        }

        public static /* synthetic */ int access$600(SavedState savedState) {
            return savedState.horizontalOffset;
        }

        public static /* synthetic */ int access$602(SavedState savedState, int i) {
            savedState.horizontalOffset = i;
            return i;
        }

        public static /* synthetic */ int access$700(SavedState savedState) {
            return savedState.verticalOffset;
        }

        public static /* synthetic */ int access$702(SavedState savedState, int i) {
            savedState.verticalOffset = i;
            return i;
        }

        public static /* synthetic */ int access$800(SavedState savedState) {
            return savedState.alpha;
        }

        public static /* synthetic */ int access$802(SavedState savedState, int i) {
            savedState.alpha = i;
            return i;
        }

        public static /* synthetic */ CharSequence access$900(SavedState savedState) {
            return savedState.contentDescriptionNumberless;
        }

        public static /* synthetic */ CharSequence access$902(SavedState savedState, CharSequence charSequence) {
            savedState.contentDescriptionNumberless = charSequence;
            return charSequence;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            parcel.writeInt(this.backgroundColor);
            parcel.writeInt(this.badgeTextColor);
            parcel.writeInt(this.alpha);
            parcel.writeInt(this.number);
            parcel.writeInt(this.maxCharacterCount);
            parcel.writeString(this.contentDescriptionNumberless.toString());
            parcel.writeInt(this.contentDescriptionQuantityStrings);
            parcel.writeInt(this.badgeGravity);
            parcel.writeInt(this.horizontalOffset);
            parcel.writeInt(this.verticalOffset);
            parcel.writeInt(this.isVisible ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel) {
            this.alpha = 255;
            this.number = -1;
            this.backgroundColor = parcel.readInt();
            this.badgeTextColor = parcel.readInt();
            this.alpha = parcel.readInt();
            this.number = parcel.readInt();
            this.maxCharacterCount = parcel.readInt();
            this.contentDescriptionNumberless = parcel.readString();
            this.contentDescriptionQuantityStrings = parcel.readInt();
            this.badgeGravity = parcel.readInt();
            this.horizontalOffset = parcel.readInt();
            this.verticalOffset = parcel.readInt();
            this.isVisible = parcel.readInt() != 0;
        }
    }
}
