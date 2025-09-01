package com.discord.widgets.settings;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment2;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetSettingsLanguageSelectBinding;
import com.discord.databinding.WidgetSettingsLanguageSelectItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.settings.WidgetSettingsLanguage;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetSettingsLanguageSelect.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00132\u00020\u0001:\u0003\u0014\u0013\u0015B\u0007¢\u0006\u0004\b\u0012\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001d\u0010\u0011\u001a\u00020\f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/settings/WidgetSettingsLanguageSelect;", "Lcom/discord/app/AppDialog;", "", "locale", "", "onLocaleSelected", "(Ljava/lang/String;)V", "onResume", "()V", "Lcom/discord/widgets/settings/WidgetSettingsLanguageSelect$Adapter;", "adapter", "Lcom/discord/widgets/settings/WidgetSettingsLanguageSelect$Adapter;", "Lcom/discord/databinding/WidgetSettingsLanguageSelectBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetSettingsLanguageSelectBinding;", "binding", "<init>", "Companion", "Adapter", ExifInterface.TAG_MODEL, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetSettingsLanguageSelect extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSettingsLanguageSelect.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsLanguageSelectBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String REQUEST_KEY_USER_LOCALE = "REQUEST_KEY_USER_LOCALE";
    private static final String RESULT_KEY_USE_LOCALE = "INTENT_EXTRA_LOCALE";
    private Adapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetSettingsLanguageSelect.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/settings/WidgetSettingsLanguageSelect$Adapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/settings/WidgetSettingsLanguageSelect$Model$Item;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/widgets/settings/WidgetSettingsLanguageSelect$Adapter$AdapterItemLocale;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/widgets/settings/WidgetSettingsLanguageSelect$Adapter$AdapterItemLocale;", "Lcom/discord/widgets/settings/WidgetSettingsLanguageSelect;", "dialog", "Lcom/discord/widgets/settings/WidgetSettingsLanguageSelect;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/discord/widgets/settings/WidgetSettingsLanguageSelect;)V", "AdapterItemLocale", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Adapter extends MGRecyclerAdapterSimple<Model.Item> {
        private final WidgetSettingsLanguageSelect dialog;

        /* compiled from: WidgetSettingsLanguageSelect.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\u0012\b\b\u0001\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/settings/WidgetSettingsLanguageSelect$Adapter$AdapterItemLocale;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/settings/WidgetSettingsLanguageSelect$Adapter;", "Lcom/discord/widgets/settings/WidgetSettingsLanguageSelect$Model$Item;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/settings/WidgetSettingsLanguageSelect$Model$Item;)V", "Lcom/discord/databinding/WidgetSettingsLanguageSelectItemBinding;", "binding", "Lcom/discord/databinding/WidgetSettingsLanguageSelectItemBinding;", "layout", "adapter", "<init>", "(ILcom/discord/widgets/settings/WidgetSettingsLanguageSelect$Adapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class AdapterItemLocale extends MGRecyclerViewHolder<Adapter, Model.Item> {
            private final WidgetSettingsLanguageSelectItemBinding binding;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AdapterItemLocale(@LayoutRes int i, Adapter adapter) {
                super(i, adapter);
                Intrinsics3.checkNotNullParameter(adapter, "adapter");
                View view = this.itemView;
                int i2 = R.id.flag_icon;
                ImageView imageView = (ImageView) view.findViewById(R.id.flag_icon);
                if (imageView != null) {
                    i2 = R.id.flag_icon_barrier;
                    Barrier barrier = (Barrier) view.findViewById(R.id.flag_icon_barrier);
                    if (barrier != null) {
                        i2 = R.id.settings_language_select_item_name;
                        TextView textView = (TextView) view.findViewById(R.id.settings_language_select_item_name);
                        if (textView != null) {
                            i2 = R.id.settings_language_select_item_name_localized;
                            TextView textView2 = (TextView) view.findViewById(R.id.settings_language_select_item_name_localized);
                            if (textView2 != null) {
                                WidgetSettingsLanguageSelectItemBinding widgetSettingsLanguageSelectItemBinding = new WidgetSettingsLanguageSelectItemBinding((ConstraintLayout) view, imageView, barrier, textView, textView2);
                                Intrinsics3.checkNotNullExpressionValue(widgetSettingsLanguageSelectItemBinding, "WidgetSettingsLanguageSe…temBinding.bind(itemView)");
                                this.binding = widgetSettingsLanguageSelectItemBinding;
                                return;
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
            }

            public static final /* synthetic */ Adapter access$getAdapter$p(AdapterItemLocale adapterItemLocale) {
                return (Adapter) adapterItemLocale.adapter;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            public /* bridge */ /* synthetic */ void onConfigure(int i, Model.Item item) {
                onConfigure2(i, item);
            }

            /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
            public void onConfigure2(int position, Model.Item data) {
                Intrinsics3.checkNotNullParameter(data, "data");
                super.onConfigure(position, (int) data);
                this.binding.a.setOnClickListener(new WidgetSettingsLanguageSelect2(this, data));
                TextView textView = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.settingsLanguageSelectItemName");
                View view = this.itemView;
                Intrinsics3.checkNotNullExpressionValue(view, "itemView");
                Context context = view.getContext();
                WidgetSettingsLanguage.Companion companion = WidgetSettingsLanguage.INSTANCE;
                textView.setText(context.getString(companion.getLocaleResId(data.getLocale())));
                TextView textView2 = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.settingsLanguageSelectItemNameLocalized");
                textView2.setText(companion.getAsStringInLocale(data.getLocale()));
                this.binding.f2629b.setImageResource(companion.getLocaleFlagResId(data.getLocale()));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Adapter(RecyclerView recyclerView, WidgetSettingsLanguageSelect widgetSettingsLanguageSelect) {
            super(recyclerView, false, 2, null);
            Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
            Intrinsics3.checkNotNullParameter(widgetSettingsLanguageSelect, "dialog");
            this.dialog = widgetSettingsLanguageSelect;
        }

        public static final /* synthetic */ WidgetSettingsLanguageSelect access$getDialog$p(Adapter adapter) {
            return adapter.dialog;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return onCreateViewHolder(viewGroup, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public AdapterItemLocale onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            return new AdapterItemLocale(R.layout.widget_settings_language_select_item, this);
        }
    }

    /* compiled from: WidgetSettingsLanguageSelect.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/settings/WidgetSettingsLanguageSelect$Companion;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Lkotlin/Function1;", "", "", "onLocaleSelected", "registerForResult", "(Landroidx/fragment/app/Fragment;Lkotlin/jvm/functions/Function1;)V", "show", "(Landroidx/fragment/app/Fragment;)V", WidgetSettingsLanguageSelect.REQUEST_KEY_USER_LOCALE, "Ljava/lang/String;", "RESULT_KEY_USE_LOCALE", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void registerForResult(Fragment fragment, Function1<? super String, Unit> onLocaleSelected) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(onLocaleSelected, "onLocaleSelected");
            Fragment2.setFragmentResultListener(fragment, WidgetSettingsLanguageSelect.REQUEST_KEY_USER_LOCALE, new WidgetSettingsLanguageSelect3(onLocaleSelected));
        }

        public final void show(Fragment fragment) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            WidgetSettingsLanguageSelect widgetSettingsLanguageSelect = new WidgetSettingsLanguageSelect();
            widgetSettingsLanguageSelect.setArguments(new Bundle());
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
            widgetSettingsLanguageSelect.show(parentFragmentManager, WidgetSettingsLanguageSelect.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsLanguageSelect.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\bÂ\u0002\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/discord/widgets/settings/WidgetSettingsLanguageSelect$Model;", "", "", "Lcom/discord/widgets/settings/WidgetSettingsLanguageSelect$Model$Item;", "getLocales", "()Ljava/util/List;", "locales", "<init>", "()V", "Item", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Model {
        public static final Model INSTANCE = new Model();

        /* compiled from: WidgetSettingsLanguageSelect.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\t8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u000bR\u001c\u0010\u0014\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/settings/WidgetSettingsLanguageSelect$Model$Item;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", "component1", "()Ljava/lang/String;", "locale", "copy", "(Ljava/lang/String;)Lcom/discord/widgets/settings/WidgetSettingsLanguageSelect$Model$Item;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "type", "I", "getType", "key", "Ljava/lang/String;", "getKey", "getLocale", "<init>", "(Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Item implements MGRecyclerDataPayload {
            private final String key;
            private final String locale;
            private final int type;

            public Item(String str) {
                Intrinsics3.checkNotNullParameter(str, "locale");
                this.locale = str;
                this.key = str;
            }

            public static /* synthetic */ Item copy$default(Item item, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = item.locale;
                }
                return item.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getLocale() {
                return this.locale;
            }

            public final Item copy(String locale) {
                Intrinsics3.checkNotNullParameter(locale, "locale");
                return new Item(locale);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Item) && Intrinsics3.areEqual(this.locale, ((Item) other).locale);
                }
                return true;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final String getLocale() {
                return this.locale;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            public int hashCode() {
                String str = this.locale;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.J(outline.U("Item(locale="), this.locale, ")");
            }
        }

        private Model() {
        }

        public final List<Item> getLocales() {
            List listListOf = Collections2.listOf((Object[]) new String[]{"da", "de", "en-GB", "en-US", "es-ES", "fr", "hr", "it", "lt", "hu", "nl", "no", "pl", "pt-BR", "ro", "fi", "sv-SE", "vi", "tr", "cs", "el", "bg", "ru", "uk", "ja", "zh-TW", "th", "zh-CN", "ko", "hi"});
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listListOf, 10));
            Iterator it = listListOf.iterator();
            while (it.hasNext()) {
                arrayList.add(new Item((String) it.next()));
            }
            return arrayList;
        }
    }

    public WidgetSettingsLanguageSelect() {
        super(R.layout.widget_settings_language_select);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsLanguageSelect4.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$onLocaleSelected(WidgetSettingsLanguageSelect widgetSettingsLanguageSelect, String str) {
        widgetSettingsLanguageSelect.onLocaleSelected(str);
    }

    private final WidgetSettingsLanguageSelectBinding getBinding() {
        return (WidgetSettingsLanguageSelectBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void onLocaleSelected(String locale) {
        Bundle bundle = new Bundle();
        bundle.putString(RESULT_KEY_USE_LOCALE, locale);
        Fragment2.setFragmentResult(this, REQUEST_KEY_USER_LOCALE, bundle);
        dismiss();
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        MaxHeightRecyclerView maxHeightRecyclerView = getBinding().f2628b;
        Intrinsics3.checkNotNullExpressionValue(maxHeightRecyclerView, "binding.settingsLanguageSelectList");
        Adapter adapter = (Adapter) companion.configure(new Adapter(maxHeightRecyclerView, this));
        this.adapter = adapter;
        if (adapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        adapter.setData(Model.INSTANCE.getLocales());
    }
}
