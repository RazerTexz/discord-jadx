package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.a.d.o;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsEmojisBinding;
import com.discord.databinding.WidgetServerSettingsEmojisHeaderBinding;
import com.discord.databinding.WidgetServerSettingsEmojisItemBinding;
import com.discord.databinding.WidgetServerSettingsEmojisSectionBinding;
import com.discord.dialogs.ImageUploadDialog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.domain.emoji.ModelEmojiGuild;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.CoreUser;
import com.discord.models.user.User;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreEmojiGuild;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.view.extensions.ImageViewExtensions;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.servers.WidgetServerSettingsEmojisEdit;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.g0.StringsJVM;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action1;

/* compiled from: WidgetServerSettingsEmojis.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 72\u00020\u0001:\u0004879:B\u0007¢\u0006\u0004\b6\u0010\u0019J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u0019J\u001f\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010 \u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\rH\u0016¢\u0006\u0004\b \u0010\u001fR\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\"\u0010#R\u001c\u0010%\u001a\u00020$8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001d\u0010.\u001a\u00020)8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001e\u00100\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u001a\u00104\u001a\u000602j\u0002`38\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105¨\u0006;"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsEmojis;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Model;", "model", "", "configureUI", "(Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Model;)V", "Landroid/view/View;", "v", "Lcom/discord/models/domain/emoji/ModelEmojiGuild;", "emoji", "launchEditScreen", "(Landroid/view/View;Lcom/discord/models/domain/emoji/ModelEmojiGuild;)V", "", ModelAuditLogEntry.CHANGE_KEY_NAME, "imageBase64", "uploadEmoji", "(Ljava/lang/String;Ljava/lang/String;)V", "guildName", "configureToolbar", "(Ljava/lang/String;)V", "view", "onViewBound", "(Landroid/view/View;)V", "onPause", "()V", "onViewBoundOrOnResume", "Landroid/net/Uri;", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "mimeType", "onImageChosen", "(Landroid/net/Uri;Ljava/lang/String;)V", "onImageCropped", "Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Adapter;", "adapter", "Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Adapter;", "Lcom/discord/app/LoggingConfig;", "loggingConfig", "Lcom/discord/app/LoggingConfig;", "getLoggingConfig", "()Lcom/discord/app/LoggingConfig;", "Lcom/discord/databinding/WidgetServerSettingsEmojisBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetServerSettingsEmojisBinding;", "binding", "Lrx/functions/Action1;", "uploadEmojiAction", "Lrx/functions/Action1;", "", "Lcom/discord/primitives/GuildId;", "guildId", "J", "<init>", "Companion", "Adapter", "Item", ExifInterface.TAG_MODEL, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsEmojis extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsEmojis.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsEmojisBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int EMOJI_MAX_FILESIZE_KB = 256;
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final int VIEW_INDEX_CONTENT = 1;
    private Adapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private long guildId;
    private final AppLogger2 loggingConfig;
    private Action1<String> uploadEmojiAction;

    /* compiled from: WidgetServerSettingsEmojis.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u001f !\"B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ+\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR4\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R(\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006#"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Adapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Item;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lkotlin/Function2;", "Landroid/view/View;", "Lcom/discord/models/domain/emoji/ModelEmojiGuild;", "", "onEmojiItemClicked", "Lkotlin/jvm/functions/Function2;", "getOnEmojiItemClicked", "()Lkotlin/jvm/functions/Function2;", "setOnEmojiItemClicked", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/Function0;", "onUploadEmoji", "Lkotlin/jvm/functions/Function0;", "getOnUploadEmoji", "()Lkotlin/jvm/functions/Function0;", "setOnUploadEmoji", "(Lkotlin/jvm/functions/Function0;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "EmojiEmptyViewHolder", "EmojiHeaderViewHolder", "EmojiItemViewHolder", "EmojiSectionViewHolder", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Adapter extends MGRecyclerAdapterSimple<Item> {
        private Function2<? super View, ? super ModelEmojiGuild, Unit> onEmojiItemClicked;
        private Function0<Unit> onUploadEmoji;

        /* compiled from: WidgetServerSettingsEmojis.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Adapter$EmojiEmptyViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Adapter;", "Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Item;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/servers/WidgetServerSettingsEmojis$Item;)V", "adapter", "<init>", "(Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Adapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class EmojiEmptyViewHolder extends MGRecyclerViewHolder<Adapter, Item> {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EmojiEmptyViewHolder(Adapter adapter) {
                super(R.layout.widget_server_settings_emojis_empty, adapter);
                Intrinsics3.checkNotNullParameter(adapter, "adapter");
            }

            /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
            public void onConfigure2(int position, Item data) {
                Intrinsics3.checkNotNullParameter(data, "data");
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            public /* bridge */ /* synthetic */ void onConfigure(int i, Item item) {
                onConfigure2(i, item);
            }
        }

        /* compiled from: WidgetServerSettingsEmojis.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Adapter$EmojiHeaderViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Adapter;", "Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Item;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/servers/WidgetServerSettingsEmojis$Item;)V", "Lcom/discord/databinding/WidgetServerSettingsEmojisHeaderBinding;", "binding", "Lcom/discord/databinding/WidgetServerSettingsEmojisHeaderBinding;", "adapter", "<init>", "(Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Adapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class EmojiHeaderViewHolder extends MGRecyclerViewHolder<Adapter, Item> {
            private final WidgetServerSettingsEmojisHeaderBinding binding;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EmojiHeaderViewHolder(Adapter adapter) {
                super(R.layout.widget_server_settings_emojis_header, adapter);
                Intrinsics3.checkNotNullParameter(adapter, "adapter");
                View view = this.itemView;
                int i = R.id.widget_server_settings_emojis_upload;
                MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.widget_server_settings_emojis_upload);
                if (materialButton != null) {
                    i = R.id.widget_server_settings_emojis_upload_description;
                    TextView textView = (TextView) view.findViewById(R.id.widget_server_settings_emojis_upload_description);
                    if (textView != null) {
                        WidgetServerSettingsEmojisHeaderBinding widgetServerSettingsEmojisHeaderBinding = new WidgetServerSettingsEmojisHeaderBinding((LinearLayout) view, materialButton, textView);
                        Intrinsics3.checkNotNullExpressionValue(widgetServerSettingsEmojisHeaderBinding, "WidgetServerSettingsEmoj…derBinding.bind(itemView)");
                        this.binding = widgetServerSettingsEmojisHeaderBinding;
                        return;
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
            }

            public static final /* synthetic */ Adapter access$getAdapter$p(EmojiHeaderViewHolder emojiHeaderViewHolder) {
                return (Adapter) emojiHeaderViewHolder.adapter;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            public /* bridge */ /* synthetic */ void onConfigure(int i, Item item) {
                onConfigure2(i, item);
            }

            /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
            public void onConfigure2(int position, Item data) {
                Intrinsics3.checkNotNullParameter(data, "data");
                TextView textView = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.widgetServerSett…gsEmojisUploadDescription");
                textView.setText(FormatUtils.h(outline.x(this.itemView, "itemView", "itemView.context"), R.string.guild_settings_emoji_upload_to_server_message, new Object[]{String.valueOf(((Item.EmojiHeader) data).getEmojiMax()), String.valueOf(256)}, null, 4));
                this.binding.f2564b.setOnClickListener(new WidgetServerSettingsEmojis$Adapter$EmojiHeaderViewHolder$onConfigure$1(this));
            }
        }

        /* compiled from: WidgetServerSettingsEmojis.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Adapter$EmojiItemViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Adapter;", "Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Item;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/servers/WidgetServerSettingsEmojis$Item;)V", "Lcom/discord/databinding/WidgetServerSettingsEmojisItemBinding;", "binding", "Lcom/discord/databinding/WidgetServerSettingsEmojisItemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Adapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class EmojiItemViewHolder extends MGRecyclerViewHolder<Adapter, Item> {
            private final WidgetServerSettingsEmojisItemBinding binding;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EmojiItemViewHolder(Adapter adapter) {
                super(R.layout.widget_server_settings_emojis_item, adapter);
                Intrinsics3.checkNotNullParameter(adapter, "adapter");
                View view = this.itemView;
                int i = R.id.server_settings_emojis_avatar;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.server_settings_emojis_avatar);
                if (simpleDraweeView != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i = R.id.server_settings_emojis_name;
                    TextView textView = (TextView) view.findViewById(R.id.server_settings_emojis_name);
                    if (textView != null) {
                        i = R.id.server_settings_emojis_nickname;
                        TextView textView2 = (TextView) view.findViewById(R.id.server_settings_emojis_nickname);
                        if (textView2 != null) {
                            i = R.id.server_settings_emojis_overflow;
                            ImageView imageView = (ImageView) view.findViewById(R.id.server_settings_emojis_overflow);
                            if (imageView != null) {
                                i = R.id.server_settings_emojis_username;
                                TextView textView3 = (TextView) view.findViewById(R.id.server_settings_emojis_username);
                                if (textView3 != null) {
                                    i = R.id.server_settings_emojis_username_avatar;
                                    SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) view.findViewById(R.id.server_settings_emojis_username_avatar);
                                    if (simpleDraweeView2 != null) {
                                        WidgetServerSettingsEmojisItemBinding widgetServerSettingsEmojisItemBinding = new WidgetServerSettingsEmojisItemBinding(constraintLayout, simpleDraweeView, constraintLayout, textView, textView2, imageView, textView3, simpleDraweeView2);
                                        Intrinsics3.checkNotNullExpressionValue(widgetServerSettingsEmojisItemBinding, "WidgetServerSettingsEmoj…temBinding.bind(itemView)");
                                        this.binding = widgetServerSettingsEmojisItemBinding;
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
            }

            public static final /* synthetic */ Adapter access$getAdapter$p(EmojiItemViewHolder emojiItemViewHolder) {
                return (Adapter) emojiItemViewHolder.adapter;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            public /* bridge */ /* synthetic */ void onConfigure(int i, Item item) {
                onConfigure2(i, item);
            }

            /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
            public void onConfigure2(int position, Item data) {
                Intrinsics3.checkNotNullParameter(data, "data");
                super.onConfigure(position, (int) data);
                Item.EmojiItem emojiItem = (Item.EmojiItem) data;
                TextView textView = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.serverSettingsEmojisName");
                textView.setText(emojiItem.getEmoji().getName());
                TextView textView2 = this.binding.f;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.serverSettingsEmojisUsername");
                textView2.setText(UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, emojiItem.getUser(), null, null, 3, null));
                GuildMember guildMember = emojiItem.getGuildMember();
                String nick = guildMember != null ? guildMember.getNick() : null;
                TextView textView3 = this.binding.e;
                Intrinsics3.checkNotNullExpressionValue(textView3, "binding.serverSettingsEmojisNickname");
                ViewExtensions.setTextAndVisibilityBy(textView3, nick);
                SimpleDraweeView simpleDraweeView = this.binding.g;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.serverSettingsEmojisUsernameAvatar");
                IconUtils.setIcon$default(simpleDraweeView, new CoreUser(emojiItem.getEmoji().getUser()), R.dimen.avatar_size_standard, null, null, guildMember, 24, null);
                String imageUri = ModelEmojiCustom.getImageUri(emojiItem.getEmoji().getId(), emojiItem.getEmoji().getAnimated(), 64);
                SimpleDraweeView simpleDraweeView2 = this.binding.f2565b;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.serverSettingsEmojisAvatar");
                MGImages.setImage$default(simpleDraweeView2, imageUri, R.dimen.emoji_size, R.dimen.emoji_size, true, null, null, 96, null);
                SimpleDraweeView simpleDraweeView3 = this.binding.f2565b;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.serverSettingsEmojisAvatar");
                ImageViewExtensions.setGrayscale(simpleDraweeView3, !emojiItem.getEmoji().getAvailable());
                SimpleDraweeView simpleDraweeView4 = this.binding.f2565b;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView4, "binding.serverSettingsEmojisAvatar");
                simpleDraweeView4.setImageAlpha(emojiItem.getEmoji().getAvailable() ? 255 : 100);
                this.binding.c.setOnClickListener(new WidgetServerSettingsEmojis$Adapter$EmojiItemViewHolder$onConfigure$1(this, data));
            }
        }

        /* compiled from: WidgetServerSettingsEmojis.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Adapter$EmojiSectionViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Adapter;", "Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Item;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/servers/WidgetServerSettingsEmojis$Item;)V", "Lcom/discord/databinding/WidgetServerSettingsEmojisSectionBinding;", "binding", "Lcom/discord/databinding/WidgetServerSettingsEmojisSectionBinding;", "adapter", "<init>", "(Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Adapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class EmojiSectionViewHolder extends MGRecyclerViewHolder<Adapter, Item> {
            private final WidgetServerSettingsEmojisSectionBinding binding;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EmojiSectionViewHolder(Adapter adapter) {
                super(R.layout.widget_server_settings_emojis_section, adapter);
                Intrinsics3.checkNotNullParameter(adapter, "adapter");
                View view = this.itemView;
                TextView textView = (TextView) view.findViewById(R.id.widget_server_settings_emojis_section);
                if (textView == null) {
                    throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.widget_server_settings_emojis_section)));
                }
                WidgetServerSettingsEmojisSectionBinding widgetServerSettingsEmojisSectionBinding = new WidgetServerSettingsEmojisSectionBinding((LinearLayout) view, textView);
                Intrinsics3.checkNotNullExpressionValue(widgetServerSettingsEmojisSectionBinding, "WidgetServerSettingsEmoj…ionBinding.bind(itemView)");
                this.binding = widgetServerSettingsEmojisSectionBinding;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            public /* bridge */ /* synthetic */ void onConfigure(int i, Item item) throws Resources.NotFoundException {
                onConfigure2(i, item);
            }

            /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
            public void onConfigure2(int position, Item data) throws Resources.NotFoundException {
                Intrinsics3.checkNotNullParameter(data, "data");
                super.onConfigure(position, (int) data);
                Item.EmojiSection emojiSection = (Item.EmojiSection) data;
                int emojiMax = emojiSection.getEmojiMax() - emojiSection.getEmojiLength();
                View view = this.itemView;
                Intrinsics3.checkNotNullExpressionValue(view, "itemView");
                Context context = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "itemView.context");
                Resources resources = context.getResources();
                Intrinsics3.checkNotNullExpressionValue(resources, "itemView.context.resources");
                CharSequence charSequenceH = FormatUtils.h(outline.x(this.itemView, "itemView", "itemView.context"), R.string.emoji_slots_available, new Object[]{StringResourceUtils.getQuantityString(resources, outline.x(this.itemView, "itemView", "itemView.context"), R.plurals.emoji_slots_available_count, emojiMax, Integer.valueOf(emojiMax))}, null, 4);
                TextView textView = this.binding.f2566b;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.widgetServerSettingsEmojisSection");
                textView.setText(FormatUtils.h(outline.x(this.itemView, "itemView", "itemView.context"), R.string.emoji_section, new Object[]{FormatUtils.h(outline.x(this.itemView, "itemView", "itemView.context"), emojiSection.getTitleId(), new Object[0], null, 4), charSequenceH}, null, 4));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Adapter(RecyclerView recyclerView) {
            super(recyclerView, false, 2, null);
            Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
            this.onUploadEmoji = WidgetServerSettingsEmojis$Adapter$onUploadEmoji$1.INSTANCE;
            this.onEmojiItemClicked = WidgetServerSettingsEmojis$Adapter$onEmojiItemClicked$1.INSTANCE;
        }

        public final Function2<View, ModelEmojiGuild, Unit> getOnEmojiItemClicked() {
            return this.onEmojiItemClicked;
        }

        public final Function0<Unit> getOnUploadEmoji() {
            return this.onUploadEmoji;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return onCreateViewHolder(viewGroup, i);
        }

        public final void setOnEmojiItemClicked(Function2<? super View, ? super ModelEmojiGuild, Unit> function2) {
            Intrinsics3.checkNotNullParameter(function2, "<set-?>");
            this.onEmojiItemClicked = function2;
        }

        public final void setOnUploadEmoji(Function0<Unit> function0) {
            Intrinsics3.checkNotNullParameter(function0, "<set-?>");
            this.onUploadEmoji = function0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MGRecyclerViewHolder<Adapter, Item> onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            if (viewType == 0) {
                return new EmojiItemViewHolder(this);
            }
            if (viewType == 1) {
                return new EmojiSectionViewHolder(this);
            }
            if (viewType == 2) {
                return new EmojiHeaderViewHolder(this);
            }
            if (viewType == 3) {
                return new EmojiEmptyViewHolder(this);
            }
            throw invalidViewTypeException(viewType);
        }
    }

    /* compiled from: WidgetServerSettingsEmojis.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Companion;", "", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "create", "(Landroid/content/Context;J)V", "", "EMOJI_MAX_FILESIZE_KB", "I", "", "INTENT_EXTRA_GUILD_ID", "Ljava/lang/String;", "VIEW_INDEX_CONTENT", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            StoreStream.INSTANCE.getAnalytics().onGuildSettingsPaneViewed("EMOJIS", guildId);
            AppScreen2.d(context, WidgetServerSettingsEmojis.class, new Intent().putExtra("INTENT_EXTRA_GUILD_ID", guildId));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsEmojis.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00042\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\t\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Item;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "<init>", "()V", "Companion", "EmojiEmpty", "EmojiHeader", "EmojiItem", "EmojiSection", "Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Item$EmojiItem;", "Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Item$EmojiSection;", "Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Item$EmojiHeader;", "Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Item$EmojiEmpty;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Item implements MGRecyclerDataPayload {
        public static final int TYPE_EMOJI = 0;
        public static final int TYPE_EMPTY = 3;
        public static final int TYPE_HEADER = 2;
        public static final int TYPE_SECTION = 1;

        /* compiled from: WidgetServerSettingsEmojis.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Item$EmojiEmpty;", "Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Item;", "", "type", "I", "getType", "()I", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class EmojiEmpty extends Item {
            public static final EmojiEmpty INSTANCE = new EmojiEmpty();
            private static final int type = 3;
            private static final String key = "EMOJI_EMPTY";

            private EmojiEmpty() {
                super(null);
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return key;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return type;
            }
        }

        /* compiled from: WidgetServerSettingsEmojis.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\u00028\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004R\u001c\u0010\u0015\u001a\u00020\b8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Item$EmojiHeader;", "Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Item;", "", "component1", "()I", "emojiMax", "copy", "(I)Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Item$EmojiHeader;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "type", "I", "getType", "getEmojiMax", "key", "Ljava/lang/String;", "getKey", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class EmojiHeader extends Item {
            private final int emojiMax;
            private final String key;
            private final int type;

            public EmojiHeader(int i) {
                super(null);
                this.emojiMax = i;
                this.type = 2;
                this.key = "EMOJI_HEADER";
            }

            public static /* synthetic */ EmojiHeader copy$default(EmojiHeader emojiHeader, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = emojiHeader.emojiMax;
                }
                return emojiHeader.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getEmojiMax() {
                return this.emojiMax;
            }

            public final EmojiHeader copy(int emojiMax) {
                return new EmojiHeader(emojiMax);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof EmojiHeader) && this.emojiMax == ((EmojiHeader) other).emojiMax;
                }
                return true;
            }

            public final int getEmojiMax() {
                return this.emojiMax;
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
                return this.emojiMax;
            }

            public String toString() {
                return outline.B(outline.U("EmojiHeader(emojiMax="), this.emojiMax, ")");
            }
        }

        /* compiled from: WidgetServerSettingsEmojis.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u0000 )2\u00020\u0001:\u0001)B!\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b \u0010\nR\u001c\u0010!\u001a\u00020\u00108\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0012R\u001c\u0010$\u001a\u00020\u00138\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u0015¨\u0006*"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Item$EmojiItem;", "Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Item;", "Lcom/discord/models/domain/emoji/ModelEmojiGuild;", "component1", "()Lcom/discord/models/domain/emoji/ModelEmojiGuild;", "Lcom/discord/models/user/User;", "component2", "()Lcom/discord/models/user/User;", "Lcom/discord/models/member/GuildMember;", "component3", "()Lcom/discord/models/member/GuildMember;", "emoji", "user", "guildMember", "copy", "(Lcom/discord/models/domain/emoji/ModelEmojiGuild;Lcom/discord/models/user/User;Lcom/discord/models/member/GuildMember;)Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Item$EmojiItem;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/domain/emoji/ModelEmojiGuild;", "getEmoji", "Lcom/discord/models/user/User;", "getUser", "Lcom/discord/models/member/GuildMember;", "getGuildMember", "key", "Ljava/lang/String;", "getKey", "type", "I", "getType", "<init>", "(Lcom/discord/models/domain/emoji/ModelEmojiGuild;Lcom/discord/models/user/User;Lcom/discord/models/member/GuildMember;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class EmojiItem extends Item {

            /* renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final ModelEmojiGuild emoji;
            private final GuildMember guildMember;
            private final String key;
            private final int type;
            private final User user;

            /* compiled from: WidgetServerSettingsEmojis.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ-\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Item$EmojiItem$Companion;", "", "Lcom/discord/models/domain/emoji/ModelEmojiGuild;", "emoji", "", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "guildMembers", "Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Item$EmojiItem;", "from", "(Lcom/discord/models/domain/emoji/ModelEmojiGuild;Ljava/util/Map;)Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Item$EmojiItem;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
            public static final class Companion {
                private Companion() {
                }

                public final EmojiItem from(ModelEmojiGuild emoji, Map<Long, GuildMember> guildMembers) {
                    Intrinsics3.checkNotNullParameter(emoji, "emoji");
                    Intrinsics3.checkNotNullParameter(guildMembers, "guildMembers");
                    CoreUser coreUser = new CoreUser(emoji.getUser());
                    return new EmojiItem(emoji, coreUser, guildMembers.get(Long.valueOf(coreUser.getId())));
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EmojiItem(ModelEmojiGuild modelEmojiGuild, User user, GuildMember guildMember) {
                super(null);
                Intrinsics3.checkNotNullParameter(modelEmojiGuild, "emoji");
                Intrinsics3.checkNotNullParameter(user, "user");
                this.emoji = modelEmojiGuild;
                this.user = user;
                this.guildMember = guildMember;
                this.key = String.valueOf(modelEmojiGuild.getId());
            }

            public static /* synthetic */ EmojiItem copy$default(EmojiItem emojiItem, ModelEmojiGuild modelEmojiGuild, User user, GuildMember guildMember, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelEmojiGuild = emojiItem.emoji;
                }
                if ((i & 2) != 0) {
                    user = emojiItem.user;
                }
                if ((i & 4) != 0) {
                    guildMember = emojiItem.guildMember;
                }
                return emojiItem.copy(modelEmojiGuild, user, guildMember);
            }

            /* renamed from: component1, reason: from getter */
            public final ModelEmojiGuild getEmoji() {
                return this.emoji;
            }

            /* renamed from: component2, reason: from getter */
            public final User getUser() {
                return this.user;
            }

            /* renamed from: component3, reason: from getter */
            public final GuildMember getGuildMember() {
                return this.guildMember;
            }

            public final EmojiItem copy(ModelEmojiGuild emoji, User user, GuildMember guildMember) {
                Intrinsics3.checkNotNullParameter(emoji, "emoji");
                Intrinsics3.checkNotNullParameter(user, "user");
                return new EmojiItem(emoji, user, guildMember);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof EmojiItem)) {
                    return false;
                }
                EmojiItem emojiItem = (EmojiItem) other;
                return Intrinsics3.areEqual(this.emoji, emojiItem.emoji) && Intrinsics3.areEqual(this.user, emojiItem.user) && Intrinsics3.areEqual(this.guildMember, emojiItem.guildMember);
            }

            public final ModelEmojiGuild getEmoji() {
                return this.emoji;
            }

            public final GuildMember getGuildMember() {
                return this.guildMember;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            public final User getUser() {
                return this.user;
            }

            public int hashCode() {
                ModelEmojiGuild modelEmojiGuild = this.emoji;
                int iHashCode = (modelEmojiGuild != null ? modelEmojiGuild.hashCode() : 0) * 31;
                User user = this.user;
                int iHashCode2 = (iHashCode + (user != null ? user.hashCode() : 0)) * 31;
                GuildMember guildMember = this.guildMember;
                return iHashCode2 + (guildMember != null ? guildMember.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("EmojiItem(emoji=");
                sbU.append(this.emoji);
                sbU.append(", user=");
                sbU.append(this.user);
                sbU.append(", guildMember=");
                sbU.append(this.guildMember);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: WidgetServerSettingsEmojis.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u00020\f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u000eR\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u001b\u0010\u0004R\u001c\u0010\u001c\u001a\u00020\u00028\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u0004¨\u0006 "}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Item$EmojiSection;", "Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Item;", "", "component1", "()I", "component2", "component3", "emojiMax", "emojiLength", "titleId", "copy", "(III)Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Item$EmojiSection;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "key", "Ljava/lang/String;", "getKey", "I", "getEmojiLength", "getEmojiMax", "getTitleId", "type", "getType", "<init>", "(III)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class EmojiSection extends Item {
            private final int emojiLength;
            private final int emojiMax;
            private final String key;
            private final int titleId;
            private final int type;

            public EmojiSection(int i, int i2, int i3) {
                super(null);
                this.emojiMax = i;
                this.emojiLength = i2;
                this.titleId = i3;
                this.type = 1;
                this.key = String.valueOf(i3);
            }

            public static /* synthetic */ EmojiSection copy$default(EmojiSection emojiSection, int i, int i2, int i3, int i4, Object obj) {
                if ((i4 & 1) != 0) {
                    i = emojiSection.emojiMax;
                }
                if ((i4 & 2) != 0) {
                    i2 = emojiSection.emojiLength;
                }
                if ((i4 & 4) != 0) {
                    i3 = emojiSection.titleId;
                }
                return emojiSection.copy(i, i2, i3);
            }

            /* renamed from: component1, reason: from getter */
            public final int getEmojiMax() {
                return this.emojiMax;
            }

            /* renamed from: component2, reason: from getter */
            public final int getEmojiLength() {
                return this.emojiLength;
            }

            /* renamed from: component3, reason: from getter */
            public final int getTitleId() {
                return this.titleId;
            }

            public final EmojiSection copy(int emojiMax, int emojiLength, int titleId) {
                return new EmojiSection(emojiMax, emojiLength, titleId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof EmojiSection)) {
                    return false;
                }
                EmojiSection emojiSection = (EmojiSection) other;
                return this.emojiMax == emojiSection.emojiMax && this.emojiLength == emojiSection.emojiLength && this.titleId == emojiSection.titleId;
            }

            public final int getEmojiLength() {
                return this.emojiLength;
            }

            public final int getEmojiMax() {
                return this.emojiMax;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final int getTitleId() {
                return this.titleId;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            public int hashCode() {
                return (((this.emojiMax * 31) + this.emojiLength) * 31) + this.titleId;
            }

            public String toString() {
                StringBuilder sbU = outline.U("EmojiSection(emojiMax=");
                sbU.append(this.emojiMax);
                sbU.append(", emojiLength=");
                sbU.append(this.emojiLength);
                sbU.append(", titleId=");
                return outline.B(sbU, this.titleId, ")");
            }
        }

        private Item() {
        }

        public /* synthetic */ Item(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsEmojis.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0082\b\u0018\u0000 !2\u00020\u0001:\u0002!\"B)\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001a\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R!\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\b¨\u0006#"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Model;", "", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "", "Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Item;", "component2", "()Ljava/util/List;", "", "component3", "()Ljava/lang/String;", "guild", "items", "defaultName", "copy", "(Lcom/discord/models/guild/Guild;Ljava/util/List;Ljava/lang/String;)Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Model;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDefaultName", "Lcom/discord/models/guild/Guild;", "getGuild", "Ljava/util/List;", "getItems", "<init>", "(Lcom/discord/models/guild/Guild;Ljava/util/List;Ljava/lang/String;)V", "Companion", "Permission", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String defaultName;
        private final Guild guild;
        private final List<Item> items;

        /* compiled from: WidgetServerSettingsEmojis.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00052\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ?\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0016\u0010\u0014\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0012\u0012\u0004\u0012\u00020\u00130\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0017\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Model$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lrx/Observable;", "Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Model$Permission;", "canManageEmojisAndStickers", "(J)Lrx/Observable;", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Model;", "getGuildEmojis", "(Lcom/discord/models/guild/Guild;)Lrx/Observable;", "", "Lcom/discord/models/domain/emoji/ModelEmojiGuild;", "emojis", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "guildMembers", "create", "(Lcom/discord/models/guild/Guild;Ljava/util/List;Ljava/util/Map;)Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Model;", "get", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public static final /* synthetic */ Model access$create(Companion companion, Guild guild, List list, Map map) {
                return companion.create(guild, list, map);
            }

            public static final /* synthetic */ Observable access$getGuildEmojis(Companion companion, Guild guild) {
                return companion.getGuildEmojis(guild);
            }

            private final Observable<Permission> canManageEmojisAndStickers(long guildId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableI = Observable.i(companion.getPermissions().observePermissionsForGuild(guildId), companion.getGuilds().observeGuild(guildId), StoreUser.observeMe$default(companion.getUsers(), false, 1, null), WidgetServerSettingsEmojis$Model$Companion$canManageEmojisAndStickers$1.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableI, "Observable.combineLatest…ld)\n          }\n        }");
                return ObservableExtensionsKt.computationBuffered(observableI);
            }

            private final Model create(Guild guild, List<ModelEmojiGuild> emojis, Map<Long, GuildMember> guildMembers) {
                if (emojis == null) {
                    return new Model(guild, null, null);
                }
                int guildEmojiMaxCount = PremiumUtils.INSTANCE.getGuildEmojiMaxCount(guild);
                Item.EmojiHeader emojiHeader = new Item.EmojiHeader(guildEmojiMaxCount);
                ArrayList arrayList = new ArrayList();
                for (Object obj : emojis) {
                    if (!((ModelEmojiGuild) obj).getAnimated()) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(Item.EmojiItem.INSTANCE.from((ModelEmojiGuild) it.next(), guildMembers));
                }
                List listReversed = _Collections.reversed(arrayList2);
                ArrayList arrayList3 = new ArrayList();
                for (Object obj2 : emojis) {
                    if (((ModelEmojiGuild) obj2).getAnimated()) {
                        arrayList3.add(obj2);
                    }
                }
                ArrayList arrayList4 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList3, 10));
                Iterator it2 = arrayList3.iterator();
                while (it2.hasNext()) {
                    arrayList4.add(Item.EmojiItem.INSTANCE.from((ModelEmojiGuild) it2.next(), guildMembers));
                }
                List listReversed2 = _Collections.reversed(arrayList4);
                Item.EmojiSection emojiSection = new Item.EmojiSection(guildEmojiMaxCount, listReversed.size(), R.string.emoji);
                Item.EmojiSection emojiSection2 = new Item.EmojiSection(guildEmojiMaxCount, listReversed2.size(), R.string.animated_emoji);
                ArrayList arrayList5 = new ArrayList(CollectionsJVM.listOf(emojiHeader));
                if (!listReversed.isEmpty()) {
                    arrayList5.addAll(_Collections.plus((Collection) CollectionsJVM.listOf(emojiSection), (Iterable) listReversed));
                }
                if (!listReversed2.isEmpty()) {
                    arrayList5.addAll(_Collections.plus((Collection) CollectionsJVM.listOf(emojiSection2), (Iterable) listReversed2));
                }
                if (listReversed.isEmpty() && listReversed2.isEmpty()) {
                    arrayList5.addAll(CollectionsJVM.listOf(Item.EmojiEmpty.INSTANCE));
                }
                StringBuilder sbU = outline.U("emoji_");
                sbU.append(emojis.size() + 1);
                return new Model(guild, arrayList5, sbU.toString());
            }

            private final Observable<Model> getGuildEmojis(Guild guild) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                StoreEmojiGuild guildEmojis = companion.getGuildEmojis();
                StoreGuilds guilds = companion.getGuilds();
                Observable observableV = ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{guildEmojis, guilds}, false, null, null, new WidgetServerSettingsEmojis$Model$Companion$getGuildEmojis$1(guild, guildEmojis, guilds), 14, null).v(new WidgetServerSettingsEmojis$Model$Companion$getGuildEmojis$2(guildEmojis, guild.getId()));
                Intrinsics3.checkNotNullExpressionValue(observableV, "ObservationDeckProvider.…etchGuildEmoji(guildId) }");
                return ObservableExtensionsKt.computationBuffered(observableV);
            }

            public final Observable<Model> get(long guildId) {
                Observable observableY = canManageEmojisAndStickers(guildId).Y(WidgetServerSettingsEmojis$Model$Companion$get$1.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableY, "canManageEmojisAndSticke…          }\n            }");
                return observableY;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* compiled from: WidgetServerSettingsEmojis.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Model$Permission;", "", "", "component1", "()Z", "Lcom/discord/models/guild/Guild;", "component2", "()Lcom/discord/models/guild/Guild;", "canManage", "guild", "copy", "(ZLcom/discord/models/guild/Guild;)Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Model$Permission;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/guild/Guild;", "getGuild", "Z", "getCanManage", "<init>", "(ZLcom/discord/models/guild/Guild;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Permission {
            private final boolean canManage;
            private final Guild guild;

            public Permission(boolean z2, Guild guild) {
                Intrinsics3.checkNotNullParameter(guild, "guild");
                this.canManage = z2;
                this.guild = guild;
            }

            public static /* synthetic */ Permission copy$default(Permission permission, boolean z2, Guild guild, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = permission.canManage;
                }
                if ((i & 2) != 0) {
                    guild = permission.guild;
                }
                return permission.copy(z2, guild);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getCanManage() {
                return this.canManage;
            }

            /* renamed from: component2, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            public final Permission copy(boolean canManage, Guild guild) {
                Intrinsics3.checkNotNullParameter(guild, "guild");
                return new Permission(canManage, guild);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Permission)) {
                    return false;
                }
                Permission permission = (Permission) other;
                return this.canManage == permission.canManage && Intrinsics3.areEqual(this.guild, permission.guild);
            }

            public final boolean getCanManage() {
                return this.canManage;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v4 */
            /* JADX WARN: Type inference failed for: r0v5 */
            public int hashCode() {
                boolean z2 = this.canManage;
                ?? r0 = z2;
                if (z2) {
                    r0 = 1;
                }
                int i = r0 * 31;
                Guild guild = this.guild;
                return i + (guild != null ? guild.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Permission(canManage=");
                sbU.append(this.canManage);
                sbU.append(", guild=");
                sbU.append(this.guild);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Model(Guild guild, List<? extends Item> list, String str) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            this.guild = guild;
            this.items = list;
            this.defaultName = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Model copy$default(Model model, Guild guild, List list, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = model.guild;
            }
            if ((i & 2) != 0) {
                list = model.items;
            }
            if ((i & 4) != 0) {
                str = model.defaultName;
            }
            return model.copy(guild, list, str);
        }

        /* renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        public final List<Item> component2() {
            return this.items;
        }

        /* renamed from: component3, reason: from getter */
        public final String getDefaultName() {
            return this.defaultName;
        }

        public final Model copy(Guild guild, List<? extends Item> items, String defaultName) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            return new Model(guild, items, defaultName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.guild, model.guild) && Intrinsics3.areEqual(this.items, model.items) && Intrinsics3.areEqual(this.defaultName, model.defaultName);
        }

        public final String getDefaultName() {
            return this.defaultName;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final List<Item> getItems() {
            return this.items;
        }

        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            List<Item> list = this.items;
            int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
            String str = this.defaultName;
            return iHashCode2 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(guild=");
            sbU.append(this.guild);
            sbU.append(", items=");
            sbU.append(this.items);
            sbU.append(", defaultName=");
            return outline.J(sbU, this.defaultName, ")");
        }
    }

    /* compiled from: WidgetServerSettingsEmojis.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "dataUrl", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEmojis$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<String> {
        public final /* synthetic */ Model $model;

        public AnonymousClass1(Model model) {
            this.$model = model;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(String str) {
            call2(str);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(String str) {
            WidgetServerSettingsEmojis widgetServerSettingsEmojis = WidgetServerSettingsEmojis.this;
            String defaultName = this.$model.getDefaultName();
            Intrinsics3.checkNotNullExpressionValue(str, "dataUrl");
            WidgetServerSettingsEmojis.access$uploadEmoji(widgetServerSettingsEmojis, defaultName, str);
        }
    }

    /* compiled from: WidgetServerSettingsEmojis.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEmojis$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetServerSettingsEmojis.this.openMediaChooser();
        }
    }

    /* compiled from: WidgetServerSettingsEmojis.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/View;", "view", "Lcom/discord/models/domain/emoji/ModelEmojiGuild;", "emoji", "", "invoke", "(Landroid/view/View;Lcom/discord/models/domain/emoji/ModelEmojiGuild;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEmojis$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function2<View, ModelEmojiGuild, Unit> {
        public AnonymousClass3() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View view, ModelEmojiGuild modelEmojiGuild) {
            invoke2(view, modelEmojiGuild);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view, ModelEmojiGuild modelEmojiGuild) {
            Intrinsics3.checkNotNullParameter(view, "view");
            Intrinsics3.checkNotNullParameter(modelEmojiGuild, "emoji");
            WidgetServerSettingsEmojis.access$launchEditScreen(WidgetServerSettingsEmojis.this, view, modelEmojiGuild);
        }
    }

    /* compiled from: WidgetServerSettingsEmojis.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Model;", "it", "", "invoke", "(Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEmojis$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Model, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) throws Exception {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) throws Exception {
            WidgetServerSettingsEmojis.access$configureUI(WidgetServerSettingsEmojis.this, model);
        }
    }

    /* compiled from: WidgetServerSettingsEmojis.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/models/domain/emoji/ModelEmojiGuild;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/domain/emoji/ModelEmojiGuild;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEmojis$uploadEmoji$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<ModelEmojiGuild> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(ModelEmojiGuild modelEmojiGuild) {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(ModelEmojiGuild modelEmojiGuild) {
            call2(modelEmojiGuild);
        }
    }

    public WidgetServerSettingsEmojis() {
        super(R.layout.widget_server_settings_emojis);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsEmojis$binding$2.INSTANCE, null, 2, null);
        this.guildId = -1L;
        this.loggingConfig = new AppLogger2(false, null, WidgetServerSettingsEmojis$loggingConfig$1.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsEmojis widgetServerSettingsEmojis, Model model) throws Exception {
        widgetServerSettingsEmojis.configureUI(model);
    }

    public static final /* synthetic */ void access$launchEditScreen(WidgetServerSettingsEmojis widgetServerSettingsEmojis, View view, ModelEmojiGuild modelEmojiGuild) {
        widgetServerSettingsEmojis.launchEditScreen(view, modelEmojiGuild);
    }

    public static final /* synthetic */ void access$uploadEmoji(WidgetServerSettingsEmojis widgetServerSettingsEmojis, String str, String str2) {
        widgetServerSettingsEmojis.uploadEmoji(str, str2);
    }

    private final void configureToolbar(String guildName) {
        setActionBarTitle(R.string.emoji);
        setActionBarSubtitle(guildName);
    }

    private final void configureUI(Model model) throws Exception {
        if (model == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
                return;
            }
            return;
        }
        configureToolbar(model.getGuild().getName());
        List<Item> items = model.getItems();
        if (items == null || items.isEmpty()) {
            return;
        }
        String defaultName = model.getDefaultName();
        if (defaultName == null || StringsJVM.isBlank(defaultName)) {
            return;
        }
        AppViewFlipper appViewFlipper = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.widgetServerSettingsEmojisViewFlipper");
        appViewFlipper.setDisplayedChild(1);
        this.uploadEmojiAction = new AnonymousClass1(model);
        Adapter adapter = this.adapter;
        if (adapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        adapter.setData(model.getItems());
        Adapter adapter2 = this.adapter;
        if (adapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        adapter2.setOnUploadEmoji(new AnonymousClass2());
        Adapter adapter3 = this.adapter;
        if (adapter3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        adapter3.setOnEmojiItemClicked(new AnonymousClass3());
    }

    private final WidgetServerSettingsEmojisBinding getBinding() {
        return (WidgetServerSettingsEmojisBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void launchEditScreen(View v, ModelEmojiGuild emoji) {
        WidgetServerSettingsEmojisEdit.Companion companion = WidgetServerSettingsEmojisEdit.INSTANCE;
        Context context = v.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "v.context");
        companion.create(context, this.guildId, emoji.getId(), emoji.getName());
    }

    private final void uploadEmoji(String name, String imageBase64) {
        ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().postGuildEmoji(this.guildId, new RestAPIParams.PostGuildEmoji(name, imageBase64)), false, 1, null), this, null, 2, null).k(o.i(AnonymousClass1.INSTANCE, this));
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onImageChosen(Uri uri, String mimeType) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        super.onImageChosen(uri, mimeType);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        MGImages.prepareImageUpload(uri, mimeType, parentFragmentManager, this, this.uploadEmojiAction, ImageUploadDialog.PreviewType.EMOJI);
    }

    @Override // com.discord.app.AppFragment
    public void onImageCropped(Uri uri, String mimeType) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        super.onImageCropped(uri, mimeType);
        MGImages.requestDataUrl(getContext(), uri, mimeType, this.uploadEmojiAction);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        StoreStream.INSTANCE.getGuildEmojis().deactivate();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        this.guildId = getMostRecentIntent().getLongExtra("INTENT_EXTRA_GUILD_ID", -1L);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f2562b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.widgetServerSettingsEmojisRecycler");
        this.adapter = (Adapter) companion.configure(new Adapter(recyclerView));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        StoreStream.INSTANCE.getGuildEmojis().activate(this.guildId);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(this.guildId), this, null, 2, null), WidgetServerSettingsEmojis.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
