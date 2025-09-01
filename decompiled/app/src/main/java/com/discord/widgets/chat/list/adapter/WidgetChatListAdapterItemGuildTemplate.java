package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.WidgetChatListAdapterItemGuildTemplateBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelGuildTemplate;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.GuildTemplateEntry;
import com.discord.widgets.guilds.create.WidgetGuildClone;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002()B\u000f\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\bJ\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0014¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006*"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildTemplate;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListItem;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildTemplate$Model;", "model", "", "configureUI", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildTemplate$Model;)V", "configureLoadingUI", "()V", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildTemplate$Model$Resolved;", "configureResolvedUI", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildTemplate$Model$Resolved;)V", "configureInvalidUI", "Landroid/content/Context;", "context", "Lcom/discord/models/domain/ModelGuildTemplate;", "guildTemplate", "openGuildTemplate", "(Landroid/content/Context;Lcom/discord/models/domain/ModelGuildTemplate;)V", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "data", "onConfigure", "(ILcom/discord/widgets/chat/list/entries/ChatListEntry;)V", "Lrx/Subscription;", "getSubscription", "()Lrx/Subscription;", "Lcom/discord/widgets/chat/list/entries/GuildTemplateEntry;", "item", "Lcom/discord/widgets/chat/list/entries/GuildTemplateEntry;", "Lcom/discord/databinding/WidgetChatListAdapterItemGuildTemplateBinding;", "binding", "Lcom/discord/databinding/WidgetChatListAdapterItemGuildTemplateBinding;", Traits.Payment.Type.SUBSCRIPTION, "Lrx/Subscription;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "adapter", "<init>", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;)V", ExifInterface.TAG_MODEL, "ModelProvider", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGuildTemplate extends WidgetChatListItem {
    private final WidgetChatListAdapterItemGuildTemplateBinding binding;
    private GuildTemplateEntry item;
    private Subscription subscription;

    /* compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildTemplate$Model;", "", "<init>", "()V", "Invalid", "Loading", "Resolved", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildTemplate$Model$Loading;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildTemplate$Model$Resolved;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildTemplate$Model$Invalid;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Model {

        /* compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildTemplate$Model$Invalid;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildTemplate$Model;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends Model {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildTemplate$Model$Loading;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildTemplate$Model;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends Model {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildTemplate$Model$Resolved;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildTemplate$Model;", "Lcom/discord/models/domain/ModelGuildTemplate;", "component1", "()Lcom/discord/models/domain/ModelGuildTemplate;", "guildTemplate", "copy", "(Lcom/discord/models/domain/ModelGuildTemplate;)Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildTemplate$Model$Resolved;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/domain/ModelGuildTemplate;", "getGuildTemplate", "<init>", "(Lcom/discord/models/domain/ModelGuildTemplate;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Resolved extends Model {
            private final ModelGuildTemplate guildTemplate;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Resolved(ModelGuildTemplate modelGuildTemplate) {
                super(null);
                Intrinsics3.checkNotNullParameter(modelGuildTemplate, "guildTemplate");
                this.guildTemplate = modelGuildTemplate;
            }

            public static /* synthetic */ Resolved copy$default(Resolved resolved, ModelGuildTemplate modelGuildTemplate, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelGuildTemplate = resolved.guildTemplate;
                }
                return resolved.copy(modelGuildTemplate);
            }

            /* renamed from: component1, reason: from getter */
            public final ModelGuildTemplate getGuildTemplate() {
                return this.guildTemplate;
            }

            public final Resolved copy(ModelGuildTemplate guildTemplate) {
                Intrinsics3.checkNotNullParameter(guildTemplate, "guildTemplate");
                return new Resolved(guildTemplate);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Resolved) && Intrinsics3.areEqual(this.guildTemplate, ((Resolved) other).guildTemplate);
                }
                return true;
            }

            public final ModelGuildTemplate getGuildTemplate() {
                return this.guildTemplate;
            }

            public int hashCode() {
                ModelGuildTemplate modelGuildTemplate = this.guildTemplate;
                if (modelGuildTemplate != null) {
                    return modelGuildTemplate.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Resolved(guildTemplate=");
                sbU.append(this.guildTemplate);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private Model() {
        }

        public /* synthetic */ Model(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildTemplate$ModelProvider;", "", "Lcom/discord/widgets/chat/list/entries/GuildTemplateEntry;", "item", "Lrx/Observable;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildTemplate$Model;", "get", "(Lcom/discord/widgets/chat/list/entries/GuildTemplateEntry;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ModelProvider {
        public static final ModelProvider INSTANCE = new ModelProvider();

        private ModelProvider() {
        }

        public final Observable<Model> get(GuildTemplateEntry item) {
            Intrinsics3.checkNotNullParameter(item, "item");
            Observable observableY = StoreStream.INSTANCE.getGuildTemplates().observeGuildTemplate(item.getGuildTemplateCode()).v(new WidgetChatListAdapterItemGuildTemplate2(item)).Y(WidgetChatListAdapterItemGuildTemplate3.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n        .get…tes\n          }\n        }");
            return observableY;
        }
    }

    /* compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildTemplate$configureResolvedUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ ModelGuildTemplate $guildTemplate;

        public AnonymousClass1(ModelGuildTemplate modelGuildTemplate) {
            this.$guildTemplate = modelGuildTemplate;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListAdapterItemGuildTemplate.access$openGuildTemplate(WidgetChatListAdapterItemGuildTemplate.this, outline.x(view, "it", "it.context"), this.$guildTemplate);
        }
    }

    /* compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildTemplate$Model;", "p1", "", "invoke", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildTemplate$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildTemplate$onConfigure$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetChatListAdapterItemGuildTemplate widgetChatListAdapterItemGuildTemplate) {
            super(1, widgetChatListAdapterItemGuildTemplate, WidgetChatListAdapterItemGuildTemplate.class, "configureUI", "configureUI(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildTemplate$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "p1");
            WidgetChatListAdapterItemGuildTemplate.access$configureUI((WidgetChatListAdapterItemGuildTemplate) this.receiver, model);
        }
    }

    /* compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildTemplate$onConfigure$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetChatListAdapterItemGuildTemplate.access$configureInvalidUI(WidgetChatListAdapterItemGuildTemplate.this);
        }
    }

    /* compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", "it", "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildTemplate$onConfigure$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            WidgetChatListAdapterItemGuildTemplate.access$setSubscription$p(WidgetChatListAdapterItemGuildTemplate.this, subscription);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemGuildTemplate(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_guild_template, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R.id.item_guild_template_header;
        TextView textView = (TextView) view.findViewById(R.id.item_guild_template_header);
        if (textView != null) {
            i = R.id.item_guild_template_image;
            ImageView imageView = (ImageView) view.findViewById(R.id.item_guild_template_image);
            if (imageView != null) {
                i = R.id.item_guild_template_join_button;
                MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.item_guild_template_join_button);
                if (materialButton != null) {
                    i = R.id.item_guild_template_name;
                    TextView textView2 = (TextView) view.findViewById(R.id.item_guild_template_name);
                    if (textView2 != null) {
                        i = R.id.item_guild_template_subtext;
                        TextView textView3 = (TextView) view.findViewById(R.id.item_guild_template_subtext);
                        if (textView3 != null) {
                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                            WidgetChatListAdapterItemGuildTemplateBinding widgetChatListAdapterItemGuildTemplateBinding = new WidgetChatListAdapterItemGuildTemplateBinding(constraintLayout, textView, imageView, materialButton, textView2, textView3, constraintLayout);
                            Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemGuildTemplateBinding, "WidgetChatListAdapterIte…ateBinding.bind(itemView)");
                            this.binding = widgetChatListAdapterItemGuildTemplateBinding;
                            return;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ void access$configureInvalidUI(WidgetChatListAdapterItemGuildTemplate widgetChatListAdapterItemGuildTemplate) {
        widgetChatListAdapterItemGuildTemplate.configureInvalidUI();
    }

    public static final /* synthetic */ void access$configureUI(WidgetChatListAdapterItemGuildTemplate widgetChatListAdapterItemGuildTemplate, Model model) {
        widgetChatListAdapterItemGuildTemplate.configureUI(model);
    }

    public static final /* synthetic */ Subscription access$getSubscription$p(WidgetChatListAdapterItemGuildTemplate widgetChatListAdapterItemGuildTemplate) {
        return widgetChatListAdapterItemGuildTemplate.subscription;
    }

    public static final /* synthetic */ void access$openGuildTemplate(WidgetChatListAdapterItemGuildTemplate widgetChatListAdapterItemGuildTemplate, Context context, ModelGuildTemplate modelGuildTemplate) {
        widgetChatListAdapterItemGuildTemplate.openGuildTemplate(context, modelGuildTemplate);
    }

    public static final /* synthetic */ void access$setSubscription$p(WidgetChatListAdapterItemGuildTemplate widgetChatListAdapterItemGuildTemplate, Subscription subscription) {
        widgetChatListAdapterItemGuildTemplate.subscription = subscription;
    }

    private final void configureInvalidUI() {
        this.binding.c.setText(R.string.guild_template_invalid_title);
        this.binding.d.setText(R.string.guild_template_invalid_subtitle);
        TextView textView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemGuildTemplateSubtext");
        textView.setVisibility(0);
        MaterialButton materialButton = this.binding.f2323b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.itemGuildTemplateJoinButton");
        materialButton.setVisibility(8);
    }

    private final void configureLoadingUI() {
        this.binding.c.setText(R.string.guild_template_resolving_title);
        TextView textView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemGuildTemplateSubtext");
        textView.setVisibility(8);
        MaterialButton materialButton = this.binding.f2323b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.itemGuildTemplateJoinButton");
        materialButton.setVisibility(8);
    }

    private final void configureResolvedUI(Model.Resolved model) {
        ModelGuildTemplate guildTemplate = model.getGuildTemplate();
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemGuildTemplateName");
        textView.setText(guildTemplate.getName());
        TextView textView2 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.itemGuildTemplateSubtext");
        ViewExtensions.setTextAndVisibilityBy(textView2, StringResourceUtils.getI18nPluralString(outline.I(this.binding.d, "binding.itemGuildTemplateSubtext", "binding.itemGuildTemplateSubtext.context"), R.plurals.guild_template_usages_usageCount, guildTemplate.getUsageCount(), Integer.valueOf(guildTemplate.getUsageCount())));
        MaterialButton materialButton = this.binding.f2323b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.itemGuildTemplateJoinButton");
        materialButton.setVisibility(0);
        this.binding.f2323b.setOnClickListener(new AnonymousClass1(guildTemplate));
    }

    private final void configureUI(Model model) {
        if (model instanceof Model.Loading) {
            configureLoadingUI();
        } else if (model instanceof Model.Resolved) {
            configureResolvedUI((Model.Resolved) model);
        } else {
            if (!(model instanceof Model.Invalid)) {
                throw new NoWhenBranchMatchedException();
            }
            configureInvalidUI();
        }
    }

    private final void openGuildTemplate(Context context, ModelGuildTemplate guildTemplate) {
        WidgetGuildClone.INSTANCE.show(context, guildTemplate.getCode(), "Guild Template Embed");
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public Subscription getSubscription() {
        return this.subscription;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        GuildTemplateEntry guildTemplateEntry = (GuildTemplateEntry) data;
        this.item = guildTemplateEntry;
        ModelProvider modelProvider = ModelProvider.INSTANCE;
        if (guildTemplateEntry == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("item");
        }
        Observable observableUi = ObservableExtensionsKt.ui(modelProvider.get(guildTemplateEntry));
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this);
        ObservableExtensionsKt.appSubscribe$default(observableUi, WidgetChatListAdapterItemGuildTemplate.class, (Context) null, new AnonymousClass3(), new AnonymousClass2(), (Function0) null, (Function0) null, anonymousClass1, 50, (Object) null);
    }
}
