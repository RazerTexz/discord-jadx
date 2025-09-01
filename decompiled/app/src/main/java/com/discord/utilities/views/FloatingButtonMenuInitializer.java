package com.discord.utilities.views;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import android.widget.TableRow;
import androidx.exifinterface.media.ExifInterface;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: FloatingButtonMenuInitializer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0014\u0018\u00002\u00020\u0001:\u0001,B#\u0012\u0006\u0010!\u001a\u00020 \u0012\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00180%¢\u0006\u0004\b*\u0010+J\u001f\u0010\u0005\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ7\u0010\u0012\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00072\u001e\u0010\u0011\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00070\u00100\u0002\"\b\u0012\u0004\u0012\u00020\u00070\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ%\u0010\u001e\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u0018¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\"\u0010'\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00180%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020\t0\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010$¨\u0006-"}, d2 = {"Lcom/discord/utilities/views/FloatingButtonMenuInitializer;", "", "", "Landroid/animation/Animator;", "menuRowAnimators", "configureEntranceAnimator", "([Landroid/animation/Animator;)Landroid/animation/Animator;", "Landroid/view/ViewGroup;", "menuContainer", "Landroid/view/View;", "mainFab", "getMenuAnimators", "(Landroid/view/ViewGroup;Landroid/view/View;)[Landroid/animation/Animator;", "row", "createDefaultMenuRowAnimation", "(Landroid/view/ViewGroup;Landroid/view/View;)Landroid/animation/Animator;", "Lcom/discord/utilities/views/FloatingButtonMenuInitializer$AnimatorFactory;", "factories", "createMenuRowAnimation", "(Landroid/view/ViewGroup;[Lcom/discord/utilities/views/FloatingButtonMenuInitializer$AnimatorFactory;)Landroid/animation/Animator;", "com/discord/utilities/views/FloatingButtonMenuInitializer$getAnimatorFactoryScaleUp$1", "getAnimatorFactoryScaleUp", "(Landroid/view/View;)Lcom/discord/utilities/views/FloatingButtonMenuInitializer$getAnimatorFactoryScaleUp$1;", "Landroid/widget/TableRow;", "Landroid/view/View$OnClickListener;", "listener", "", "setFabMenuOnClickListener", "(Landroid/widget/TableRow;Landroid/view/View$OnClickListener;)V", "defaultRowOnClickListener", "initialize", "(Landroid/view/ViewGroup;Landroid/view/View;Landroid/view/View$OnClickListener;)Lcom/discord/utilities/views/FloatingButtonMenuInitializer;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "animatorFactoryFadeIn", "Lcom/discord/utilities/views/FloatingButtonMenuInitializer$AnimatorFactory;", "", "", "onClickListenerMap", "Ljava/util/Map;", "animatorFactorySlideUp", "<init>", "(Landroid/content/Context;Ljava/util/Map;)V", "AnimatorFactory", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class FloatingButtonMenuInitializer {
    private final AnimatorFactory<View> animatorFactoryFadeIn;
    private final AnimatorFactory<View> animatorFactorySlideUp;
    private final Context context;
    private final Map<Integer, View.OnClickListener> onClickListenerMap;

    /* compiled from: FloatingButtonMenuInitializer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\n\b\u0000\u0010\u0002 \u0000*\u00020\u00012\u00020\u0003J\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/discord/utilities/views/FloatingButtonMenuInitializer$AnimatorFactory;", "Landroid/view/View;", ExifInterface.GPS_DIRECTION_TRUE, "", "view", "Landroid/animation/Animator;", "createAnimator", "(Landroid/view/View;)Landroid/animation/Animator;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public interface AnimatorFactory<T extends View> {
        Animator createAnimator(T view);
    }

    /* compiled from: FloatingButtonMenuInitializer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/discord/utilities/views/FloatingButtonMenuInitializer$getAnimatorFactoryScaleUp$1", "Lcom/discord/utilities/views/FloatingButtonMenuInitializer$AnimatorFactory;", "Landroid/view/ViewGroup;", "view", "Landroid/animation/Animator;", "createAnimator", "(Landroid/view/ViewGroup;)Landroid/animation/Animator;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.views.FloatingButtonMenuInitializer$getAnimatorFactoryScaleUp$1, reason: invalid class name */
    public static final class AnonymousClass1 implements AnimatorFactory<ViewGroup> {
        public final /* synthetic */ View $mainFab;

        public AnonymousClass1(View view) {
            this.$mainFab = view;
        }

        @Override // com.discord.utilities.views.FloatingButtonMenuInitializer.AnimatorFactory
        public /* bridge */ /* synthetic */ Animator createAnimator(View view) {
            return createAnimator((ViewGroup) view);
        }

        public Animator createAnimator(ViewGroup view) {
            Intrinsics3.checkNotNullParameter(view, "view");
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(this.$mainFab, (Property<View, Float>) View.SCALE_X, 0.0f, 1.0f), ObjectAnimator.ofFloat(this.$mainFab, (Property<View, Float>) View.SCALE_Y, 0.0f, 1.0f));
            return animatorSet;
        }
    }

    /* compiled from: FloatingButtonMenuInitializer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/discord/utilities/views/FloatingButtonMenuInitializer$getMenuAnimators$1", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "(Landroid/animation/Animator;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.views.FloatingButtonMenuInitializer$getMenuAnimators$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AnimatorListenerAdapter {
        public final /* synthetic */ ViewGroup $row;

        public AnonymousClass1(ViewGroup viewGroup) {
            this.$row = viewGroup;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics3.checkNotNullParameter(animation, "animation");
            this.$row.setVisibility(0);
        }
    }

    /* compiled from: FloatingButtonMenuInitializer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/discord/utilities/views/FloatingButtonMenuInitializer$initialize$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.views.FloatingButtonMenuInitializer$initialize$1, reason: invalid class name */
    public static final class AnonymousClass1 implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ View $mainFab;
        public final /* synthetic */ ViewGroup $menuContainer;

        public AnonymousClass1(ViewGroup viewGroup, View view) {
            this.$menuContainer = viewGroup;
            this.$mainFab = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            FloatingButtonMenuInitializer floatingButtonMenuInitializer = FloatingButtonMenuInitializer.this;
            FloatingButtonMenuInitializer.access$configureEntranceAnimator(floatingButtonMenuInitializer, FloatingButtonMenuInitializer.access$getMenuAnimators(floatingButtonMenuInitializer, this.$menuContainer, this.$mainFab)).start();
            this.$menuContainer.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FloatingButtonMenuInitializer(Context context, Map<Integer, ? extends View.OnClickListener> map) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(map, "onClickListenerMap");
        this.context = context;
        this.onClickListenerMap = map;
        this.animatorFactoryFadeIn = new FloatingButtonMenuInitializer2(this);
        this.animatorFactorySlideUp = new FloatingButtonMenuInitializer3();
    }

    public static final /* synthetic */ Animator access$configureEntranceAnimator(FloatingButtonMenuInitializer floatingButtonMenuInitializer, Animator[] animatorArr) {
        return floatingButtonMenuInitializer.configureEntranceAnimator(animatorArr);
    }

    public static final /* synthetic */ Context access$getContext$p(FloatingButtonMenuInitializer floatingButtonMenuInitializer) {
        return floatingButtonMenuInitializer.context;
    }

    public static final /* synthetic */ Animator[] access$getMenuAnimators(FloatingButtonMenuInitializer floatingButtonMenuInitializer, ViewGroup viewGroup, View view) {
        return floatingButtonMenuInitializer.getMenuAnimators(viewGroup, view);
    }

    private final Animator configureEntranceAnimator(Animator[] menuRowAnimators) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether((Animator[]) Arrays.copyOf(menuRowAnimators, menuRowAnimators.length));
        animatorSet.setInterpolator(AnimationUtils.loadInterpolator(this.context, R.interpolator.accelerate_decelerate));
        AnimatorSet duration = animatorSet.setDuration(this.context.getResources().getInteger(R.integer.config_shortAnimTime));
        Intrinsics3.checkNotNullExpressionValue(duration, "animatorEntrance.setDura…n(totalDuration.toLong())");
        return duration;
    }

    private final Animator createDefaultMenuRowAnimation(ViewGroup row, View mainFab) {
        return row.getId() == com.discord.R.id.fab_menu_main ? this.animatorFactoryFadeIn.createAnimator(row) : createMenuRowAnimation(row, this.animatorFactoryFadeIn, getAnimatorFactoryScaleUp(mainFab), this.animatorFactorySlideUp);
    }

    private final Animator createMenuRowAnimation(ViewGroup row, AnimatorFactory<? super ViewGroup>... factories) {
        ArrayList arrayList = new ArrayList(factories.length);
        for (AnimatorFactory<? super ViewGroup> animatorFactory : factories) {
            Animator animatorCreateAnimator = animatorFactory.createAnimator(row);
            if (animatorCreateAnimator != null) {
                arrayList.add(animatorCreateAnimator);
            }
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        return animatorSet;
    }

    private final AnonymousClass1 getAnimatorFactoryScaleUp(View mainFab) {
        return new AnonymousClass1(mainFab);
    }

    private final Animator[] getMenuAnimators(ViewGroup menuContainer, View mainFab) {
        int childCount = menuContainer.getChildCount();
        Animator[] animatorArr = new Animator[childCount];
        for (int i = 0; i < childCount; i++) {
            View childAt = menuContainer.getChildAt(i);
            Objects.requireNonNull(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) childAt;
            viewGroup.setVisibility(4);
            Animator animatorCreateDefaultMenuRowAnimation = createDefaultMenuRowAnimation(viewGroup, mainFab);
            if (animatorCreateDefaultMenuRowAnimation != null) {
                animatorCreateDefaultMenuRowAnimation.addListener(new AnonymousClass1(viewGroup));
            }
            animatorArr[(childCount - 1) - i] = animatorCreateDefaultMenuRowAnimation;
        }
        return animatorArr;
    }

    private final void setFabMenuOnClickListener(TableRow row, View.OnClickListener listener) {
        int childCount = row.getChildCount();
        for (int i = 0; i < childCount; i++) {
            row.getChildAt(i).setOnClickListener(listener);
        }
    }

    public final FloatingButtonMenuInitializer initialize(ViewGroup menuContainer, View mainFab, View.OnClickListener defaultRowOnClickListener) {
        Intrinsics3.checkNotNullParameter(menuContainer, "menuContainer");
        Intrinsics3.checkNotNullParameter(mainFab, "mainFab");
        Intrinsics3.checkNotNullParameter(defaultRowOnClickListener, "defaultRowOnClickListener");
        int childCount = menuContainer.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = menuContainer.getChildAt(i);
            Objects.requireNonNull(childAt, "null cannot be cast to non-null type android.widget.TableRow");
            TableRow tableRow = (TableRow) childAt;
            tableRow.setOnClickListener(defaultRowOnClickListener);
            setFabMenuOnClickListener(tableRow, this.onClickListenerMap.get(Integer.valueOf(tableRow.getId())));
        }
        menuContainer.getViewTreeObserver().addOnGlobalLayoutListener(new AnonymousClass1(menuContainer, mainFab));
        return this;
    }
}
