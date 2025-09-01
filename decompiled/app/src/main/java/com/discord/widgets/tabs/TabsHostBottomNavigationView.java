package com.discord.widgets.tabs;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.databinding.TabsHostBottomNavigationViewBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompat2;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.user.UserAvatarPresenceView;
import com.discord.views.user.UserAvatarPresenceViewController;
import d0.Tuples;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TabsHostBottomNavigationView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001>B\u0011\b\u0016\u0012\u0006\u00106\u001a\u000205¢\u0006\u0004\b7\u00108B\u001d\b\u0016\u0012\u0006\u00106\u001a\u000205\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000109¢\u0006\u0004\b7\u0010;B'\b\u0016\u0012\u0006\u00106\u001a\u000205\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000109\u0012\b\b\u0002\u0010<\u001a\u00020\u0005¢\u0006\u0004\b7\u0010=J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0085\u0001\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u00132\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00152\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ/\u0010#\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005H\u0014¢\u0006\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\"\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020,0+8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b-\u0010.R\"\u00100\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\n0+8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b0\u0010.R\"\u00101\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\n0+8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b1\u0010.R\u001c\u00103\u001a\b\u0012\u0004\u0012\u00020\u001b028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u0006?"}, d2 = {"Lcom/discord/widgets/tabs/TabsHostBottomNavigationView;", "Landroid/widget/LinearLayout;", "", "initialize", "()V", "", "homeNotificationsCount", "friendsNotificationsCount", "updateNotificationBadges", "(II)V", "Lcom/discord/widgets/tabs/NavigationTab;", "selectedTab", "Lkotlin/Function1;", "onTabSelected", "", "buttonsEnabled", "", "Lcom/discord/primitives/UserId;", "myUserId", "", "visibleTabs", "Lkotlin/Function0;", "onSearchClick", "onSettingsLongPress", "onMentionsLongPress", "updateView", "(Lcom/discord/widgets/tabs/NavigationTab;Lkotlin/jvm/functions/Function1;ZJLjava/util/Set;IILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "Lcom/discord/widgets/tabs/TabsHostBottomNavigationView$HeightChangedListener;", "heightChangedListener", "addHeightChangedListener", "(Lcom/discord/widgets/tabs/TabsHostBottomNavigationView$HeightChangedListener;)V", "w", "h", "oldw", "oldh", "onSizeChanged", "(IIII)V", "Lcom/discord/views/user/UserAvatarPresenceViewController;", "userAvatarPresenceViewController", "Lcom/discord/views/user/UserAvatarPresenceViewController;", "Lcom/discord/databinding/TabsHostBottomNavigationViewBinding;", "binding", "Lcom/discord/databinding/TabsHostBottomNavigationViewBinding;", "", "Landroid/view/View;", "navigationTabToViewMap", "Ljava/util/Map;", "Landroid/widget/ImageView;", "tintableIconToNavigationTabMap", "iconToNavigationTabMap", "", "heightChangedListeners", "Ljava/util/Set;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "HeightChangedListener", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class TabsHostBottomNavigationView extends LinearLayout {
    private final TabsHostBottomNavigationViewBinding binding;
    private final Set<HeightChangedListener> heightChangedListeners;
    private Map<View, ? extends NavigationTab> iconToNavigationTabMap;
    private Map<NavigationTab, ? extends View> navigationTabToViewMap;
    private Map<ImageView, ? extends NavigationTab> tintableIconToNavigationTabMap;
    private UserAvatarPresenceViewController userAvatarPresenceViewController;

    /* compiled from: TabsHostBottomNavigationView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/widgets/tabs/TabsHostBottomNavigationView$HeightChangedListener;", "", "", "height", "", "onHeightChanged", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public interface HeightChangedListener {
        void onHeightChanged(int height);
    }

    /* compiled from: TabsHostBottomNavigationView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tabs.TabsHostBottomNavigationView$updateView$10, reason: invalid class name */
    public static final class AnonymousClass10 implements View.OnClickListener {
        public static final AnonymousClass10 INSTANCE = new AnonymousClass10();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
        }
    }

    /* compiled from: TabsHostBottomNavigationView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tabs.TabsHostBottomNavigationView$updateView$11, reason: invalid class name */
    public static final class AnonymousClass11 implements View.OnClickListener {
        public static final AnonymousClass11 INSTANCE = new AnonymousClass11();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
        }
    }

    /* compiled from: TabsHostBottomNavigationView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tabs.TabsHostBottomNavigationView$updateView$12, reason: invalid class name */
    public static final class AnonymousClass12 implements View.OnClickListener {
        public static final AnonymousClass12 INSTANCE = new AnonymousClass12();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
        }
    }

    /* compiled from: TabsHostBottomNavigationView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tabs.TabsHostBottomNavigationView$updateView$13, reason: invalid class name */
    public static final class AnonymousClass13 implements View.OnClickListener {
        public static final AnonymousClass13 INSTANCE = new AnonymousClass13();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
        }
    }

    /* compiled from: TabsHostBottomNavigationView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tabs.TabsHostBottomNavigationView$updateView$14, reason: invalid class name */
    public static final class AnonymousClass14 implements View.OnClickListener {
        public static final AnonymousClass14 INSTANCE = new AnonymousClass14();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
        }
    }

    /* compiled from: TabsHostBottomNavigationView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onLongClick", "(Landroid/view/View;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tabs.TabsHostBottomNavigationView$updateView$15, reason: invalid class name */
    public static final class AnonymousClass15 implements View.OnLongClickListener {
        public static final AnonymousClass15 INSTANCE = new AnonymousClass15();

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) {
            return false;
        }
    }

    /* compiled from: TabsHostBottomNavigationView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onLongClick", "(Landroid/view/View;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tabs.TabsHostBottomNavigationView$updateView$16, reason: invalid class name */
    public static final class AnonymousClass16 implements View.OnLongClickListener {
        public static final AnonymousClass16 INSTANCE = new AnonymousClass16();

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) {
            return false;
        }
    }

    /* compiled from: TabsHostBottomNavigationView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tabs.TabsHostBottomNavigationView$updateView$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ Function1 $onTabSelected;

        public AnonymousClass4(Function1 function1) {
            this.$onTabSelected = function1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onTabSelected.invoke(NavigationTab.HOME);
        }
    }

    /* compiled from: TabsHostBottomNavigationView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tabs.TabsHostBottomNavigationView$updateView$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public final /* synthetic */ Function1 $onTabSelected;

        public AnonymousClass5(Function1 function1) {
            this.$onTabSelected = function1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onTabSelected.invoke(NavigationTab.FRIENDS);
        }
    }

    /* compiled from: TabsHostBottomNavigationView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tabs.TabsHostBottomNavigationView$updateView$6, reason: invalid class name */
    public static final class AnonymousClass6 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onSearchClick;

        public AnonymousClass6(Function0 function0) {
            this.$onSearchClick = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onSearchClick.invoke();
        }
    }

    /* compiled from: TabsHostBottomNavigationView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tabs.TabsHostBottomNavigationView$updateView$7, reason: invalid class name */
    public static final class AnonymousClass7 implements View.OnClickListener {
        public final /* synthetic */ Function1 $onTabSelected;

        public AnonymousClass7(Function1 function1) {
            this.$onTabSelected = function1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onTabSelected.invoke(NavigationTab.MENTIONS);
        }
    }

    /* compiled from: TabsHostBottomNavigationView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tabs.TabsHostBottomNavigationView$updateView$8, reason: invalid class name */
    public static final class AnonymousClass8 implements View.OnClickListener {
        public final /* synthetic */ Function1 $onTabSelected;

        public AnonymousClass8(Function1 function1) {
            this.$onTabSelected = function1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onTabSelected.invoke(NavigationTab.SETTINGS);
        }
    }

    /* compiled from: TabsHostBottomNavigationView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tabs.TabsHostBottomNavigationView$updateView$9, reason: invalid class name */
    public static final class AnonymousClass9 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Function0 $onSettingsLongPress;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass9(Function0 function0) {
            super(1);
            this.$onSettingsLongPress = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            this.$onSettingsLongPress.invoke();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabsHostBottomNavigationView(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        TabsHostBottomNavigationViewBinding tabsHostBottomNavigationViewBindingA = TabsHostBottomNavigationViewBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics3.checkNotNullExpressionValue(tabsHostBottomNavigationViewBindingA, "TabsHostBottomNavigation…rom(context), this, true)");
        this.binding = tabsHostBottomNavigationViewBindingA;
        this.heightChangedListeners = new LinkedHashSet();
    }

    private final void initialize() {
        int i;
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        if (resources.getConfiguration().orientation == 1) {
            Resources resources2 = getResources();
            Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
            i = resources2.getDisplayMetrics().widthPixels;
        } else {
            Resources resources3 = getResources();
            Intrinsics3.checkNotNullExpressionValue(resources3, "resources");
            i = resources3.getDisplayMetrics().heightPixels;
        }
        LinearLayout linearLayout = this.binding.l;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.tabsHostBottomNavTabsContainer");
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        layoutParams.width = i;
        LinearLayout linearLayout2 = this.binding.l;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.tabsHostBottomNavTabsContainer");
        linearLayout2.setLayoutParams(layoutParams);
        ImageView imageView = this.binding.e;
        NavigationTab navigationTab = NavigationTab.HOME;
        ImageView imageView2 = this.binding.f2157b;
        NavigationTab navigationTab2 = NavigationTab.FRIENDS;
        ImageView imageView3 = this.binding.j;
        NavigationTab navigationTab3 = NavigationTab.SEARCH;
        ImageView imageView4 = this.binding.h;
        NavigationTab navigationTab4 = NavigationTab.MENTIONS;
        this.tintableIconToNavigationTabMap = Maps6.mapOf(Tuples.to(imageView, navigationTab), Tuples.to(imageView2, navigationTab2), Tuples.to(imageView3, navigationTab3), Tuples.to(imageView4, navigationTab4));
        UserAvatarPresenceView userAvatarPresenceView = this.binding.m;
        NavigationTab navigationTab5 = NavigationTab.SETTINGS;
        this.iconToNavigationTabMap = Maps6.mapOf(Tuples.to(this.binding.e, navigationTab), Tuples.to(this.binding.f2157b, navigationTab2), Tuples.to(this.binding.j, navigationTab3), Tuples.to(this.binding.h, navigationTab4), Tuples.to(userAvatarPresenceView, navigationTab5));
        this.navigationTabToViewMap = Maps6.mapOf(Tuples.to(navigationTab, this.binding.f), Tuples.to(navigationTab2, this.binding.c), Tuples.to(navigationTab3, this.binding.k), Tuples.to(navigationTab4, this.binding.i), Tuples.to(navigationTab5, this.binding.n));
        UserAvatarPresenceView userAvatarPresenceView2 = this.binding.m;
        Intrinsics3.checkNotNullExpressionValue(userAvatarPresenceView2, "binding.tabsHostBottomNavUserAvatarPresenceView");
        this.userAvatarPresenceViewController = new UserAvatarPresenceViewController(userAvatarPresenceView2, null, null, null, 14);
    }

    private final void updateNotificationBadges(int homeNotificationsCount, int friendsNotificationsCount) {
        TextView textView = this.binding.g;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.tabsHostBottomNavHomeNotificationsBadge");
        textView.setText(String.valueOf(homeNotificationsCount));
        TextView textView2 = this.binding.g;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.tabsHostBottomNavHomeNotificationsBadge");
        textView2.setVisibility(homeNotificationsCount > 0 ? 0 : 8);
        TextView textView3 = this.binding.g;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.tabsHostBottomNavHomeNotificationsBadge");
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        textView3.setContentDescription(FormatUtils.i(resources, R.string.mentions_count, new Object[]{String.valueOf(homeNotificationsCount)}, null, 4));
        TextView textView4 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.tabsHostBottomNavFriendsNotificationsBadge");
        textView4.setText(String.valueOf(friendsNotificationsCount));
        TextView textView5 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.tabsHostBottomNavFriendsNotificationsBadge");
        textView5.setVisibility(friendsNotificationsCount > 0 ? 0 : 8);
        TextView textView6 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView6, "binding.tabsHostBottomNavFriendsNotificationsBadge");
        Resources resources2 = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
        textView6.setContentDescription(FormatUtils.i(resources2, R.string.incoming_friend_requests_count, new Object[]{String.valueOf(friendsNotificationsCount)}, null, 4));
    }

    public final void addHeightChangedListener(HeightChangedListener heightChangedListener) {
        Intrinsics3.checkNotNullParameter(heightChangedListener, "heightChangedListener");
        this.heightChangedListeners.add(heightChangedListener);
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Iterator<T> it = this.heightChangedListeners.iterator();
        while (it.hasNext()) {
            ((HeightChangedListener) it.next()).onHeightChanged(h);
        }
    }

    public final void updateView(NavigationTab selectedTab, Function1<? super NavigationTab, Unit> onTabSelected, boolean buttonsEnabled, long myUserId, Set<? extends NavigationTab> visibleTabs, int homeNotificationsCount, int friendsNotificationsCount, Function0<Unit> onSearchClick, Function0<Unit> onSettingsLongPress, Function0<Unit> onMentionsLongPress) {
        Intrinsics3.checkNotNullParameter(selectedTab, "selectedTab");
        Intrinsics3.checkNotNullParameter(onTabSelected, "onTabSelected");
        Intrinsics3.checkNotNullParameter(visibleTabs, "visibleTabs");
        Intrinsics3.checkNotNullParameter(onSearchClick, "onSearchClick");
        Intrinsics3.checkNotNullParameter(onSettingsLongPress, "onSettingsLongPress");
        Intrinsics3.checkNotNullParameter(onMentionsLongPress, "onMentionsLongPress");
        LinearLayout linearLayout = this.binding.l;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.tabsHostBottomNavTabsContainer");
        linearLayout.setWeightSum(visibleTabs.size());
        ConstraintLayout constraintLayout = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.tabsHostBottomNavHomeItem");
        constraintLayout.setVisibility(visibleTabs.contains(NavigationTab.HOME) ? 0 : 8);
        ConstraintLayout constraintLayout2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.tabsHostBottomNavFriendsItem");
        constraintLayout2.setVisibility(visibleTabs.contains(NavigationTab.FRIENDS) ? 0 : 8);
        FrameLayout frameLayout = this.binding.k;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.tabsHostBottomNavSearchItem");
        frameLayout.setVisibility(visibleTabs.contains(NavigationTab.SEARCH) ? 0 : 8);
        FrameLayout frameLayout2 = this.binding.i;
        Intrinsics3.checkNotNullExpressionValue(frameLayout2, "binding.tabsHostBottomNavMentionsItem");
        frameLayout2.setVisibility(visibleTabs.contains(NavigationTab.MENTIONS) ? 0 : 8);
        FrameLayout frameLayout3 = this.binding.n;
        Intrinsics3.checkNotNullExpressionValue(frameLayout3, "binding.tabsHostBottomNavUserSettingsItem");
        frameLayout3.setVisibility(visibleTabs.contains(NavigationTab.SETTINGS) ? 0 : 8);
        Map<ImageView, ? extends NavigationTab> map = this.tintableIconToNavigationTabMap;
        if (map == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("tintableIconToNavigationTabMap");
        }
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            ColorCompat2.tintWithColor((ImageView) entry.getKey(), ColorCompat.getThemedColor(getContext(), ((NavigationTab) entry.getValue()) == selectedTab ? R.attr.colorTabsIconActive : R.attr.colorInteractiveNormal));
        }
        Map<View, ? extends NavigationTab> map2 = this.iconToNavigationTabMap;
        if (map2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("iconToNavigationTabMap");
        }
        Iterator<T> it2 = map2.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it2.next();
            ((View) entry2.getKey()).setAlpha(selectedTab == ((NavigationTab) entry2.getValue()) ? 1.0f : 0.5f);
        }
        Map<NavigationTab, ? extends View> map3 = this.navigationTabToViewMap;
        if (map3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("navigationTabToViewMap");
        }
        Iterator<T> it3 = map3.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry entry3 = (Map.Entry) it3.next();
            ((View) entry3.getValue()).setSelected(selectedTab == ((NavigationTab) entry3.getKey()));
        }
        UserAvatarPresenceViewController userAvatarPresenceViewController = this.userAvatarPresenceViewController;
        if (userAvatarPresenceViewController == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("userAvatarPresenceViewController");
        }
        long j = userAvatarPresenceViewController.userId;
        userAvatarPresenceViewController.userId = myUserId;
        if (j != myUserId) {
            userAvatarPresenceViewController.bind();
        }
        updateNotificationBadges(homeNotificationsCount, friendsNotificationsCount);
        if (!buttonsEnabled) {
            this.binding.f.setOnClickListener(AnonymousClass10.INSTANCE);
            this.binding.c.setOnClickListener(AnonymousClass11.INSTANCE);
            this.binding.k.setOnClickListener(AnonymousClass12.INSTANCE);
            this.binding.i.setOnClickListener(AnonymousClass13.INSTANCE);
            this.binding.n.setOnClickListener(AnonymousClass14.INSTANCE);
            this.binding.n.setOnLongClickListener(AnonymousClass15.INSTANCE);
            this.binding.i.setOnLongClickListener(AnonymousClass16.INSTANCE);
            return;
        }
        this.binding.f.setOnClickListener(new AnonymousClass4(onTabSelected));
        this.binding.c.setOnClickListener(new AnonymousClass5(onTabSelected));
        this.binding.k.setOnClickListener(new AnonymousClass6(onSearchClick));
        this.binding.i.setOnClickListener(new AnonymousClass7(onTabSelected));
        this.binding.n.setOnClickListener(new AnonymousClass8(onTabSelected));
        FrameLayout frameLayout4 = this.binding.n;
        Intrinsics3.checkNotNullExpressionValue(frameLayout4, "binding.tabsHostBottomNavUserSettingsItem");
        ViewExtensions.setOnLongClickListenerConsumeClick(frameLayout4, new AnonymousClass9(onSettingsLongPress));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabsHostBottomNavigationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        TabsHostBottomNavigationViewBinding tabsHostBottomNavigationViewBindingA = TabsHostBottomNavigationViewBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics3.checkNotNullExpressionValue(tabsHostBottomNavigationViewBindingA, "TabsHostBottomNavigation…rom(context), this, true)");
        this.binding = tabsHostBottomNavigationViewBindingA;
        this.heightChangedListeners = new LinkedHashSet();
        initialize();
    }

    public /* synthetic */ TabsHostBottomNavigationView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabsHostBottomNavigationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        TabsHostBottomNavigationViewBinding tabsHostBottomNavigationViewBindingA = TabsHostBottomNavigationViewBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics3.checkNotNullExpressionValue(tabsHostBottomNavigationViewBindingA, "TabsHostBottomNavigation…rom(context), this, true)");
        this.binding = tabsHostBottomNavigationViewBindingA;
        this.heightChangedListeners = new LinkedHashSet();
        initialize();
    }

    public /* synthetic */ TabsHostBottomNavigationView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
