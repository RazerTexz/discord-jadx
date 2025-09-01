package com.discord.widgets.bugreports;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.y.SelectorBottomSheet;
import b.a.y.SelectorBottomSheet2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.bugreport.BugReportConfig2;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetBugReportBinding;
import com.discord.screenshot_detection.ScreenshotDetector;
import com.discord.utilities.error.Error;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.SearchInputView;
import com.discord.views.sticker.StickerView;
import com.discord.widgets.bugreports.BugReportViewModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;
import d0.LazyJVM;
import d0.t.Collections2;
import d0.y.IOStreams;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.io.InputStream;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.functions.Func0;

/* compiled from: WidgetBugReport.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 =2\u00020\u0001:\u0001=B\u0007¢\u0006\u0004\b<\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001f\u001a\u00020\u001a8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010!\u001a\u00020 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u001d\u0010-\u001a\u00020(8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001d\u00102\u001a\u00020.8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u001c\u001a\u0004\b0\u00101R#\u00108\u001a\b\u0012\u0004\u0012\u000204038F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u001c\u001a\u0004\b6\u00107R\u0016\u0010:\u001a\u0002098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006>"}, d2 = {"Lcom/discord/widgets/bugreports/WidgetBugReport;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/bugreports/BugReportViewModel$Event;", "event", "", "handleEvent", "(Lcom/discord/widgets/bugreports/BugReportViewModel$Event;)V", "submit", "()V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onViewBoundOrOnResume", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "Lcom/discord/widgets/bugreports/BugReportViewModel$ViewState;", "viewState", "updateView", "(Lcom/discord/widgets/bugreports/BugReportViewModel$ViewState;)V", "Lcom/discord/api/bugreport/Feature;", "feature", "onFeatureClickListener", "(Lcom/discord/api/bugreport/Feature;)V", "Lcom/discord/utilities/view/validators/ValidationManager;", "validationManager$delegate", "Lkotlin/Lazy;", "getValidationManager", "()Lcom/discord/utilities/view/validators/ValidationManager;", "validationManager", "Lcom/discord/widgets/bugreports/BugReportFeatureAdapter;", "featuresAdapter", "Lcom/discord/widgets/bugreports/BugReportFeatureAdapter;", "getFeaturesAdapter", "()Lcom/discord/widgets/bugreports/BugReportFeatureAdapter;", "Lcom/discord/utilities/images/MGImages$DistinctChangeDetector;", "imagesChangeDetector", "Lcom/discord/utilities/images/MGImages$DistinctChangeDetector;", "Lcom/discord/databinding/WidgetBugReportBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetBugReportBinding;", "binding", "Lcom/discord/widgets/bugreports/BugReportViewModel;", "viewModel$delegate", "getViewModel", "()Lcom/discord/widgets/bugreports/BugReportViewModel;", "viewModel", "", "Lb/a/y/c0;", "items$delegate", "getItems", "()Ljava/util/List;", "items", "", "backHandlerAdded", "Z", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetBugReport extends AppFragment {
    public static final String INTENT_EXTRA_SCREENSHOT_FILENAME = "extra_screenshot_filename";
    public static final String INTENT_EXTRA_SCREENSHOT_URI = "extra_screenshot_uri";
    public static final int VIEW_INDEX_FEATURE_AREA = 2;
    public static final int VIEW_INDEX_REPORT = 0;
    public static final int VIEW_INDEX_STATUS = 1;
    private boolean backHandlerAdded;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final BugReportFeatureAdapter featuresAdapter;
    private final MGImages.DistinctChangeDetector imagesChangeDetector;

    /* renamed from: items$delegate, reason: from kotlin metadata */
    private final Lazy items;

    /* renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetBugReport.class, "binding", "getBinding()Lcom/discord/databinding/WidgetBugReportBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<Priority> priorityLevels = Collections2.listOf((Object[]) new Priority[]{new Priority(R.string.bug_report_priority_critical_title, R.string.bug_report_priority_critical_description, 801497159479722084L), new Priority(R.string.bug_report_priority_high_title, R.string.bug_report_priority_high_description, 410336837563973632L), new Priority(R.string.bug_report_priority_low_title, R.string.bug_report_priority_low_description, 841420679643529296L), new Priority(R.string.bug_report_priority_very_low_title, R.string.bug_report_priority_very_low_description, 827645852352512021L)});

    /* compiled from: WidgetBugReport.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u000f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00138\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00138\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/bugreports/WidgetBugReport$Companion;", "", "Landroid/content/Context;", "context", "Lcom/discord/screenshot_detection/ScreenshotDetector$Screenshot;", "screenshot", "", "launch", "(Landroid/content/Context;Lcom/discord/screenshot_detection/ScreenshotDetector$Screenshot;)V", "", "Lcom/discord/widgets/bugreports/Priority;", "priorityLevels", "Ljava/util/List;", "getPriorityLevels", "()Ljava/util/List;", "", "INTENT_EXTRA_SCREENSHOT_FILENAME", "Ljava/lang/String;", "INTENT_EXTRA_SCREENSHOT_URI", "", "VIEW_INDEX_FEATURE_AREA", "I", "VIEW_INDEX_REPORT", "VIEW_INDEX_STATUS", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final List<Priority> getPriorityLevels() {
            return WidgetBugReport.access$getPriorityLevels$cp();
        }

        public final void launch(Context context, ScreenshotDetector.Screenshot screenshot) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(screenshot, "screenshot");
            Intent intent = new Intent();
            intent.putExtra(WidgetBugReport.INTENT_EXTRA_SCREENSHOT_URI, screenshot.androidx.core.app.NotificationCompat.MessagingStyle.Message.KEY_DATA_URI java.lang.String.toString());
            intent.putExtra(WidgetBugReport.INTENT_EXTRA_SCREENSHOT_FILENAME, screenshot.filename);
            AppScreen2.d(context, WidgetBugReport.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetBugReport.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.bugreports.WidgetBugReport$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetBugReport.access$getViewModel$p(WidgetBugReport.this).useScreenshot(false);
        }
    }

    /* compiled from: WidgetBugReport.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/text/Editable;", "it", "", "invoke", "(Landroid/text/Editable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.bugreports.WidgetBugReport$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Editable, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "it");
            WidgetBugReport.access$getViewModel$p(WidgetBugReport.this).updateReportName(editable.toString());
        }
    }

    /* compiled from: WidgetBugReport.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/text/Editable;", "it", "", "invoke", "(Landroid/text/Editable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.bugreports.WidgetBugReport$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Editable, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "it");
            WidgetBugReport.access$getViewModel$p(WidgetBugReport.this).updateReportDescription(editable.toString());
        }
    }

    /* compiled from: WidgetBugReport.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.bugreports.WidgetBugReport$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "it");
            WidgetBugReport.access$getViewModel$p(WidgetBugReport.this).m23filterFeatures(str);
        }
    }

    /* compiled from: WidgetBugReport.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.bugreports.WidgetBugReport$onViewBound$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetBugReport.access$getViewModel$p(WidgetBugReport.this).useScreenshot(true);
        }
    }

    /* compiled from: WidgetBugReport.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.bugreports.WidgetBugReport$onViewBound$6, reason: invalid class name */
    public static final class AnonymousClass6 implements View.OnClickListener {

        /* compiled from: WidgetBugReport.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "priority", "", "invoke", "(I)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.bugreports.WidgetBugReport$onViewBound$6$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<Integer, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.a;
            }

            public final void invoke(int i) {
                WidgetBugReport.access$getViewModel$p(WidgetBugReport.this).updatePriority(i);
            }
        }

        public AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AppFragment.hideKeyboard$default(WidgetBugReport.this, null, 1, null);
            SelectorBottomSheet.Companion companion = SelectorBottomSheet.INSTANCE;
            FragmentManager childFragmentManager = WidgetBugReport.this.getChildFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            String string = WidgetBugReport.this.getString(R.string.bug_report_priority);
            Intrinsics3.checkNotNullExpressionValue(string, "getString(R.string.bug_report_priority)");
            SelectorBottomSheet.Companion.b(companion, childFragmentManager, string, WidgetBugReport.this.getItems(), false, new AnonymousClass1(), 8);
        }
    }

    /* compiled from: WidgetBugReport.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.bugreports.WidgetBugReport$onViewBound$7, reason: invalid class name */
    public static final class AnonymousClass7 implements View.OnClickListener {
        public AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetBugReport.access$getViewModel$p(WidgetBugReport.this).showFeatureAreas();
        }
    }

    /* compiled from: WidgetBugReport.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.bugreports.WidgetBugReport$onViewBound$8, reason: invalid class name */
    public static final class AnonymousClass8 implements View.OnClickListener {
        public AnonymousClass8() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetBugReport.access$submit(WidgetBugReport.this);
        }
    }

    /* compiled from: WidgetBugReport.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/bugreports/BugReportViewModel$ViewState;", "viewState", "", "invoke", "(Lcom/discord/widgets/bugreports/BugReportViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.bugreports.WidgetBugReport$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<BugReportViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(BugReportViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(BugReportViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetBugReport.this.updateView(viewState);
        }
    }

    /* compiled from: WidgetBugReport.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/bugreports/BugReportViewModel$Event;", "p1", "", "invoke", "(Lcom/discord/widgets/bugreports/BugReportViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.bugreports.WidgetBugReport$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<BugReportViewModel.Event, Unit> {
        public AnonymousClass2(WidgetBugReport widgetBugReport) {
            super(1, widgetBugReport, WidgetBugReport.class, "handleEvent", "handleEvent(Lcom/discord/widgets/bugreports/BugReportViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(BugReportViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(BugReportViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetBugReport.access$handleEvent((WidgetBugReport) this.receiver, event);
        }
    }

    /* compiled from: WidgetBugReport.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "()Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.bugreports.WidgetBugReport$updateView$4, reason: invalid class name */
    public static final class AnonymousClass4<R> implements Func0<Boolean> {

        /* compiled from: WidgetBugReport.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "()Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.bugreports.WidgetBugReport$updateView$4$1, reason: invalid class name */
        public static final class AnonymousClass1<R> implements Func0<Boolean> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                return call();
            }

            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public final Boolean call() {
                return Boolean.FALSE;
            }
        }

        public AnonymousClass4() {
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            WidgetBugReport.access$setBackHandlerAdded$p(WidgetBugReport.this, false);
            BugReportViewModel.showReport$default(WidgetBugReport.access$getViewModel$p(WidgetBugReport.this), null, 1, null);
            AppFragment.setOnBackPressed$default(WidgetBugReport.this, AnonymousClass1.INSTANCE, 0, 2, null);
            return Boolean.TRUE;
        }
    }

    public WidgetBugReport() {
        super(R.layout.widget_bug_report);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetBugReport$binding$2.INSTANCE, null, 2, null);
        WidgetBugReport$viewModel$2 widgetBugReport$viewModel$2 = new WidgetBugReport$viewModel$2(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(BugReportViewModel.class), new WidgetBugReport$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetBugReport$viewModel$2));
        this.featuresAdapter = new BugReportFeatureAdapter(new WidgetBugReport$featuresAdapter$1(this));
        this.imagesChangeDetector = new MGImages.DistinctChangeDetector();
        this.items = LazyJVM.lazy(new WidgetBugReport$items$2(this));
        this.validationManager = LazyJVM.lazy(new WidgetBugReport$validationManager$2(this));
    }

    public static final /* synthetic */ boolean access$getBackHandlerAdded$p(WidgetBugReport widgetBugReport) {
        return widgetBugReport.backHandlerAdded;
    }

    public static final /* synthetic */ WidgetBugReportBinding access$getBinding$p(WidgetBugReport widgetBugReport) {
        return widgetBugReport.getBinding();
    }

    public static final /* synthetic */ List access$getPriorityLevels$cp() {
        return priorityLevels;
    }

    public static final /* synthetic */ BugReportViewModel access$getViewModel$p(WidgetBugReport widgetBugReport) {
        return widgetBugReport.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetBugReport widgetBugReport, BugReportViewModel.Event event) {
        widgetBugReport.handleEvent(event);
    }

    public static final /* synthetic */ void access$setBackHandlerAdded$p(WidgetBugReport widgetBugReport, boolean z2) {
        widgetBugReport.backHandlerAdded = z2;
    }

    public static final /* synthetic */ void access$submit(WidgetBugReport widgetBugReport) {
        widgetBugReport.submit();
    }

    private final WidgetBugReportBinding getBinding() {
        return (WidgetBugReportBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final BugReportViewModel getViewModel() {
        return (BugReportViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(BugReportViewModel.Event event) {
        AppActivity appActivity;
        if (!Intrinsics3.areEqual(event, BugReportViewModel.Event.CloseReport.INSTANCE) || (appActivity = getAppActivity()) == null) {
            return;
        }
        appActivity.finish();
    }

    private final void submit() {
        InputStream inputStreamOpenInputStream;
        byte[] bytes;
        RequestBody requestBodyD = null;
        MediaType mediaTypeA = null;
        requestBodyD = null;
        requestBodyD = null;
        requestBodyD = null;
        if (ValidationManager.validate$default(getValidationManager(), false, 1, null)) {
            Uri screenshotUri = getViewModel().getScreenshotUri();
            if (getViewModel().getUseScreenshot() && screenshotUri.getPath() != null && (inputStreamOpenInputStream = requireContext().getContentResolver().openInputStream(screenshotUri)) != null && (bytes = IOStreams.readBytes(inputStreamOpenInputStream)) != null) {
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String type = requireContext().getContentResolver().getType(screenshotUri);
                if (type != null) {
                    MediaType.Companion companion2 = MediaType.INSTANCE;
                    mediaTypeA = MediaType.Companion.a(type);
                }
                requestBodyD = RequestBody.Companion.d(companion, bytes, mediaTypeA, 0, 0, 6);
            }
            getViewModel().sendReport(requestBodyD);
        }
    }

    public final BugReportFeatureAdapter getFeaturesAdapter() {
        return this.featuresAdapter;
    }

    public final List<SelectorBottomSheet2> getItems() {
        return (List) this.items.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getViewModel().prefetchStickers(requireContext());
    }

    public final void onFeatureClickListener(BugReportConfig2 feature) {
        Intrinsics3.checkNotNullParameter(feature, "feature");
        getViewModel().selectFeatureArea(feature);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarTitle(R.string.submit_bug);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        Uri uri = Uri.parse(getMostRecentIntent().getStringExtra(INTENT_EXTRA_SCREENSHOT_URI));
        RecyclerView recyclerView = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.bugReportFeatureRecycler");
        recyclerView.setAdapter(this.featuresAdapter);
        getBinding().l.setImageURI(uri);
        getBinding().f2241b.setOnClickListener(new AnonymousClass1());
        TextInputLayout textInputLayout = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.bugReportName");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new AnonymousClass2());
        TextInputLayout textInputLayout2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.bugReportDescription");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, this, new AnonymousClass3());
        getBinding().g.a(this, new AnonymousClass4());
        getBinding().q.setOnClickListener(new AnonymousClass5());
        getBinding().t.setOnClickListener(new AnonymousClass6());
        getBinding().f2242s.setOnClickListener(new AnonymousClass7());
        getBinding().o.setOnClickListener(new AnonymousClass8());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetBugReport.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetBugReport.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
    }

    public final void updateView(BugReportViewModel.ViewState viewState) {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        if (!(viewState instanceof BugReportViewModel.ViewState.Report)) {
            if (viewState instanceof BugReportViewModel.ViewState.Sending) {
                AppViewFlipper appViewFlipper = getBinding().p;
                Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.bugReportSwitchFlipper");
                appViewFlipper.setDisplayedChild(1);
                StickerView.e(getBinding().m, getViewModel().getSendingSticker(), null, 2);
                getBinding().n.setText(R.string.bug_report_status_sending);
                return;
            }
            if (viewState instanceof BugReportViewModel.ViewState.Success) {
                AppViewFlipper appViewFlipper2 = getBinding().p;
                Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.bugReportSwitchFlipper");
                appViewFlipper2.setDisplayedChild(1);
                StickerView.e(getBinding().m, getViewModel().getSuccessSticker(), null, 2);
                getBinding().n.setText(R.string.bug_report_status_sent);
                return;
            }
            if (viewState instanceof BugReportViewModel.ViewState.SelectFeature) {
                setActionBarTitle(R.string.bug_report_select_feature_area);
                setActionBarSubtitle(R.string.submit_bug);
                AppViewFlipper appViewFlipper3 = getBinding().p;
                Intrinsics3.checkNotNullExpressionValue(appViewFlipper3, "binding.bugReportSwitchFlipper");
                appViewFlipper3.setDisplayedChild(2);
                ProgressBar progressBar = getBinding().e;
                Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.bugReportFeatureLoader");
                BugReportViewModel.ViewState.SelectFeature selectFeature = (BugReportViewModel.ViewState.SelectFeature) viewState;
                progressBar.setVisibility(selectFeature.getLoadingFeatures() ? 0 : 8);
                RecyclerView recyclerView = getBinding().f;
                Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.bugReportFeatureRecycler");
                recyclerView.setVisibility(selectFeature.getLoadingFeatures() ^ true ? 0 : 8);
                View editText = getBinding().g.getEditText();
                if (!(editText instanceof TextInputLayout)) {
                    editText = null;
                }
                TextInputLayout textInputLayout = (TextInputLayout) editText;
                if (textInputLayout != null) {
                    EditText editText2 = textInputLayout.getEditText();
                    String strValueOf = String.valueOf(editText2 != null ? editText2.getText() : null);
                    String query = selectFeature.getQuery();
                    if (query == null) {
                        query = "";
                    }
                    if (!Intrinsics3.areEqual(strValueOf, query)) {
                        SearchInputView searchInputView = getBinding().g;
                        String query2 = selectFeature.getQuery();
                        searchInputView.setText(query2 != null ? query2 : "");
                    }
                }
                this.featuresAdapter.setData(selectFeature.getFeatures());
                if (this.backHandlerAdded) {
                    return;
                }
                this.backHandlerAdded = true;
                AppFragment.setOnBackPressed$default(this, new AnonymousClass4(), 0, 2, null);
                return;
            }
            return;
        }
        setActionBarTitle(R.string.submit_bug);
        setActionBarSubtitle("");
        AppViewFlipper appViewFlipper4 = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper4, "binding.bugReportSwitchFlipper");
        appViewFlipper4.setDisplayedChild(0);
        MaterialTextView materialTextView = getBinding().r;
        Intrinsics3.checkNotNullExpressionValue(materialTextView, "binding.submitReportError");
        BugReportViewModel.ViewState.Report report = (BugReportViewModel.ViewState.Report) viewState;
        materialTextView.setVisibility(report.getError() != null ? 0 : 8);
        if (report.getError() != null) {
            MaterialTextView materialTextView2 = getBinding().r;
            Intrinsics3.checkNotNullExpressionValue(materialTextView2, "binding.submitReportError");
            Error.Response response = report.getError().getResponse();
            Intrinsics3.checkNotNullExpressionValue(response, "viewState.error.response");
            materialTextView2.setText(response.getMessage());
        }
        TextInputLayout textInputLayout2 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.bugReportName");
        ViewExtensions.setTextIfDifferent(textInputLayout2, report.getReportName());
        TextInputLayout textInputLayout3 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.bugReportDescription");
        ViewExtensions.setTextIfDifferent(textInputLayout3, report.getReportDescription());
        AppCompatImageView appCompatImageView = getBinding().l;
        Intrinsics3.checkNotNullExpressionValue(appCompatImageView, "binding.bugReportScreenshot");
        appCompatImageView.setVisibility(report.getUseScreenshot() ^ true ? 4 : 0);
        AppCompatImageView appCompatImageView2 = getBinding().f2241b;
        Intrinsics3.checkNotNullExpressionValue(appCompatImageView2, "binding.bugReportClearScreenshot");
        appCompatImageView2.setVisibility(report.getUseScreenshot() ? 0 : 8);
        MaterialTextView materialTextView3 = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(materialTextView3, "binding.bugReportNoScreenshotLabel");
        materialTextView3.setVisibility(report.getUseScreenshot() ^ true ? 0 : 8);
        MaterialButton materialButton = getBinding().q;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.bugReportUndoScreenshotRemove");
        materialButton.setVisibility(report.getUseScreenshot() ^ true ? 0 : 8);
        BugReportConfig2 feature = report.getFeature();
        if (feature != null) {
            TextInputLayout textInputLayout4 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.bugReportFeatureArea");
            ViewExtensions.setTextIfDifferent(textInputLayout4, feature.getName());
        }
        Integer priority = report.getPriority();
        if (priority != null) {
            int iIntValue = priority.intValue();
            TextInputLayout textInputLayout5 = getBinding().j;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout5, "binding.bugReportPriority");
            ViewExtensions.setText(textInputLayout5, priorityLevels.get(iIntValue).getTitle());
            SimpleDraweeView simpleDraweeView = getBinding().k;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.bugReportPriorityIcon");
            MGImages.setImage$default(simpleDraweeView, getItems().get(iIntValue).d(), R.dimen.emoji_size, R.dimen.emoji_size, true, null, this.imagesChangeDetector, 32, null);
        }
    }
}
