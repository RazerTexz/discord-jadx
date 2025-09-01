package com.discord.widgets.servers;

import a0.a.a.b;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.user.User;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsBanListItemBinding;
import com.discord.databinding.WidgetServerSettingsBansBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelBan;
import com.discord.models.guild.Guild;
import com.discord.models.user.CoreUser;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.locale.LocaleManager;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* compiled from: WidgetServerSettingsBans.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 02\u00020\u0001:\u0003102B\u0007¢\u0006\u0004\b/\u0010\u0017J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ#\u0010\u0010\u001a\u00020\u00042\n\u0010\r\u001a\u00060\u000bj\u0002`\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR:\u0010\u001e\u001a&\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u00070\u0007 \u001d*\u0012\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u001c0\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010!\u001a\u00020 8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001a\u0010\r\u001a\u00060\u000bj\u0002`\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u001d\u0010.\u001a\u00020)8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-¨\u00063"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsBans;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/servers/WidgetServerSettingsBans$Model;", "model", "", "configureUI", "(Lcom/discord/widgets/servers/WidgetServerSettingsBans$Model;)V", "", "guildName", "configureToolbar", "(Ljava/lang/String;)V", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/models/domain/ModelBan;", "ban", "showConfirmUnbanDialog", "(JLcom/discord/models/domain/ModelBan;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onResume", "()V", "onPause", "Lcom/discord/widgets/servers/WidgetServerSettingsBans$Adapter;", "adapter", "Lcom/discord/widgets/servers/WidgetServerSettingsBans$Adapter;", "Lrx/subjects/BehaviorSubject;", "kotlin.jvm.PlatformType", "filterPublisher", "Lrx/subjects/BehaviorSubject;", "Lcom/discord/app/LoggingConfig;", "loggingConfig", "Lcom/discord/app/LoggingConfig;", "getLoggingConfig", "()Lcom/discord/app/LoggingConfig;", "J", "Landroidx/appcompat/app/AlertDialog;", "dialog", "Landroidx/appcompat/app/AlertDialog;", "Lcom/discord/databinding/WidgetServerSettingsBansBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetServerSettingsBansBinding;", "binding", "<init>", "Companion", "Adapter", ExifInterface.TAG_MODEL, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsBans extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsBans.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsBansBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "GUILD_ID";
    private static final int VIEW_INDEX_BANS_LOADING = 0;
    private static final int VIEW_INDEX_BAN_LIST = 1;
    private static final int VIEW_INDEX_NO_BANS = 2;
    private static final int VIEW_INDEX_NO_RESULTS = 3;
    private Adapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private AlertDialog dialog;
    private final BehaviorSubject<String> filterPublisher;
    private long guildId;
    private final AppLogger2 loggingConfig;

    /* compiled from: WidgetServerSettingsBans.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\b\u001a\u00060\u0007R\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR0\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsBans$Adapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/servers/WidgetServerSettingsBans$Model$BanItem;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/widgets/servers/WidgetServerSettingsBans$Adapter$BanListItem;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/widgets/servers/WidgetServerSettingsBans$Adapter$BanListItem;", "Lkotlin/Function1;", "Lcom/discord/models/domain/ModelBan;", "", "onBanSelectedListener", "Lkotlin/jvm/functions/Function1;", "getOnBanSelectedListener", "()Lkotlin/jvm/functions/Function1;", "setOnBanSelectedListener", "(Lkotlin/jvm/functions/Function1;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "BanListItem", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Adapter extends MGRecyclerAdapterSimple<Model.BanItem> {
        private Function1<? super ModelBan, Unit> onBanSelectedListener;

        /* compiled from: WidgetServerSettingsBans.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsBans$Adapter$BanListItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/servers/WidgetServerSettingsBans$Adapter;", "Lcom/discord/widgets/servers/WidgetServerSettingsBans$Model$BanItem;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/servers/WidgetServerSettingsBans$Model$BanItem;)V", "Lcom/discord/databinding/WidgetServerSettingsBanListItemBinding;", "binding", "Lcom/discord/databinding/WidgetServerSettingsBanListItemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/servers/WidgetServerSettingsBans$Adapter;Lcom/discord/widgets/servers/WidgetServerSettingsBans$Adapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public final class BanListItem extends MGRecyclerViewHolder<Adapter, Model.BanItem> {
            private final WidgetServerSettingsBanListItemBinding binding;
            public final /* synthetic */ Adapter this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BanListItem(Adapter adapter, Adapter adapter2) {
                super(R.layout.widget_server_settings_ban_list_item, adapter2);
                Intrinsics3.checkNotNullParameter(adapter2, "adapter");
                this.this$0 = adapter;
                View view = this.itemView;
                RelativeLayout relativeLayout = (RelativeLayout) view;
                int i = R.id.ban_list_item_avatar;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.ban_list_item_avatar);
                if (simpleDraweeView != null) {
                    i = R.id.ban_list_item_name;
                    TextView textView = (TextView) view.findViewById(R.id.ban_list_item_name);
                    if (textView != null) {
                        WidgetServerSettingsBanListItemBinding widgetServerSettingsBanListItemBinding = new WidgetServerSettingsBanListItemBinding((RelativeLayout) view, relativeLayout, simpleDraweeView, textView);
                        Intrinsics3.checkNotNullExpressionValue(widgetServerSettingsBanListItemBinding, "WidgetServerSettingsBanL…temBinding.bind(itemView)");
                        this.binding = widgetServerSettingsBanListItemBinding;
                        return;
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
            }

            public static final /* synthetic */ Adapter access$getAdapter$p(BanListItem banListItem) {
                return (Adapter) banListItem.adapter;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            public /* bridge */ /* synthetic */ void onConfigure(int i, Model.BanItem banItem) {
                onConfigure2(i, banItem);
            }

            /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
            public void onConfigure2(int position, Model.BanItem data) {
                User user;
                User user2;
                Intrinsics3.checkNotNullParameter(data, "data");
                super.onConfigure(position, (int) data);
                TextView textView = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.banListItemName");
                ModelBan ban = data.getBan();
                CoreUser coreUser = null;
                textView.setText((ban == null || (user2 = ban.getUser()) == null) ? null : user2.getUsername());
                SimpleDraweeView simpleDraweeView = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.banListItemAvatar");
                ModelBan ban2 = data.getBan();
                if (ban2 != null && (user = ban2.getUser()) != null) {
                    coreUser = new CoreUser(user);
                }
                IconUtils.setIcon$default(simpleDraweeView, coreUser, R.dimen.avatar_size_standard, null, null, null, 56, null);
                this.binding.f2543b.setOnClickListener(new WidgetServerSettingsBans2(this, data));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Adapter(RecyclerView recyclerView) {
            super(recyclerView, false, 2, null);
            Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        }

        public final Function1<ModelBan, Unit> getOnBanSelectedListener() {
            return this.onBanSelectedListener;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return onCreateViewHolder(viewGroup, i);
        }

        public final void setOnBanSelectedListener(Function1<? super ModelBan, Unit> function1) {
            this.onBanSelectedListener = function1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BanListItem onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            if (viewType == 1) {
                return new BanListItem(this, this);
            }
            throw invalidViewTypeException(viewType);
        }
    }

    /* compiled from: WidgetServerSettingsBans.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\r8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\r8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsBans$Companion;", "", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "create", "(Landroid/content/Context;J)V", "", WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, "Ljava/lang/String;", "", "VIEW_INDEX_BANS_LOADING", "I", "VIEW_INDEX_BAN_LIST", "VIEW_INDEX_NO_BANS", "VIEW_INDEX_NO_RESULTS", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            StoreStream.INSTANCE.getAnalytics().onGuildSettingsPaneViewed("BANS", guildId);
            Intent intentPutExtra = new Intent().putExtra(WidgetServerSettingsBans.INTENT_EXTRA_GUILD_ID, guildId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(INTENT_EXTRA_GUILD_ID, guildId)");
            AppScreen2.d(context, WidgetServerSettingsBans.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsBans.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelBan;", "ban", "", "invoke", "(Lcom/discord/models/domain/ModelBan;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsBans$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelBan, Unit> {
        public final /* synthetic */ Model $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Model model) {
            super(1);
            this.$model = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelBan modelBan) {
            invoke2(modelBan);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelBan modelBan) {
            Intrinsics3.checkNotNullParameter(modelBan, "ban");
            WidgetServerSettingsBans.access$showConfirmUnbanDialog(WidgetServerSettingsBans.this, this.$model.getGuildId(), modelBan);
        }
    }

    /* compiled from: WidgetServerSettingsBans.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/text/Editable;", "it", "", "invoke", "(Landroid/text/Editable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsBans$onResume$1, reason: invalid class name */
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
            WidgetServerSettingsBans.access$getFilterPublisher$p(WidgetServerSettingsBans.this).onNext(editable.toString());
        }
    }

    /* compiled from: WidgetServerSettingsBans.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsBans$Model;", "it", "", "invoke", "(Lcom/discord/widgets/servers/WidgetServerSettingsBans$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsBans$onResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Model, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) throws Exception {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) throws Exception {
            WidgetServerSettingsBans.access$configureUI(WidgetServerSettingsBans.this, model);
        }
    }

    /* compiled from: WidgetServerSettingsBans.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsBans$showConfirmUnbanDialog$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ ModelBan $ban;
        public final /* synthetic */ long $guildId;

        /* compiled from: WidgetServerSettingsBans.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.servers.WidgetServerSettingsBans$showConfirmUnbanDialog$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03041 extends Lambda implements Function1<Void, Unit> {
            public static final C03041 INSTANCE = new C03041();

            public C03041() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r1) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, ModelBan modelBan) {
            super(1);
            this.$guildId = j;
            this.$ban = modelBan;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().unbanUser(this.$guildId, this.$ban.getUser().getId()), false, 1, null), WidgetServerSettingsBans.this, null, 2, null), WidgetServerSettingsBans.this.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, C03041.INSTANCE, 62, (Object) null);
        }
    }

    public WidgetServerSettingsBans() {
        super(R.layout.widget_server_settings_bans);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsBans6.INSTANCE, null, 2, null);
        this.filterPublisher = BehaviorSubject.l0("");
        this.loggingConfig = new AppLogger2(false, null, WidgetServerSettingsBans7.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsBans widgetServerSettingsBans, Model model) throws Exception {
        widgetServerSettingsBans.configureUI(model);
    }

    public static final /* synthetic */ BehaviorSubject access$getFilterPublisher$p(WidgetServerSettingsBans widgetServerSettingsBans) {
        return widgetServerSettingsBans.filterPublisher;
    }

    public static final /* synthetic */ void access$showConfirmUnbanDialog(WidgetServerSettingsBans widgetServerSettingsBans, long j, ModelBan modelBan) {
        widgetServerSettingsBans.showConfirmUnbanDialog(j, modelBan);
    }

    private final void configureToolbar(String guildName) {
        setActionBarTitle(R.string.bans);
        setActionBarSubtitle(guildName);
    }

    private final void configureUI(Model model) throws Exception {
        if ((model != null ? model.getFilteredBannedUsers() : null) == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
                return;
            }
            return;
        }
        configureToolbar(model.getGuildName());
        if (model.isLoading()) {
            AppViewFlipper appViewFlipper = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.serverSettingsBansViewFlipper");
            appViewFlipper.setDisplayedChild(0);
        } else if (model.getTotalBannedUsers() == 0) {
            AppViewFlipper appViewFlipper2 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.serverSettingsBansViewFlipper");
            appViewFlipper2.setDisplayedChild(2);
        } else if (model.getFilteredBannedUsers().isEmpty()) {
            AppViewFlipper appViewFlipper3 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper3, "binding.serverSettingsBansViewFlipper");
            appViewFlipper3.setDisplayedChild(3);
        } else {
            AppViewFlipper appViewFlipper4 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper4, "binding.serverSettingsBansViewFlipper");
            appViewFlipper4.setDisplayedChild(1);
        }
        Adapter adapter = this.adapter;
        if (adapter != null) {
            adapter.setOnBanSelectedListener(new AnonymousClass1(model));
        }
        Adapter adapter2 = this.adapter;
        if (adapter2 != null) {
            adapter2.setData(model.getFilteredBannedUsers());
        }
    }

    public static final void create(Context context, long j) {
        INSTANCE.create(context, j);
    }

    private final WidgetServerSettingsBansBinding getBinding() {
        return (WidgetServerSettingsBansBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void showConfirmUnbanDialog(long guildId, ModelBan ban) {
        String reason = ban.getReason();
        if (reason == null) {
            reason = getString(R.string.no_ban_reason);
        }
        Intrinsics3.checkNotNullExpressionValue(reason, "ban.reason ?: getString(R.string.no_ban_reason)");
        StringBuilder sb = new StringBuilder();
        String string = getString(R.string.ban_reason);
        Intrinsics3.checkNotNullExpressionValue(string, "getString(R.string.ban_reason)");
        Locale primaryLocale = new LocaleManager().getPrimaryLocale(getContext());
        Objects.requireNonNull(string, "null cannot be cast to non-null type java.lang.String");
        String upperCase = string.toUpperCase(primaryLocale);
        Intrinsics3.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
        sb.append(upperCase);
        sb.append("\n");
        sb.append(reason);
        WidgetNoticeDialog.Builder dialogAttrTheme = WidgetNoticeDialog.Builder.setNegativeButton$default(new WidgetNoticeDialog.Builder(requireContext()).setTitle(FormatUtils.h(requireContext(), R.string.unban_user_title, new Object[]{ban.getUser().getUsername()}, null, 4).toString()).setMessage(sb.toString()), R.string.cancel, (Function1) null, 2, (Object) null).setPositiveButton(R.string.unban, new AnonymousClass1(guildId, ban)).setDialogAttrTheme(R.attr.notice_theme_positive_red);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        dialogAttrTheme.show(parentFragmentManager);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        AlertDialog alertDialog = this.dialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        this.dialog = null;
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        BehaviorSubject<String> behaviorSubject = this.filterPublisher;
        TextInputLayout textInputLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsBansSearch");
        behaviorSubject.onNext(ViewExtensions.getTextOrEmpty(textInputLayout));
        TextInputLayout textInputLayout2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.serverSettingsBansSearch");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, this, new AnonymousClass1());
        Model.Companion companion = Model.INSTANCE;
        long j = this.guildId;
        BehaviorSubject<String> behaviorSubject2 = this.filterPublisher;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject2, "filterPublisher");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(companion.get(j, behaviorSubject2), this, null, 2, null), WidgetServerSettingsBans.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f2544b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.serverSettingsBansRecycler");
        this.adapter = (Adapter) companion.configure(new Adapter(recyclerView));
        this.guildId = getMostRecentIntent().getLongExtra(INTENT_EXTRA_GUILD_ID, -1L);
    }

    /* compiled from: WidgetServerSettingsBans.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u0000 *2\u00020\u0001:\u0002+*B=\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\u0010\u0015\u001a\u00060\tj\u0002`\n\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0017\u001a\u00020\u0010¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\u000b\u001a\u00060\tj\u0002`\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012JP\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00022\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\f\b\u0002\u0010\u0015\u001a\u00060\tj\u0002`\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0017\u001a\u00020\u0010HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u000fJ\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0004J\u001a\u0010\u001d\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u001b\u0010\u0016\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u001f\u001a\u0004\b \u0010\u000fR\u0019\u0010\u0017\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010!\u001a\u0004\b\u0017\u0010\u0012R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b#\u0010\u0004R!\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010$\u001a\u0004\b%\u0010\bR\u001d\u0010\u0015\u001a\u00060\tj\u0002`\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010&\u001a\u0004\b'\u0010\f¨\u0006,"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsBans$Model;", "", "", "component1", "()I", "", "Lcom/discord/widgets/servers/WidgetServerSettingsBans$Model$BanItem;", "component2", "()Ljava/util/List;", "", "Lcom/discord/primitives/GuildId;", "component3", "()J", "", "component4", "()Ljava/lang/String;", "", "component5", "()Z", "totalBannedUsers", "filteredBannedUsers", "guildId", "guildName", "isLoading", "copy", "(ILjava/util/List;JLjava/lang/String;Z)Lcom/discord/widgets/servers/WidgetServerSettingsBans$Model;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getGuildName", "Z", "I", "getTotalBannedUsers", "Ljava/util/List;", "getFilteredBannedUsers", "J", "getGuildId", "<init>", "(ILjava/util/List;JLjava/lang/String;Z)V", "Companion", "BanItem", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Model {
        public static final int TYPE_BANNED_USER = 1;
        private final List<BanItem> filteredBannedUsers;
        private final long guildId;
        private final String guildName;
        private final boolean isLoading;
        private final int totalBannedUsers;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final ArrayList<BanItem> emptyBansList = new ArrayList<>();

        /* compiled from: WidgetServerSettingsBans.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001f\u0010 J!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H\u0002¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0004\b\u0012\u0010\rJ3\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00160\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsBans$Model$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lrx/Observable;", "", "getCanManageBans", "(J)Lrx/Observable;", "", "filterPublisher", "Lcom/discord/widgets/servers/WidgetServerSettingsBans$Model;", "getBanItems", "(JLrx/Observable;)Lrx/Observable;", "Lcom/discord/models/guild/Guild;", "guild", "createLoading", "(Lcom/discord/models/guild/Guild;)Lcom/discord/widgets/servers/WidgetServerSettingsBans$Model;", "get", "", "totalBannedUsers", "", "Lcom/discord/widgets/servers/WidgetServerSettingsBans$Model$BanItem;", "filteredBannedUsers", "create", "(Lcom/discord/models/guild/Guild;Ljava/lang/Integer;Ljava/util/List;)Lcom/discord/widgets/servers/WidgetServerSettingsBans$Model;", "TYPE_BANNED_USER", "I", "Ljava/util/ArrayList;", "emptyBansList", "Ljava/util/ArrayList;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public static final /* synthetic */ Model access$createLoading(Companion companion, Guild guild) {
                return companion.createLoading(guild);
            }

            public static final /* synthetic */ Observable access$getBanItems(Companion companion, long j, Observable observable) {
                return companion.getBanItems(j, observable);
            }

            private final Model createLoading(Guild guild) {
                if (guild == null) {
                    return null;
                }
                return new Model(0, Model.access$getEmptyBansList$cp(), guild.getId(), guild.getName(), true);
            }

            private final Observable<Model> getBanItems(long guildId, Observable<String> filterPublisher) {
                Observable<R> observableY = StoreStream.INSTANCE.getBans().observeBans(guildId).Y(new WidgetServerSettingsBans4(guildId, filterPublisher));
                Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n            …          }\n            }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableY).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "StoreStream\n            …  .distinctUntilChanged()");
                return observableR;
            }

            private final Observable<Boolean> getCanManageBans(long guildId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableI = Observable.i(companion.getPermissions().observePermissionsForGuild(guildId), companion.getGuilds().observeGuild(guildId), StoreUser.observeMe$default(companion.getUsers(), false, 1, null), WidgetServerSettingsBans5.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableI, "Observable\n             …        }\n              }");
                Observable<Boolean> observableR = ObservableExtensionsKt.computationLatest(observableI).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "Observable\n             …  .distinctUntilChanged()");
                return observableR;
            }

            public final Model create(Guild guild, Integer totalBannedUsers, List<BanItem> filteredBannedUsers) {
                if (guild == null || totalBannedUsers == null || filteredBannedUsers == null) {
                    return null;
                }
                return new Model(totalBannedUsers.intValue(), filteredBannedUsers, guild.getId(), guild.getName(), false);
            }

            public final Observable<Model> get(long guildId, Observable<String> filterPublisher) {
                Intrinsics3.checkNotNullParameter(filterPublisher, "filterPublisher");
                Observable observableY = getCanManageBans(guildId).Y(new WidgetServerSettingsBans3(guildId, filterPublisher));
                Intrinsics3.checkNotNullExpressionValue(observableY, "getCanManageBans(guildId….just(null)\n            }");
                return observableY;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(int i, List<BanItem> list, long j, String str, boolean z2) {
            this.totalBannedUsers = i;
            this.filteredBannedUsers = list;
            this.guildId = j;
            this.guildName = str;
            this.isLoading = z2;
        }

        public static final /* synthetic */ ArrayList access$getEmptyBansList$cp() {
            return emptyBansList;
        }

        public static /* synthetic */ Model copy$default(Model model, int i, List list, long j, String str, boolean z2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = model.totalBannedUsers;
            }
            if ((i2 & 2) != 0) {
                list = model.filteredBannedUsers;
            }
            List list2 = list;
            if ((i2 & 4) != 0) {
                j = model.guildId;
            }
            long j2 = j;
            if ((i2 & 8) != 0) {
                str = model.guildName;
            }
            String str2 = str;
            if ((i2 & 16) != 0) {
                z2 = model.isLoading;
            }
            return model.copy(i, list2, j2, str2, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final int getTotalBannedUsers() {
            return this.totalBannedUsers;
        }

        public final List<BanItem> component2() {
            return this.filteredBannedUsers;
        }

        /* renamed from: component3, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        /* renamed from: component4, reason: from getter */
        public final String getGuildName() {
            return this.guildName;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        public final Model copy(int totalBannedUsers, List<BanItem> filteredBannedUsers, long guildId, String guildName, boolean isLoading) {
            return new Model(totalBannedUsers, filteredBannedUsers, guildId, guildName, isLoading);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return this.totalBannedUsers == model.totalBannedUsers && Intrinsics3.areEqual(this.filteredBannedUsers, model.filteredBannedUsers) && this.guildId == model.guildId && Intrinsics3.areEqual(this.guildName, model.guildName) && this.isLoading == model.isLoading;
        }

        public final List<BanItem> getFilteredBannedUsers() {
            return this.filteredBannedUsers;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final String getGuildName() {
            return this.guildName;
        }

        public final int getTotalBannedUsers() {
            return this.totalBannedUsers;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int i = this.totalBannedUsers * 31;
            List<BanItem> list = this.filteredBannedUsers;
            int iA = (b.a(this.guildId) + ((i + (list != null ? list.hashCode() : 0)) * 31)) * 31;
            String str = this.guildName;
            int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
            boolean z2 = this.isLoading;
            int i2 = z2;
            if (z2 != 0) {
                i2 = 1;
            }
            return iHashCode + i2;
        }

        public final boolean isLoading() {
            return this.isLoading;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(totalBannedUsers=");
            sbU.append(this.totalBannedUsers);
            sbU.append(", filteredBannedUsers=");
            sbU.append(this.filteredBannedUsers);
            sbU.append(", guildId=");
            sbU.append(this.guildId);
            sbU.append(", guildName=");
            sbU.append(this.guildName);
            sbU.append(", isLoading=");
            return outline.O(sbU, this.isLoading, ")");
        }

        /* compiled from: WidgetServerSettingsBans.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001e\u0010\u001aJ\u0015\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\u0005J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u00020\f8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u000eR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u00020\t8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsBans$Model$BanItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "Lcom/discord/models/domain/ModelBan;", "ban", "create", "(Lcom/discord/models/domain/ModelBan;)Lcom/discord/widgets/servers/WidgetServerSettingsBans$Model$BanItem;", "component1", "()Lcom/discord/models/domain/ModelBan;", "copy", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "type", "I", "getType", "Lcom/discord/models/domain/ModelBan;", "getBan", "setBan", "(Lcom/discord/models/domain/ModelBan;)V", "key", "Ljava/lang/String;", "getKey", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class BanItem implements MGRecyclerDataPayload {
            private ModelBan ban;
            private final String key;
            private final int type;

            public BanItem() {
                this(null, 1, null);
            }

            public BanItem(ModelBan modelBan) {
                User user;
                this.ban = modelBan;
                this.type = 1;
                this.key = String.valueOf((modelBan == null || (user = modelBan.getUser()) == null) ? null : Long.valueOf(user.getId()));
            }

            public static /* synthetic */ BanItem copy$default(BanItem banItem, ModelBan modelBan, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelBan = banItem.ban;
                }
                return banItem.copy(modelBan);
            }

            /* renamed from: component1, reason: from getter */
            public final ModelBan getBan() {
                return this.ban;
            }

            public final BanItem copy(ModelBan ban) {
                return new BanItem(ban);
            }

            public final BanItem create(ModelBan ban) {
                Intrinsics3.checkNotNullParameter(ban, "ban");
                BanItem banItem = new BanItem(null, 1, null);
                banItem.ban = ban;
                return banItem;
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof BanItem) && Intrinsics3.areEqual(this.ban, ((BanItem) other).ban);
                }
                return true;
            }

            public final ModelBan getBan() {
                return this.ban;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            public int hashCode() {
                ModelBan modelBan = this.ban;
                if (modelBan != null) {
                    return modelBan.hashCode();
                }
                return 0;
            }

            public final void setBan(ModelBan modelBan) {
                this.ban = modelBan;
            }

            public String toString() {
                StringBuilder sbU = outline.U("BanItem(ban=");
                sbU.append(this.ban);
                sbU.append(")");
                return sbU.toString();
            }

            public /* synthetic */ BanItem(ModelBan modelBan, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : modelBan);
            }
        }
    }
}
