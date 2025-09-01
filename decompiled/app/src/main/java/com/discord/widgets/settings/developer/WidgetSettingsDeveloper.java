package com.discord.widgets.settings.developer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.databinding.IconListItemTextViewBinding;
import com.discord.databinding.WidgetSettingsDeveloperBinding;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreStream;
import com.discord.utilities.bugreports.BugReportManager;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.experiments.ExperimentRegistry;
import com.discord.utilities.experiments.ExperimentRegistry2;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.discord.utilities.views.SwipeableItemTouchHelper;
import com.discord.views.CheckedSetting;
import com.hammerandchisel.libdiscord.Discord;
import d0.t.Iterables2;
import d0.t.MapsJVM;
import d0.t._Maps;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action1;

/* compiled from: WidgetSettingsDeveloper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B\u0007¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0015\u001a\u00020\u00108B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/discord/widgets/settings/developer/WidgetSettingsDeveloper;", "Lcom/discord/app/AppFragment;", "", "setupScreenshotDetector", "()V", "setupNoticesSection", "setupExperimentSection", "setupCrashes", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "Lcom/discord/widgets/settings/developer/ExperimentOverridesAdapter;", "experimentOverridesAdapter", "Lcom/discord/widgets/settings/developer/ExperimentOverridesAdapter;", "Lcom/discord/databinding/WidgetSettingsDeveloperBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetSettingsDeveloperBinding;", "binding", "<init>", "Companion", "NoticeViewHolder", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetSettingsDeveloper extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSettingsDeveloper.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsDeveloperBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private ExperimentOverridesAdapter experimentOverridesAdapter;

    /* compiled from: WidgetSettingsDeveloper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/settings/developer/WidgetSettingsDeveloper$Companion;", "", "Landroid/content/Context;", "context", "", "launch", "(Landroid/content/Context;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.e(context, WidgetSettingsDeveloper.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsDeveloper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\b\u001a\u00020\u00072\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0002H\u0017¢\u0006\u0004\b\b\u0010\tR\"\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/settings/developer/WidgetSettingsDeveloper$NoticeViewHolder;", "Lcom/discord/utilities/views/SimpleRecyclerAdapter$ViewHolder;", "Lkotlin/Pair;", "", "", "Lcom/discord/primitives/Timestamp;", "data", "", "bind", "(Lkotlin/Pair;)V", "noticeName", "Ljava/lang/String;", "getNoticeName", "()Ljava/lang/String;", "setNoticeName", "(Ljava/lang/String;)V", "Lcom/discord/databinding/IconListItemTextViewBinding;", "binding", "Lcom/discord/databinding/IconListItemTextViewBinding;", "<init>", "(Lcom/discord/databinding/IconListItemTextViewBinding;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class NoticeViewHolder extends SimpleRecyclerAdapter.ViewHolder<Tuples2<? extends String, ? extends Long>> {
        private final IconListItemTextViewBinding binding;
        public String noticeName;

        /* JADX WARN: Illegal instructions before constructor call */
        public NoticeViewHolder(IconListItemTextViewBinding iconListItemTextViewBinding) {
            Intrinsics3.checkNotNullParameter(iconListItemTextViewBinding, "binding");
            TextView textView = iconListItemTextViewBinding.a;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.root");
            super(textView);
            this.binding = iconListItemTextViewBinding;
        }

        @Override // com.discord.utilities.views.SimpleRecyclerAdapter.ViewHolder
        public /* bridge */ /* synthetic */ void bind(Tuples2<? extends String, ? extends Long> tuples2) {
            bind2((Tuples2<String, Long>) tuples2);
        }

        public final String getNoticeName() {
            String str = this.noticeName;
            if (str == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("noticeName");
            }
            return str;
        }

        public final void setNoticeName(String str) {
            Intrinsics3.checkNotNullParameter(str, "<set-?>");
            this.noticeName = str;
        }

        @SuppressLint({"SetTextI18n"})
        /* renamed from: bind, reason: avoid collision after fix types in other method */
        public void bind2(Tuples2<String, Long> data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            String strComponent1 = data.component1();
            long jLongValue = data.component2().longValue();
            this.noticeName = strComponent1;
            TextView textView = this.binding.a;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.root");
            Context context = textView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.root.context");
            CharSequence readableTimeString$default = TimeUtils.toReadableTimeString$default(context, jLongValue, null, 4, null);
            TextView textView2 = this.binding.a;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.root");
            textView2.setText(strComponent1 + " @ " + readableTimeString$default);
        }
    }

    /* compiled from: WidgetSettingsDeveloper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupCrashes$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            throw new RuntimeException("This is a developer triggered crash.");
        }
    }

    /* compiled from: WidgetSettingsDeveloper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupCrashes$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                throw new RuntimeException("This is a developer triggered crash (caught).");
            } catch (Exception e) {
                Logger.e$default(AppLog.g, "setupCrashes", e, null, 4, null);
                AppToast.j(WidgetSettingsDeveloper.this, "Done.", 0, 4);
            }
        }
    }

    /* compiled from: WidgetSettingsDeveloper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupCrashes$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Context context = WidgetSettingsDeveloper.this.getContext();
            Objects.requireNonNull(context, "null cannot be cast to non-null type android.content.Context");
            new Discord(context).crash();
        }
    }

    /* compiled from: WidgetSettingsDeveloper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupCrashes$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StoreStream.INSTANCE.getGatewaySocket().simulateReconnectForTesting();
            AppToast.j(WidgetSettingsDeveloper.this, "Done.", 0, 4);
        }
    }

    /* compiled from: WidgetSettingsDeveloper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004*\u0001\u0006\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0006 \u0003*\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u00052&\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002 \u0003*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "", "kotlin.jvm.PlatformType", "allOverrides", "", "com/discord/widgets/settings/developer/WidgetSettingsDeveloper$setupExperimentSection$1$1$1", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupExperimentSection$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<String, ? extends Integer>, List<? extends 1.1>> {
        public final /* synthetic */ StoreExperiments $experimentStore;

        public AnonymousClass1(StoreExperiments storeExperiments) {
            this.$experimentStore = storeExperiments;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ List<? extends 1.1> call(Map<String, ? extends Integer> map) {
            return call2((Map<String, Integer>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<1.1> call2(Map<String, Integer> map) {
            Collection<ExperimentRegistry2> collectionValues = ExperimentRegistry.INSTANCE.getRegisteredExperiments().values();
            Intrinsics3.checkNotNullExpressionValue(collectionValues, "ExperimentRegistry\n     …nts\n              .values");
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(collectionValues, 10));
            Iterator<T> it = collectionValues.iterator();
            while (it.hasNext()) {
                arrayList.add(new WidgetSettingsDeveloper2((ExperimentRegistry2) it.next(), this, map));
            }
            return arrayList;
        }
    }

    /* compiled from: WidgetSettingsDeveloper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0001\u0010\u0007\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "com/discord/widgets/settings/developer/WidgetSettingsDeveloper$setupExperimentSection$1$1$1", "kotlin.jvm.PlatformType", "data", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupExperimentSection$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<List<? extends AnonymousClass1.1.1>, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends AnonymousClass1.1.1> list) {
            invoke2((List<AnonymousClass1.1.1>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<AnonymousClass1.1.1> list) {
            ExperimentOverridesAdapter experimentOverridesAdapterAccess$getExperimentOverridesAdapter$p = WidgetSettingsDeveloper.access$getExperimentOverridesAdapter$p(WidgetSettingsDeveloper.this);
            Intrinsics3.checkNotNullExpressionValue(list, "data");
            experimentOverridesAdapterAccess$getExperimentOverridesAdapter$p.setData(list);
        }
    }

    /* compiled from: WidgetSettingsDeveloper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroidx/recyclerview/widget/ItemTouchHelper;", "invoke", "()Landroidx/recyclerview/widget/ItemTouchHelper;", "createSwipeableItemTouchHelper"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupNoticesSection$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<ItemTouchHelper> {

        /* compiled from: WidgetSettingsDeveloper.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/discord/widgets/settings/developer/WidgetSettingsDeveloper$setupNoticesSection$1$1", "Lcom/discord/utilities/views/SwipeableItemTouchHelper;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "", "direction", "", "onSwiped", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupNoticesSection$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03371 extends SwipeableItemTouchHelper {
            public final /* synthetic */ SwipeableItemTouchHelper.SwipeRevealConfiguration $deleteConfig;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C03371(SwipeableItemTouchHelper.SwipeRevealConfiguration swipeRevealConfiguration, SwipeableItemTouchHelper.SwipeRevealConfiguration swipeRevealConfiguration2, SwipeableItemTouchHelper.SwipeRevealConfiguration swipeRevealConfiguration3) {
                super(0, 0, swipeRevealConfiguration2, swipeRevealConfiguration3, 3, null);
                this.$deleteConfig = swipeRevealConfiguration;
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                Intrinsics3.checkNotNullParameter(viewHolder, "viewHolder");
                if (viewHolder instanceof NoticeViewHolder) {
                    StoreStream.INSTANCE.getNotices().clearSeen(((NoticeViewHolder) viewHolder).getNoticeName());
                }
            }
        }

        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ ItemTouchHelper invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ItemTouchHelper invoke() {
            SwipeableItemTouchHelper.SwipeRevealConfiguration swipeRevealConfiguration = new SwipeableItemTouchHelper.SwipeRevealConfiguration(ColorCompat.getColor(WidgetSettingsDeveloper.this, R.color.status_red_500), ContextCompat.getDrawable(WidgetSettingsDeveloper.this.requireContext(), R.drawable.ic_delete_white_24dp), DimenUtils.dpToPixels(8));
            return new ItemTouchHelper(new C03371(swipeRevealConfiguration, swipeRevealConfiguration, swipeRevealConfiguration));
        }
    }

    /* compiled from: WidgetSettingsDeveloper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001ab\u0012*\u0012(\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00010\u0001\u0012\u0016\u0012\u0014 \u0004*\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00030\u0002j\u0002`\u00030\u0007 \u0004*0\u0012*\u0012(\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00010\u0001\u0012\u0016\u0012\u0014 \u0004*\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00030\u0002j\u0002`\u00030\u0007\u0018\u00010\u00060\u00062.\u0010\u0005\u001a*\u0012\u0004\u0012\u00020\u0001\u0012\b\u0012\u00060\u0002j\u0002`\u0003 \u0004*\u0014\u0012\u0004\u0012\u00020\u0001\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Ljava/util/HashMap;", "", "", "Lcom/discord/primitives/Timestamp;", "kotlin.jvm.PlatformType", "noticesSeenMap", "", "Lkotlin/Pair;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/HashMap;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupNoticesSection$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<HashMap<String, Long>, List<? extends Tuples2<? extends String, ? extends Long>>> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ List<? extends Tuples2<? extends String, ? extends Long>> call(HashMap<String, Long> map) {
            return call2(map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<Tuples2<String, Long>> call2(HashMap<String, Long> map) {
            Intrinsics3.checkNotNullExpressionValue(map, "noticesSeenMap");
            return _Maps.toList(MapsJVM.toSortedMap(map));
        }
    }

    /* compiled from: WidgetSettingsDeveloper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u00072f\u0010\u0006\u001ab\u0012*\u0012(\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\u0016\u0012\u0014 \u0003*\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00050\u0004j\u0002`\u00050\u0001 \u0003*0\u0012*\u0012(\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\u0016\u0012\u0014 \u0003*\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00050\u0004j\u0002`\u00050\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "Lkotlin/Pair;", "", "kotlin.jvm.PlatformType", "", "Lcom/discord/primitives/Timestamp;", "noticesSeenMap", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupNoticesSection$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<List<? extends Tuples2<? extends String, ? extends Long>>, Unit> {
        public final /* synthetic */ SimpleRecyclerAdapter $noticesAdapter;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(SimpleRecyclerAdapter simpleRecyclerAdapter) {
            super(1);
            this.$noticesAdapter = simpleRecyclerAdapter;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Tuples2<? extends String, ? extends Long>> list) {
            invoke2((List<Tuples2<String, Long>>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Tuples2<String, Long>> list) {
            SimpleRecyclerAdapter simpleRecyclerAdapter = this.$noticesAdapter;
            Intrinsics3.checkNotNullExpressionValue(list, "noticesSeenMap");
            simpleRecyclerAdapter.setData(list);
        }
    }

    /* compiled from: WidgetSettingsDeveloper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "isChecked", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupScreenshotDetector$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<Boolean> {
        public final /* synthetic */ BugReportManager $bugReportProvider;

        public AnonymousClass1(BugReportManager bugReportManager) {
            this.$bugReportProvider = bugReportManager;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            BugReportManager bugReportManager = this.$bugReportProvider;
            Intrinsics3.checkNotNullExpressionValue(bool, "isChecked");
            bugReportManager.setBugReportingSettingEnabled(bool.booleanValue());
        }
    }

    public WidgetSettingsDeveloper() {
        super(R.layout.widget_settings_developer);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsDeveloper3.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ ExperimentOverridesAdapter access$getExperimentOverridesAdapter$p(WidgetSettingsDeveloper widgetSettingsDeveloper) {
        ExperimentOverridesAdapter experimentOverridesAdapter = widgetSettingsDeveloper.experimentOverridesAdapter;
        if (experimentOverridesAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("experimentOverridesAdapter");
        }
        return experimentOverridesAdapter;
    }

    public static final /* synthetic */ void access$setExperimentOverridesAdapter$p(WidgetSettingsDeveloper widgetSettingsDeveloper, ExperimentOverridesAdapter experimentOverridesAdapter) {
        widgetSettingsDeveloper.experimentOverridesAdapter = experimentOverridesAdapter;
    }

    private final WidgetSettingsDeveloperBinding getBinding() {
        return (WidgetSettingsDeveloperBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void launch(Context context) {
        INSTANCE.launch(context);
    }

    private final void setupCrashes() {
        getBinding().d.setOnClickListener(AnonymousClass1.INSTANCE);
        getBinding().c.setOnClickListener(new AnonymousClass2());
        getBinding().f2615b.setOnClickListener(new AnonymousClass3());
        getBinding().g.setOnClickListener(new AnonymousClass4());
    }

    private final void setupExperimentSection() {
        this.experimentOverridesAdapter = new ExperimentOverridesAdapter();
        RecyclerView recyclerView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.developerSettingsExperiments");
        ExperimentOverridesAdapter experimentOverridesAdapter = this.experimentOverridesAdapter;
        if (experimentOverridesAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("experimentOverridesAdapter");
        }
        recyclerView.setAdapter(experimentOverridesAdapter);
        StoreExperiments experiments = StoreStream.INSTANCE.getExperiments();
        Observable<R> observableG = experiments.observeOverrides().G(new AnonymousClass1(experiments));
        Intrinsics3.checkNotNullExpressionValue(observableG, "experimentStore\n        …              }\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableG, this, null, 2, null), WidgetSettingsDeveloper.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }

    private final void setupNoticesSection() {
        SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(null, WidgetSettingsDeveloper4.INSTANCE, 1, null);
        RecyclerView recyclerView = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.developerSettingsNotices");
        recyclerView.setAdapter(simpleRecyclerAdapter);
        new AnonymousClass1().invoke().attachToRecyclerView(getBinding().f);
        Observable<R> observableG = StoreStream.INSTANCE.getNotices().observeNoticesSeen().G(AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "StoreStream\n        .get…      .toList()\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableG), this, null, 2, null), WidgetSettingsDeveloper.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(simpleRecyclerAdapter), 62, (Object) null);
    }

    private final void setupScreenshotDetector() {
        BugReportManager bugReportManager = BugReportManager.INSTANCE.get();
        CheckedSetting checkedSetting = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.settingsDeveloperScreenshotBugReporting");
        checkedSetting.setChecked(bugReportManager.getSettingsEnabled());
        getBinding().h.setOnCheckedListener(new AnonymousClass1(bugReportManager));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarDisplayHomeAsUpEnabled(true);
        setActionBarTitle(R.string.developer_options);
        setupCrashes();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        setupScreenshotDetector();
        setupExperimentSection();
        setupNoticesSection();
    }
}
