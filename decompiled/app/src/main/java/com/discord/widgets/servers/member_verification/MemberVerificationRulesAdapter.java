package com.discord.widgets.servers.member_verification;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.a.i.WidgetMemberVerificationMultipleChoiceRadioItemBinding;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetMemberVerificationApproveTermsItemBinding;
import com.discord.databinding.WidgetMemberVerificationHeaderItemBinding;
import com.discord.databinding.WidgetMemberVerificationMultipleChoiceItemBinding;
import com.discord.databinding.WidgetMemberVerificationParagraphItemBinding;
import com.discord.databinding.WidgetMemberVerificationRuleItemBinding;
import com.discord.databinding.WidgetMemberVerificationTextInputItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.string.StringUtils2;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.view.rounded.RoundedRelativeLayout;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.utilities.view.text.TextWatcher4;
import com.discord.views.CheckedSetting;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemApproveTerms;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemHeader;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemMultipleChoice;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemParagraph;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemTerm;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemTextInput;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: MemberVerificationRulesAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0007$%&'()*B\u0017\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\"\u0010#J)\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u000b\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR.\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R4\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00110\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006+"}, d2 = {"Lcom/discord/widgets/servers/member_verification/MemberVerificationRulesAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/app/AppFragment;", "fragment", "Lcom/discord/app/AppFragment;", "getFragment", "()Lcom/discord/app/AppFragment;", "Lkotlin/Function1;", "", "", "onUpdateRulesApproval", "Lkotlin/jvm/functions/Function1;", "getOnUpdateRulesApproval", "()Lkotlin/jvm/functions/Function1;", "setOnUpdateRulesApproval", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function2;", "", "onUserInputDataEntered", "Lkotlin/jvm/functions/Function2;", "getOnUserInputDataEntered", "()Lkotlin/jvm/functions/Function2;", "setOnUserInputDataEntered", "(Lkotlin/jvm/functions/Function2;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/discord/app/AppFragment;)V", "ApproveTermsItemHolder", "ItemHolder", "MultipleChoiceItemHolder", "ParagraphItemHolder", "TermHeaderItemHolder", "TermItemHolder", "TextInputItemHolder", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class MemberVerificationRulesAdapter extends MGRecyclerAdapterSimple<MGRecyclerDataPayload> {
    private final AppFragment fragment;
    private Function1<? super Boolean, Unit> onUpdateRulesApproval;
    private Function2<? super Integer, Object, Unit> onUserInputDataEntered;

    /* compiled from: MemberVerificationRulesAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/servers/member_verification/MemberVerificationRulesAdapter$ApproveTermsItemHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/servers/member_verification/MemberVerificationRulesAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;)V", "Lcom/discord/databinding/WidgetMemberVerificationApproveTermsItemBinding;", "binding", "Lcom/discord/databinding/WidgetMemberVerificationApproveTermsItemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/servers/member_verification/MemberVerificationRulesAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ApproveTermsItemHolder extends MGRecyclerViewHolder<MemberVerificationRulesAdapter, MGRecyclerDataPayload> {
        private final WidgetMemberVerificationApproveTermsItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ApproveTermsItemHolder(MemberVerificationRulesAdapter memberVerificationRulesAdapter) {
            super(R.layout.widget_member_verification_approve_terms_item, memberVerificationRulesAdapter);
            Intrinsics3.checkNotNullParameter(memberVerificationRulesAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            CheckedSetting checkedSetting = (CheckedSetting) view;
            WidgetMemberVerificationApproveTermsItemBinding widgetMemberVerificationApproveTermsItemBinding = new WidgetMemberVerificationApproveTermsItemBinding(checkedSetting, checkedSetting);
            Intrinsics3.checkNotNullExpressionValue(widgetMemberVerificationApproveTermsItemBinding, "WidgetMemberVerification…temBinding.bind(itemView)");
            this.binding = widgetMemberVerificationApproveTermsItemBinding;
        }

        public static final /* synthetic */ MemberVerificationRulesAdapter access$getAdapter$p(ApproveTermsItemHolder approveTermsItemHolder) {
            return (MemberVerificationRulesAdapter) approveTermsItemHolder.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
            onConfigure2(i, mGRecyclerDataPayload);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            MemberVerificationItemApproveTerms memberVerificationItemApproveTerms = (MemberVerificationItemApproveTerms) data;
            CheckedSetting checkedSetting = this.binding.f2487b;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.memberVerificationRulesCheck");
            checkedSetting.setChecked(memberVerificationItemApproveTerms.isApproved());
            this.binding.f2487b.e(new MemberVerificationRulesAdapter3(this, memberVerificationItemApproveTerms));
        }
    }

    /* compiled from: MemberVerificationRulesAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/servers/member_verification/MemberVerificationRulesAdapter$ItemHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/servers/member_verification/MemberVerificationRulesAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;)V", "Lcom/discord/databinding/WidgetMemberVerificationHeaderItemBinding;", "binding", "Lcom/discord/databinding/WidgetMemberVerificationHeaderItemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/servers/member_verification/MemberVerificationRulesAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ItemHolder extends MGRecyclerViewHolder<MemberVerificationRulesAdapter, MGRecyclerDataPayload> {
        private final WidgetMemberVerificationHeaderItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemHolder(MemberVerificationRulesAdapter memberVerificationRulesAdapter) {
            super(R.layout.widget_member_verification_header_item, memberVerificationRulesAdapter);
            Intrinsics3.checkNotNullParameter(memberVerificationRulesAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            TextView textView = (TextView) view;
            WidgetMemberVerificationHeaderItemBinding widgetMemberVerificationHeaderItemBinding = new WidgetMemberVerificationHeaderItemBinding(textView, textView);
            Intrinsics3.checkNotNullExpressionValue(widgetMemberVerificationHeaderItemBinding, "WidgetMemberVerification…temBinding.bind(itemView)");
            this.binding = widgetMemberVerificationHeaderItemBinding;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
            onConfigure2(i, mGRecyclerDataPayload);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            TextView textView = this.binding.f2489b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.memberVerificationRulesHeader");
            textView.setText(((MemberVerificationItemHeader) data).getTitle());
        }
    }

    /* compiled from: MemberVerificationRulesAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJA\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/servers/member_verification/MemberVerificationRulesAdapter$MultipleChoiceItemHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/servers/member_verification/MemberVerificationRulesAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "Landroid/content/Context;", "context", "Landroid/widget/RadioGroup;", "radioGroup", "", "", "valueList", "Lkotlin/Function1;", "", "", "onItemSelected", "createMultipleChoiceButtons", "(Landroid/content/Context;Landroid/widget/RadioGroup;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "onConfigure", "(ILcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;)V", "Lcom/discord/databinding/WidgetMemberVerificationMultipleChoiceItemBinding;", "binding", "Lcom/discord/databinding/WidgetMemberVerificationMultipleChoiceItemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/servers/member_verification/MemberVerificationRulesAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class MultipleChoiceItemHolder extends MGRecyclerViewHolder<MemberVerificationRulesAdapter, MGRecyclerDataPayload> {
        private final WidgetMemberVerificationMultipleChoiceItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MultipleChoiceItemHolder(MemberVerificationRulesAdapter memberVerificationRulesAdapter) {
            super(R.layout.widget_member_verification_multiple_choice_item, memberVerificationRulesAdapter);
            Intrinsics3.checkNotNullParameter(memberVerificationRulesAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            RadioGroup radioGroup = (RadioGroup) view;
            WidgetMemberVerificationMultipleChoiceItemBinding widgetMemberVerificationMultipleChoiceItemBinding = new WidgetMemberVerificationMultipleChoiceItemBinding(radioGroup, radioGroup);
            Intrinsics3.checkNotNullExpressionValue(widgetMemberVerificationMultipleChoiceItemBinding, "WidgetMemberVerification…temBinding.bind(itemView)");
            this.binding = widgetMemberVerificationMultipleChoiceItemBinding;
        }

        public static final /* synthetic */ MemberVerificationRulesAdapter access$getAdapter$p(MultipleChoiceItemHolder multipleChoiceItemHolder) {
            return (MemberVerificationRulesAdapter) multipleChoiceItemHolder.adapter;
        }

        private final void createMultipleChoiceButtons(Context context, RadioGroup radioGroup, List<String> valueList, Function1<? super Integer, Unit> onItemSelected) {
            RadioButton radioButton;
            for (String str : valueList) {
                int iIndexOf = valueList.indexOf(str);
                if (iIndexOf >= radioGroup.getChildCount()) {
                    View viewInflate = LayoutInflater.from(context).inflate(R.layout.widget_member_verification_multiple_choice_radio_item, (ViewGroup) radioGroup, false);
                    Objects.requireNonNull(viewInflate, "rootView");
                    radioButton = (RadioButton) viewInflate;
                    Intrinsics3.checkNotNullExpressionValue(new WidgetMemberVerificationMultipleChoiceRadioItemBinding(radioButton), "WidgetMemberVerification…        false\n          )");
                    Intrinsics3.checkNotNullExpressionValue(radioButton, "WidgetMemberVerification…   false\n          ).root");
                    radioGroup.addView(radioButton);
                } else {
                    View childAt = this.binding.f2490b.getChildAt(iIndexOf);
                    Objects.requireNonNull(childAt, "null cannot be cast to non-null type android.widget.RadioButton");
                    radioButton = (RadioButton) childAt;
                }
                RadioButton radioButton2 = radioButton;
                radioButton2.setText(str);
                radioButton2.setOnCheckedChangeListener(new MemberVerificationRulesAdapter2(iIndexOf, this, valueList, radioGroup, context, onItemSelected));
            }
            int childCount = radioGroup.getChildCount();
            for (int size = valueList.size(); size < childCount; size++) {
                View childAt2 = this.binding.f2490b.getChildAt(size);
                Intrinsics3.checkNotNullExpressionValue(childAt2, "radioButton");
                childAt2.setVisibility(8);
            }
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
            onConfigure2(i, mGRecyclerDataPayload);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            MemberVerificationItemMultipleChoice memberVerificationItemMultipleChoice = (MemberVerificationItemMultipleChoice) data;
            Integer response = memberVerificationItemMultipleChoice.getResponse();
            Context contextX = outline.x(this.itemView, "itemView", "itemView.context");
            RadioGroup radioGroup = this.binding.f2490b;
            Intrinsics3.checkNotNullExpressionValue(radioGroup, "binding.memberVerificationMultipleChoiceRadioGroup");
            createMultipleChoiceButtons(contextX, radioGroup, memberVerificationItemMultipleChoice.getChoices(), new MemberVerificationRulesAdapter4(this, data));
            if (response != null) {
                View childAt = this.binding.f2490b.getChildAt(response.intValue());
                Objects.requireNonNull(childAt, "null cannot be cast to non-null type android.widget.RadioButton");
                ((RadioButton) childAt).setChecked(true);
            }
        }
    }

    /* compiled from: MemberVerificationRulesAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/servers/member_verification/MemberVerificationRulesAdapter$ParagraphItemHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/servers/member_verification/MemberVerificationRulesAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;)V", "Lcom/discord/databinding/WidgetMemberVerificationParagraphItemBinding;", "binding", "Lcom/discord/databinding/WidgetMemberVerificationParagraphItemBinding;", "fieldIndex", "I", "adapter", "<init>", "(Lcom/discord/widgets/servers/member_verification/MemberVerificationRulesAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ParagraphItemHolder extends MGRecyclerViewHolder<MemberVerificationRulesAdapter, MGRecyclerDataPayload> {
        private final WidgetMemberVerificationParagraphItemBinding binding;
        private int fieldIndex;

        /* compiled from: MemberVerificationRulesAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/text/Editable;", "editable", "", "invoke", "(Landroid/text/Editable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationRulesAdapter$ParagraphItemHolder$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<Editable, Unit> {
            public final /* synthetic */ MemberVerificationRulesAdapter $adapter;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(MemberVerificationRulesAdapter memberVerificationRulesAdapter) {
                super(1);
                this.$adapter = memberVerificationRulesAdapter;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
                invoke2(editable);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Editable editable) {
                Intrinsics3.checkNotNullParameter(editable, "editable");
                this.$adapter.getOnUserInputDataEntered().invoke(Integer.valueOf(ParagraphItemHolder.access$getFieldIndex$p(ParagraphItemHolder.this)), editable.toString());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ParagraphItemHolder(MemberVerificationRulesAdapter memberVerificationRulesAdapter) {
            super(R.layout.widget_member_verification_paragraph_item, memberVerificationRulesAdapter);
            Intrinsics3.checkNotNullParameter(memberVerificationRulesAdapter, "adapter");
            View view = this.itemView;
            TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(R.id.member_verification_paragraph_field);
            if (textInputEditText == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.member_verification_paragraph_field)));
            }
            WidgetMemberVerificationParagraphItemBinding widgetMemberVerificationParagraphItemBinding = new WidgetMemberVerificationParagraphItemBinding((TextInputLayout) view, textInputEditText);
            Intrinsics3.checkNotNullExpressionValue(widgetMemberVerificationParagraphItemBinding, "WidgetMemberVerification…temBinding.bind(itemView)");
            this.binding = widgetMemberVerificationParagraphItemBinding;
            Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.memberVerificationParagraphField");
            TextWatcher4.addBindedTextWatcher(textInputEditText, memberVerificationRulesAdapter.getFragment(), new AnonymousClass1(memberVerificationRulesAdapter));
        }

        public static final /* synthetic */ int access$getFieldIndex$p(ParagraphItemHolder paragraphItemHolder) {
            return paragraphItemHolder.fieldIndex;
        }

        public static final /* synthetic */ void access$setFieldIndex$p(ParagraphItemHolder paragraphItemHolder, int i) {
            paragraphItemHolder.fieldIndex = i;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
            onConfigure2(i, mGRecyclerDataPayload);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            MemberVerificationItemParagraph memberVerificationItemParagraph = (MemberVerificationItemParagraph) data;
            this.fieldIndex = memberVerificationItemParagraph.getFieldIndex();
            this.binding.f2491b.setText(memberVerificationItemParagraph.getResponse());
            TextInputEditText textInputEditText = this.binding.f2491b;
            String response = memberVerificationItemParagraph.getResponse();
            textInputEditText.setSelection(response != null ? response.length() : 0);
        }
    }

    /* compiled from: MemberVerificationRulesAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/servers/member_verification/MemberVerificationRulesAdapter$TermHeaderItemHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/servers/member_verification/MemberVerificationRulesAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;)V", "Lcom/discord/databinding/WidgetMemberVerificationHeaderItemBinding;", "binding", "Lcom/discord/databinding/WidgetMemberVerificationHeaderItemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/servers/member_verification/MemberVerificationRulesAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class TermHeaderItemHolder extends MGRecyclerViewHolder<MemberVerificationRulesAdapter, MGRecyclerDataPayload> {
        private final WidgetMemberVerificationHeaderItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TermHeaderItemHolder(MemberVerificationRulesAdapter memberVerificationRulesAdapter) {
            super(R.layout.widget_member_verification_header_item, memberVerificationRulesAdapter);
            Intrinsics3.checkNotNullParameter(memberVerificationRulesAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            TextView textView = (TextView) view;
            WidgetMemberVerificationHeaderItemBinding widgetMemberVerificationHeaderItemBinding = new WidgetMemberVerificationHeaderItemBinding(textView, textView);
            Intrinsics3.checkNotNullExpressionValue(widgetMemberVerificationHeaderItemBinding, "WidgetMemberVerification…temBinding.bind(itemView)");
            this.binding = widgetMemberVerificationHeaderItemBinding;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
            onConfigure2(i, mGRecyclerDataPayload);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            TextView textView = this.binding.f2489b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.memberVerificationRulesHeader");
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            textView.setText(view.getResources().getString(R.string.member_verification_form_rules_label));
        }
    }

    /* compiled from: MemberVerificationRulesAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/servers/member_verification/MemberVerificationRulesAdapter$TermItemHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/servers/member_verification/MemberVerificationRulesAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;)V", "Lcom/discord/databinding/WidgetMemberVerificationRuleItemBinding;", "binding", "Lcom/discord/databinding/WidgetMemberVerificationRuleItemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/servers/member_verification/MemberVerificationRulesAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class TermItemHolder extends MGRecyclerViewHolder<MemberVerificationRulesAdapter, MGRecyclerDataPayload> {
        private final WidgetMemberVerificationRuleItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TermItemHolder(MemberVerificationRulesAdapter memberVerificationRulesAdapter) {
            super(R.layout.widget_member_verification_rule_item, memberVerificationRulesAdapter);
            Intrinsics3.checkNotNullParameter(memberVerificationRulesAdapter, "adapter");
            View view = this.itemView;
            int i = R.id.member_verification_rule_container;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.member_verification_rule_container);
            if (linearLayout != null) {
                i = R.id.member_verification_rule_description;
                SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) view.findViewById(R.id.member_verification_rule_description);
                if (simpleDraweeSpanTextView != null) {
                    i = R.id.member_verification_rule_divider;
                    View viewFindViewById = view.findViewById(R.id.member_verification_rule_divider);
                    if (viewFindViewById != null) {
                        i = R.id.member_verification_rule_index;
                        TextView textView = (TextView) view.findViewById(R.id.member_verification_rule_index);
                        if (textView != null) {
                            RoundedRelativeLayout roundedRelativeLayout = (RoundedRelativeLayout) view;
                            WidgetMemberVerificationRuleItemBinding widgetMemberVerificationRuleItemBinding = new WidgetMemberVerificationRuleItemBinding(roundedRelativeLayout, linearLayout, simpleDraweeSpanTextView, viewFindViewById, textView, roundedRelativeLayout);
                            Intrinsics3.checkNotNullExpressionValue(widgetMemberVerificationRuleItemBinding, "WidgetMemberVerification…temBinding.bind(itemView)");
                            this.binding = widgetMemberVerificationRuleItemBinding;
                            return;
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
            onConfigure2(i, mGRecyclerDataPayload);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            MemberVerificationItemTerm memberVerificationItemTerm = (MemberVerificationItemTerm) data;
            TextView textView = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.memberVerificationRuleIndex");
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            Resources resources = view.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "itemView.resources");
            int index = memberVerificationItemTerm.getIndex();
            View view2 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
            Context context = view2.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "itemView.context");
            textView.setText(FormatUtils.i(resources, R.string.member_verification_rule_index, new Object[]{StringUtils2.format(index, context)}, null, 4));
            this.binding.f2493b.setDraweeSpanStringBuilder(AstRenderer.render(memberVerificationItemTerm.getAst(), new MessageRenderContext(outline.x(this.itemView, "itemView", "itemView.context"), 0L, memberVerificationItemTerm.getAllowAnimatedEmojis(), null, memberVerificationItemTerm.getChannelNames(), memberVerificationItemTerm.getRoles(), 0, null, null, 0, 0, null, null, null, 16328, null)));
            View view3 = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(view3, "binding.memberVerificationRuleDivider");
            view3.setVisibility(memberVerificationItemTerm.isLastItem() ^ true ? 0 : 8);
            float fDpToPixels = DimenUtils.dpToPixels(4);
            if (memberVerificationItemTerm.isFirstItem()) {
                this.binding.e.updateTopLeftRadius(fDpToPixels);
                this.binding.e.updateTopRightRadius(fDpToPixels);
            }
            if (memberVerificationItemTerm.isLastItem()) {
                this.binding.e.updateBottomLeftRadius(fDpToPixels);
                this.binding.e.updateBottomRightRadius(fDpToPixels);
            }
        }
    }

    /* compiled from: MemberVerificationRulesAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/servers/member_verification/MemberVerificationRulesAdapter$TextInputItemHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/servers/member_verification/MemberVerificationRulesAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;)V", "fieldIndex", "I", "Lcom/discord/databinding/WidgetMemberVerificationTextInputItemBinding;", "binding", "Lcom/discord/databinding/WidgetMemberVerificationTextInputItemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/servers/member_verification/MemberVerificationRulesAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class TextInputItemHolder extends MGRecyclerViewHolder<MemberVerificationRulesAdapter, MGRecyclerDataPayload> {
        private final WidgetMemberVerificationTextInputItemBinding binding;
        private int fieldIndex;

        /* compiled from: MemberVerificationRulesAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/text/Editable;", "editable", "", "invoke", "(Landroid/text/Editable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationRulesAdapter$TextInputItemHolder$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<Editable, Unit> {
            public final /* synthetic */ MemberVerificationRulesAdapter $adapter;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(MemberVerificationRulesAdapter memberVerificationRulesAdapter) {
                super(1);
                this.$adapter = memberVerificationRulesAdapter;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
                invoke2(editable);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Editable editable) {
                Intrinsics3.checkNotNullParameter(editable, "editable");
                this.$adapter.getOnUserInputDataEntered().invoke(Integer.valueOf(TextInputItemHolder.access$getFieldIndex$p(TextInputItemHolder.this)), editable.toString());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TextInputItemHolder(MemberVerificationRulesAdapter memberVerificationRulesAdapter) {
            super(R.layout.widget_member_verification_text_input_item, memberVerificationRulesAdapter);
            Intrinsics3.checkNotNullParameter(memberVerificationRulesAdapter, "adapter");
            View view = this.itemView;
            TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(R.id.member_verification_text_input_field);
            if (textInputEditText == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.member_verification_text_input_field)));
            }
            WidgetMemberVerificationTextInputItemBinding widgetMemberVerificationTextInputItemBinding = new WidgetMemberVerificationTextInputItemBinding((TextInputLayout) view, textInputEditText);
            Intrinsics3.checkNotNullExpressionValue(widgetMemberVerificationTextInputItemBinding, "WidgetMemberVerification…temBinding.bind(itemView)");
            this.binding = widgetMemberVerificationTextInputItemBinding;
            Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.memberVerificationTextInputField");
            TextWatcher4.addBindedTextWatcher(textInputEditText, memberVerificationRulesAdapter.getFragment(), new AnonymousClass1(memberVerificationRulesAdapter));
        }

        public static final /* synthetic */ int access$getFieldIndex$p(TextInputItemHolder textInputItemHolder) {
            return textInputItemHolder.fieldIndex;
        }

        public static final /* synthetic */ void access$setFieldIndex$p(TextInputItemHolder textInputItemHolder, int i) {
            textInputItemHolder.fieldIndex = i;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
            onConfigure2(i, mGRecyclerDataPayload);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            MemberVerificationItemTextInput memberVerificationItemTextInput = (MemberVerificationItemTextInput) data;
            this.fieldIndex = memberVerificationItemTextInput.getFieldIndex();
            this.binding.f2495b.setText(memberVerificationItemTextInput.getResponse());
            TextInputEditText textInputEditText = this.binding.f2495b;
            String response = memberVerificationItemTextInput.getResponse();
            textInputEditText.setSelection(response != null ? response.length() : 0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberVerificationRulesAdapter(RecyclerView recyclerView, AppFragment appFragment) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        Intrinsics3.checkNotNullParameter(appFragment, "fragment");
        this.fragment = appFragment;
        this.onUpdateRulesApproval = MemberVerificationRulesAdapter5.INSTANCE;
        this.onUserInputDataEntered = MemberVerificationRulesAdapter6.INSTANCE;
    }

    public final AppFragment getFragment() {
        return this.fragment;
    }

    public final Function1<Boolean, Unit> getOnUpdateRulesApproval() {
        return this.onUpdateRulesApproval;
    }

    public final Function2<Integer, Object, Unit> getOnUserInputDataEntered() {
        return this.onUserInputDataEntered;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnUpdateRulesApproval(Function1<? super Boolean, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onUpdateRulesApproval = function1;
    }

    public final void setOnUserInputDataEntered(Function2<? super Integer, Object, Unit> function2) {
        Intrinsics3.checkNotNullParameter(function2, "<set-?>");
        this.onUserInputDataEntered = function2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, MGRecyclerDataPayload> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        switch (viewType) {
            case 0:
                return new ItemHolder(this);
            case 1:
                return new TermHeaderItemHolder(this);
            case 2:
                return new ApproveTermsItemHolder(this);
            case 3:
                return new TermItemHolder(this);
            case 4:
                return new TextInputItemHolder(this);
            case 5:
                return new ParagraphItemHolder(this);
            case 6:
                return new MultipleChoiceItemHolder(this);
            default:
                throw invalidViewTypeException(viewType);
        }
    }
}
