package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextWatcher;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import b.a.a.b.GuildBoostUpsellDialog;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildFeature;
import com.discord.databinding.WidgetChatListAdapterItemThreadDraftFormBinding;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadDraft;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.channels.threads.WidgetThreadDraftArchiveSheet;
import com.discord.widgets.chat.input.AppFlexInputViewModel;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.ThreadDraftFormEntry;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChatListAdapterItemThreadDraftForm.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u001f\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\fH\u0014¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemThreadDraftForm;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListItem;", "Lcom/discord/widgets/chat/list/entries/ThreadDraftFormEntry;", "data", "", "configureIcon", "(Lcom/discord/widgets/chat/list/entries/ThreadDraftFormEntry;)V", "configureThreadNameInput", "configurePrivateThreadOption", "configureAutoArchive", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "onConfigure", "(ILcom/discord/widgets/chat/list/entries/ChatListEntry;)V", "Lcom/discord/widgets/chat/input/AppFlexInputViewModel;", "flexInputViewModel", "Lcom/discord/widgets/chat/input/AppFlexInputViewModel;", "getFlexInputViewModel", "()Lcom/discord/widgets/chat/input/AppFlexInputViewModel;", "Landroid/text/TextWatcher;", "nameTextWatcher", "Landroid/text/TextWatcher;", "Lcom/discord/databinding/WidgetChatListAdapterItemThreadDraftFormBinding;", "binding", "Lcom/discord/databinding/WidgetChatListAdapterItemThreadDraftFormBinding;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "adapter", "<init>", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;Lcom/discord/widgets/chat/input/AppFlexInputViewModel;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemThreadDraftForm extends WidgetChatListItem {
    private final WidgetChatListAdapterItemThreadDraftFormBinding binding;
    private final AppFlexInputViewModel flexInputViewModel;
    private TextWatcher nameTextWatcher;

    /* compiled from: WidgetChatListAdapterItemThreadDraftForm.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemThreadDraftForm$configureAutoArchive$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<RenderContext, Unit> {
        public final /* synthetic */ ThreadDraftFormEntry $data;
        public final /* synthetic */ StoreThreadDraft.ThreadDraftState $draftState;

        /* compiled from: WidgetChatListAdapterItemThreadDraftForm.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/Hook;", "", "invoke", "(Lcom/discord/i18n/Hook;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemThreadDraftForm$configureAutoArchive$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02781 extends Lambda implements Function1<Hook, Unit> {

            /* compiled from: WidgetChatListAdapterItemThreadDraftForm.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemThreadDraftForm$configureAutoArchive$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C02791 extends Lambda implements Function1<View, Unit> {
                public C02791() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    Intrinsics3.checkNotNullParameter(view, "it");
                    WidgetThreadDraftArchiveSheet.INSTANCE.show(WidgetChatListAdapterItemThreadDraftForm.access$getAdapter$p(WidgetChatListAdapterItemThreadDraftForm.this).getFragmentManager(), AnonymousClass1.this.$data.getGuildId());
                }
            }

            public C02781() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) throws Resources.NotFoundException {
                invoke2(hook);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) throws Resources.NotFoundException {
                Intrinsics3.checkNotNullParameter(hook, "$receiver");
                ThreadUtils threadUtils = ThreadUtils.INSTANCE;
                Context context = WidgetChatListAdapterItemThreadDraftForm.access$getAdapter$p(WidgetChatListAdapterItemThreadDraftForm.this).getContext();
                Integer autoArchiveDuration = AnonymousClass1.this.$draftState.getAutoArchiveDuration();
                if (autoArchiveDuration == null) {
                    autoArchiveDuration = AnonymousClass1.this.$data.getDefaultAutoArchiveDuration();
                }
                String strAutoArchiveDurationName = threadUtils.autoArchiveDurationName(context, autoArchiveDuration != null ? autoArchiveDuration.intValue() : 1440);
                Locale locale = Locale.getDefault();
                Intrinsics3.checkNotNullExpressionValue(locale, "Locale.getDefault()");
                Objects.requireNonNull(strAutoArchiveDurationName, "null cannot be cast to non-null type java.lang.String");
                String lowerCase = strAutoArchiveDurationName.toLowerCase(locale);
                Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                hook.replacementText = lowerCase;
                hook.styles.add(new ClickableSpan(Integer.valueOf(ColorCompat.getThemedColor(WidgetChatListAdapterItemThreadDraftForm.access$getAdapter$p(WidgetChatListAdapterItemThreadDraftForm.this).getContext(), R.attr.colorHeaderPrimary)), true, null, new C02791(), 4, null));
                hook.styles.add(new StyleSpan(1));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(StoreThreadDraft.ThreadDraftState threadDraftState, ThreadDraftFormEntry threadDraftFormEntry) {
            super(1);
            this.$draftState = threadDraftState;
            this.$data = threadDraftFormEntry;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.a("durationHook", new C02781());
        }
    }

    /* compiled from: WidgetChatListAdapterItemThreadDraftForm.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemThreadDraftForm$configureAutoArchive$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ ThreadDraftFormEntry $data;

        public AnonymousClass2(ThreadDraftFormEntry threadDraftFormEntry) {
            this.$data = threadDraftFormEntry;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetThreadDraftArchiveSheet.INSTANCE.show(WidgetChatListAdapterItemThreadDraftForm.access$getAdapter$p(WidgetChatListAdapterItemThreadDraftForm.this).getFragmentManager(), this.$data.getGuildId());
        }
    }

    /* compiled from: WidgetChatListAdapterItemThreadDraftForm.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemThreadDraftForm$configurePrivateThreadOption$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ ThreadDraftFormEntry $data;

        public AnonymousClass1(ThreadDraftFormEntry threadDraftFormEntry) {
            this.$data = threadDraftFormEntry;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            GuildBoostUpsellDialog.INSTANCE.a(WidgetChatListAdapterItemThreadDraftForm.access$getAdapter$p(WidgetChatListAdapterItemThreadDraftForm.this).getFragmentManager(), this.$data.getGuildId(), Long.valueOf(this.$data.getParentChannel().getId()), PremiumUtils.INSTANCE.getMinimumBoostTierForGuildFeature(GuildFeature.PRIVATE_THREADS), new Traits.Location(Traits.Location.Page.GUILD_CHANNEL, Traits.Location.Section.THREAD_CREATION_OPTIONS, Traits.Location.Obj.PRIVATE_THREAD_CHECKBOX, null, null, 24, null));
        }
    }

    /* compiled from: WidgetChatListAdapterItemThreadDraftForm.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemThreadDraftForm$configurePrivateThreadOption$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ StoreThreadDraft.ThreadDraftState $draftState;
        public final /* synthetic */ StoreThreadDraft $storeThreadDraft;

        public AnonymousClass2(StoreThreadDraft storeThreadDraft, StoreThreadDraft.ThreadDraftState threadDraftState) {
            this.$storeThreadDraft = storeThreadDraft;
            this.$draftState = threadDraftState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$storeThreadDraft.setDraftState(StoreThreadDraft.ThreadDraftState.copy$default(this.$draftState, !r0.isPrivate(), null, null, false, false, 30, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemThreadDraftForm(WidgetChatListAdapter widgetChatListAdapter, AppFlexInputViewModel appFlexInputViewModel) {
        super(R.layout.widget_chat_list_adapter_item_thread_draft_form, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        this.flexInputViewModel = appFlexInputViewModel;
        View view = this.itemView;
        int i = R.id.auto_archive_duration;
        TextView textView = (TextView) view.findViewById(R.id.auto_archive_duration);
        if (textView != null) {
            i = R.id.divider_stroke;
            View viewFindViewById = view.findViewById(R.id.divider_stroke);
            if (viewFindViewById != null) {
                i = R.id.private_thread_toggle;
                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.private_thread_toggle);
                if (constraintLayout != null) {
                    i = R.id.private_thread_toggle_badge;
                    TextView textView2 = (TextView) view.findViewById(R.id.private_thread_toggle_badge);
                    if (textView2 != null) {
                        i = R.id.private_thread_toggle_switch;
                        SwitchMaterial switchMaterial = (SwitchMaterial) view.findViewById(R.id.private_thread_toggle_switch);
                        if (switchMaterial != null) {
                            i = R.id.private_thread_toggle_text;
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.private_thread_toggle_text);
                            if (linearLayout != null) {
                                i = R.id.thread_icon;
                                ImageView imageView = (ImageView) view.findViewById(R.id.thread_icon);
                                if (imageView != null) {
                                    i = R.id.thread_name_input;
                                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.thread_name_input);
                                    if (textInputLayout != null) {
                                        WidgetChatListAdapterItemThreadDraftFormBinding widgetChatListAdapterItemThreadDraftFormBinding = new WidgetChatListAdapterItemThreadDraftFormBinding((LinearLayout) view, textView, viewFindViewById, constraintLayout, textView2, switchMaterial, linearLayout, imageView, textInputLayout);
                                        Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemThreadDraftFormBinding, "WidgetChatListAdapterIte…ormBinding.bind(itemView)");
                                        this.binding = widgetChatListAdapterItemThreadDraftFormBinding;
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemThreadDraftForm widgetChatListAdapterItemThreadDraftForm) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemThreadDraftForm.adapter;
    }

    private final void configureAutoArchive(ThreadDraftFormEntry data) {
        StoreThreadDraft.ThreadDraftState threadDraftState = data.getThreadDraftState();
        TextView textView = this.binding.f2340b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.autoArchiveDuration");
        FormatUtils.m(textView, R.string.create_thread_header_2, new Object[0], new AnonymousClass1(threadDraftState, data));
        this.binding.f2340b.setOnClickListener(new AnonymousClass2(data));
    }

    private final void configureIcon(ThreadDraftFormEntry data) {
        this.binding.f.setImageResource(ChannelUtils.q(data.getParentChannel()) ? R.drawable.ic_channel_forum_post : data.getThreadDraftState().isPrivate() ? R.drawable.ic_thread_locked : R.drawable.ic_thread);
    }

    private final void configurePrivateThreadOption(ThreadDraftFormEntry data) {
        StoreThreadDraft.ThreadDraftState threadDraftState = data.getThreadDraftState();
        StoreThreadDraft threadDraft = StoreStream.INSTANCE.getThreadDraft();
        if (ChannelUtils.q(data.getParentChannel())) {
            ConstraintLayout constraintLayout = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.privateThreadToggle");
            constraintLayout.setVisibility(8);
            return;
        }
        ConstraintLayout constraintLayout2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.privateThreadToggle");
        constraintLayout2.setVisibility(data.getParentMessageId() == null && data.getCanSeePrivateThreadOption() ? 0 : 8);
        if (!data.getCanCreatePublicThread() && !threadDraftState.isPrivate()) {
            threadDraft.setDraftState(StoreThreadDraft.ThreadDraftState.copy$default(threadDraftState, true, null, null, false, false, 30, null));
            this.binding.c.setOnClickListener(null);
        } else if (data.getCanCreatePrivateThread()) {
            this.binding.c.setOnClickListener(new AnonymousClass2(threadDraft, threadDraftState));
        } else {
            this.binding.c.setOnClickListener(new AnonymousClass1(data));
        }
        SwitchMaterial switchMaterial = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(switchMaterial, "binding.privateThreadToggleSwitch");
        switchMaterial.setChecked(threadDraftState.isPrivate());
        PremiumUtils.BoostFeatureBadgeData boostFeatureBadgeDataForGuildFeature$default = PremiumUtils.getBoostFeatureBadgeDataForGuildFeature$default(PremiumUtils.INSTANCE, data.getGuild(), Long.valueOf(data.getParentChannel().getId()), GuildFeature.PRIVATE_THREADS, ((WidgetChatListAdapter) this.adapter).getContext(), ((WidgetChatListAdapter) this.adapter).getFragmentManager(), null, new Traits.Location(null, Traits.Location.Section.THREAD_CREATION_OPTIONS, Traits.Location.Obj.PRIVATE_THREAD_CHECKBOX, null, null, 25, null), 32, null);
        TextView textView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.privateThreadToggleBadge");
        textView.setText(boostFeatureBadgeDataForGuildFeature$default.getText());
        TextView textView2 = this.binding.d;
        Drawable drawable = ContextCompat.getDrawable(((WidgetChatListAdapter) this.adapter).getContext(), R.drawable.ic_boosted_badge_12dp);
        if (drawable != null) {
            drawable.setTint(boostFeatureBadgeDataForGuildFeature$default.getIconColor());
        } else {
            drawable = null;
        }
        textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private final void configureThreadNameInput(ThreadDraftFormEntry data) {
        StoreThreadDraft.ThreadDraftState threadDraftState = data.getThreadDraftState();
        StoreThreadDraft threadDraft = StoreStream.INSTANCE.getThreadDraft();
        String threadName = threadDraftState.getThreadName();
        if (threadName == null || threadName.length() == 0) {
            TextInputLayout textInputLayout = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.threadNameInput");
            ViewExtensions.clear(textInputLayout);
        }
        TextInputLayout textInputLayout2 = this.binding.g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.threadNameInput");
        EditText editText = textInputLayout2.getEditText();
        if (editText != null) {
            editText.removeTextChangedListener(this.nameTextWatcher);
            WidgetChatListAdapterItemThreadDraftForm$configureThreadNameInput$$inlined$apply$lambda$1 widgetChatListAdapterItemThreadDraftForm$configureThreadNameInput$$inlined$apply$lambda$1 = new WidgetChatListAdapterItemThreadDraftForm$configureThreadNameInput$$inlined$apply$lambda$1(this, threadDraft, threadDraftState);
            editText.addTextChangedListener(widgetChatListAdapterItemThreadDraftForm$configureThreadNameInput$$inlined$apply$lambda$1);
            this.nameTextWatcher = widgetChatListAdapterItemThreadDraftForm$configureThreadNameInput$$inlined$apply$lambda$1;
            editText.setOnFocusChangeListener(new WidgetChatListAdapterItemThreadDraftForm2(this, threadDraft, threadDraftState));
            editText.setOnEditorActionListener(new WidgetChatListAdapterItemThreadDraftForm3(this, threadDraft, threadDraftState));
        }
        if (!threadDraftState.getShouldDisplayNameError()) {
            TextInputLayout textInputLayout3 = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.threadNameInput");
            textInputLayout3.setErrorEnabled(false);
            return;
        }
        TextInputLayout textInputLayout4 = this.binding.g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.threadNameInput");
        TextInputLayout textInputLayout5 = this.binding.g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout5, "binding.threadNameInput");
        textInputLayout4.setError(textInputLayout5.getContext().getString(R.string.member_verification_form_required_item));
        TextInputLayout textInputLayout6 = this.binding.g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout6, "binding.threadNameInput");
        textInputLayout6.setErrorEnabled(true);
    }

    public final AppFlexInputViewModel getFlexInputViewModel() {
        return this.flexInputViewModel;
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
        ThreadDraftFormEntry threadDraftFormEntry = (ThreadDraftFormEntry) data;
        configureThreadNameInput(threadDraftFormEntry);
        configureAutoArchive(threadDraftFormEntry);
        configureIcon(threadDraftFormEntry);
        configurePrivateThreadOption(threadDraftFormEntry);
        this.binding.g.requestFocus();
    }
}
