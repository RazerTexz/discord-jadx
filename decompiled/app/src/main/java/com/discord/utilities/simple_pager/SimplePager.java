package com.discord.utilities.simple_pager;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.material.tabs.TabLayout;
import d0.t._ArraysJvm;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SimplePager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001-B\u001d\b\u0007\u0012\u0006\u0010(\u001a\u00020'\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)¢\u0006\u0004\b+\u0010,J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR(\u0010\u001c\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0004\b\u001c\u0010\u0017\u0012\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR(\u0010!\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0004\b!\u0010\u0017\u0012\u0004\b$\u0010 \u001a\u0004\b\"\u0010\u0019\"\u0004\b#\u0010\u001bR\"\u0010%\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0017\u001a\u0004\b%\u0010\u0019\"\u0004\b&\u0010\u001b¨\u0006."}, d2 = {"Lcom/discord/utilities/simple_pager/SimplePager;", "Landroidx/viewpager/widget/ViewPager;", "Landroidx/viewpager/widget/PagerAdapter;", "adapter", "", "setAdapter", "(Landroidx/viewpager/widget/PagerAdapter;)V", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "onInterceptTouchEvent", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "Lcom/google/android/material/tabs/TabLayout;", "tabLayout", "setTabLayout", "(Lcom/google/android/material/tabs/TabLayout;)V", "wrapHeight", "Z", "getWrapHeight", "()Z", "setWrapHeight", "(Z)V", "keepAllPagesLoaded", "getKeepAllPagesLoaded", "setKeepAllPagesLoaded", "getKeepAllPagesLoaded$annotations", "()V", "preserveSelectedPage", "getPreserveSelectedPage", "setPreserveSelectedPage", "getPreserveSelectedPage$annotations", "isScrollingEnabled", "setScrollingEnabled", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Adapter", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SimplePager extends ViewPager {
    private boolean isScrollingEnabled;
    private boolean keepAllPagesLoaded;
    private boolean preserveSelectedPage;
    private boolean wrapHeight;

    /* compiled from: SimplePager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0015B#\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u0012\"\u00020\r¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/discord/utilities/simple_pager/SimplePager$Adapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Landroidx/fragment/app/Fragment;", "getItem", "(I)Landroidx/fragment/app/Fragment;", "getCount", "()I", "", "getPageTitle", "(I)Ljava/lang/CharSequence;", "", "Lcom/discord/utilities/simple_pager/SimplePager$Adapter$Item;", "items", "Ljava/util/List;", "Landroidx/fragment/app/FragmentManager;", "fm", "", "<init>", "(Landroidx/fragment/app/FragmentManager;[Lcom/discord/utilities/simple_pager/SimplePager$Adapter$Item;)V", "Item", "utils_release"}, k = 1, mv = {1, 4, 2})
    public static final class Adapter extends FragmentPagerAdapter {
        private final List<Item> items;

        /* compiled from: SimplePager.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/discord/utilities/simple_pager/SimplePager$Adapter$Item;", "", "", "title", "Ljava/lang/String;", "getTitle$utils_release", "()Ljava/lang/String;", "Lkotlin/Function0;", "Landroidx/fragment/app/Fragment;", "creator", "Lkotlin/jvm/functions/Function0;", "getCreator$utils_release", "()Lkotlin/jvm/functions/Function0;", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "utils_release"}, k = 1, mv = {1, 4, 2})
        public static final class Item {
            private final Function0<Fragment> creator;
            private final String title;

            /* JADX WARN: Multi-variable type inference failed */
            public Item(String str, Function0<? extends Fragment> function0) {
                Intrinsics3.checkNotNullParameter(str, "title");
                Intrinsics3.checkNotNullParameter(function0, "creator");
                this.title = str;
                this.creator = function0;
            }

            public final Function0<Fragment> getCreator$utils_release() {
                return this.creator;
            }

            /* renamed from: getTitle$utils_release, reason: from getter */
            public final String getTitle() {
                return this.title;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Adapter(FragmentManager fragmentManager, Item... itemArr) {
            super(fragmentManager, 1);
            Intrinsics3.checkNotNullParameter(fragmentManager, "fm");
            Intrinsics3.checkNotNullParameter(itemArr, "items");
            this.items = _ArraysJvm.asList(itemArr);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.items.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int position) {
            Function0<Fragment> creator$utils_release;
            Fragment fragmentInvoke;
            Item item = (Item) _Collections.getOrNull(this.items, position);
            if (item != null && (creator$utils_release = item.getCreator$utils_release()) != null && (fragmentInvoke = creator$utils_release.invoke()) != null) {
                return fragmentInvoke;
            }
            throw new IllegalArgumentException("Invalid position: " + position + '.');
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int position) {
            String title;
            Item item = (Item) _Collections.getOrNull(this.items, position);
            return (item == null || (title = item.getTitle()) == null) ? super.getPageTitle(position) : title;
        }
    }

    public SimplePager(Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ SimplePager(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public static /* synthetic */ void getKeepAllPagesLoaded$annotations() {
    }

    public static /* synthetic */ void getPreserveSelectedPage$annotations() {
    }

    public final boolean getKeepAllPagesLoaded() {
        return this.keepAllPagesLoaded;
    }

    public final boolean getPreserveSelectedPage() {
        return this.preserveSelectedPage;
    }

    public final boolean getWrapHeight() {
        return this.wrapHeight;
    }

    /* renamed from: isScrollingEnabled, reason: from getter */
    public final boolean getIsScrollingEnabled() {
        return this.isScrollingEnabled;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        Intrinsics3.checkNotNullParameter(event, "event");
        return this.isScrollingEnabled && super.onInterceptTouchEvent(event);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) throws Resources.NotFoundException {
        if (!this.wrapHeight) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            childAt.measure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(0, 0));
            Intrinsics3.checkNotNullExpressionValue(childAt, "child");
            int measuredHeight = childAt.getMeasuredHeight();
            if (measuredHeight > i) {
                i = measuredHeight;
            }
        }
        if (i != 0) {
            heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, BasicMeasure.EXACTLY);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics3.checkNotNullParameter(event, "event");
        return this.isScrollingEnabled && super.onTouchEvent(event);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setAdapter(PagerAdapter adapter) {
        int currentItem = getCurrentItem();
        super.setAdapter(adapter);
        if (this.preserveSelectedPage) {
            if (getChildCount() > currentItem) {
                setCurrentItem(currentItem, true);
            } else {
                setCurrentItem(0);
            }
        }
        if (this.keepAllPagesLoaded) {
            setOffscreenPageLimit(adapter != null ? adapter.getCount() : 0);
        }
    }

    public final void setKeepAllPagesLoaded(boolean z2) {
        this.keepAllPagesLoaded = z2;
    }

    public final void setPreserveSelectedPage(boolean z2) {
        this.preserveSelectedPage = z2;
    }

    public final void setScrollingEnabled(boolean z2) {
        this.isScrollingEnabled = z2;
    }

    public final void setTabLayout(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.setupWithViewPager(this);
        }
    }

    public final void setWrapHeight(boolean z2) {
        this.wrapHeight = z2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimplePager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        this.preserveSelectedPage = true;
        this.keepAllPagesLoaded = true;
        this.isScrollingEnabled = true;
    }
}
