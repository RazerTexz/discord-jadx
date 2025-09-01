package com.discord.widgets.phone;

import android.content.Context;
import android.text.Editable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetPhoneCountryCodeBottomSheetBinding;
import com.discord.models.phone.PhoneCountryCode;
import com.discord.stores.StorePhone;
import com.discord.stores.StoreStream;
import com.discord.utilities.phone.PhoneUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* compiled from: WidgetPhoneCountryCodeBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0018\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001d\u0010\u0014\u001a\u00020\u000f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/phone/WidgetPhoneCountryCodeBottomSheet;", "Lcom/discord/app/AppBottomSheet;", "", "filter", "", "configureUI", "(Ljava/lang/String;)V", "", "getContentViewResId", "()I", "onResume", "()V", "Lcom/discord/widgets/phone/PhoneCountryCodeAdapter;", "adapter", "Lcom/discord/widgets/phone/PhoneCountryCodeAdapter;", "Lcom/discord/databinding/WidgetPhoneCountryCodeBottomSheetBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetPhoneCountryCodeBottomSheetBinding;", "binding", "Lrx/subjects/BehaviorSubject;", "nameFilterSubject", "Lrx/subjects/BehaviorSubject;", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetPhoneCountryCodeBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetPhoneCountryCodeBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetPhoneCountryCodeBottomSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PhoneCountryCodeAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final BehaviorSubject<String> nameFilterSubject;

    /* compiled from: WidgetPhoneCountryCodeBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/phone/WidgetPhoneCountryCodeBottomSheet$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "context", "", "show", "(Landroidx/fragment/app/FragmentManager;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            new WidgetPhoneCountryCodeBottomSheet().show(context, WidgetPhoneCountryCodeBottomSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetPhoneCountryCodeBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/phone/PhoneCountryCode;", "it", "", "onCountryCodeSelected", "(Lcom/discord/models/phone/PhoneCountryCode;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.phone.WidgetPhoneCountryCodeBottomSheet$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements PhoneCountryCodeAdapter2 {
        public final /* synthetic */ StorePhone $phoneStore;

        public AnonymousClass1(StorePhone storePhone) {
            this.$phoneStore = storePhone;
        }

        @Override // com.discord.widgets.phone.PhoneCountryCodeAdapter2
        public final void onCountryCodeSelected(PhoneCountryCode phoneCountryCode) {
            Intrinsics3.checkNotNullParameter(phoneCountryCode, "it");
            this.$phoneStore.updateSelectedCountryCode(phoneCountryCode);
            WidgetPhoneCountryCodeBottomSheet.this.dismiss();
        }
    }

    /* compiled from: WidgetPhoneCountryCodeBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/text/Editable;", "it", "", "invoke", "(Landroid/text/Editable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.phone.WidgetPhoneCountryCodeBottomSheet$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Editable, Unit> {
        public AnonymousClass1() {
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
            WidgetPhoneCountryCodeBottomSheet.access$getNameFilterSubject$p(WidgetPhoneCountryCodeBottomSheet.this).onNext(editable.toString());
        }
    }

    /* compiled from: WidgetPhoneCountryCodeBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.phone.WidgetPhoneCountryCodeBottomSheet$onResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            WidgetPhoneCountryCodeBottomSheet widgetPhoneCountryCodeBottomSheet = WidgetPhoneCountryCodeBottomSheet.this;
            Intrinsics3.checkNotNullExpressionValue(str, "it");
            WidgetPhoneCountryCodeBottomSheet.access$configureUI(widgetPhoneCountryCodeBottomSheet, str);
        }
    }

    public WidgetPhoneCountryCodeBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetPhoneCountryCodeBottomSheet2.INSTANCE, null, 2, null);
        BehaviorSubject<String> behaviorSubjectL0 = BehaviorSubject.l0("");
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(\"\")");
        this.nameFilterSubject = behaviorSubjectL0;
        this.adapter = new PhoneCountryCodeAdapter();
    }

    public static final /* synthetic */ void access$configureUI(WidgetPhoneCountryCodeBottomSheet widgetPhoneCountryCodeBottomSheet, String str) {
        widgetPhoneCountryCodeBottomSheet.configureUI(str);
    }

    public static final /* synthetic */ BehaviorSubject access$getNameFilterSubject$p(WidgetPhoneCountryCodeBottomSheet widgetPhoneCountryCodeBottomSheet) {
        return widgetPhoneCountryCodeBottomSheet.nameFilterSubject;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void configureUI(String filter) {
        boolean z2;
        StorePhone phone = StoreStream.INSTANCE.getPhone();
        List<PhoneCountryCode> countryCodes = phone.getCountryCodes();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = countryCodes.iterator();
        while (true) {
            if (!it.hasNext()) {
                getBinding().f2509b.setHasFixedSize(false);
                RecyclerView recyclerView = getBinding().f2509b;
                Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.phoneCountryCodeRecycler");
                recyclerView.setAdapter(this.adapter);
                this.adapter.configure(arrayList, new AnonymousClass1(phone));
                return;
            }
            Object next = it.next();
            PhoneCountryCode phoneCountryCode = (PhoneCountryCode) next;
            if (!Strings4.contains((CharSequence) phoneCountryCode.getName(), (CharSequence) filter, true)) {
                PhoneUtils phoneUtils = PhoneUtils.INSTANCE;
                Context contextRequireContext = requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                z2 = Strings4.contains((CharSequence) phoneUtils.getTranslatedStringForCountry(phoneCountryCode, contextRequireContext), (CharSequence) filter, true);
            }
            if (z2) {
                arrayList.add(next);
            }
        }
    }

    private final WidgetPhoneCountryCodeBottomSheetBinding getBinding() {
        return (WidgetPhoneCountryCodeBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_phone_country_code_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        TextInputLayout textInputLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.phoneCountryCodeSearch");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new AnonymousClass1());
        Observable<String> observableP = this.nameFilterSubject.p(200L, TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableP, "nameFilterSubject.deboun…0, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableP, this, null, 2, null), WidgetPhoneCountryCodeBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
        configureUI("");
    }
}
