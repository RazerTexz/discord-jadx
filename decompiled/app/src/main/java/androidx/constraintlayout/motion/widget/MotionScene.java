package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.StateSet;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class MotionScene {
    public static final int ANTICIPATE = 4;
    public static final int BOUNCE = 5;
    private static final boolean DEBUG = false;
    public static final int EASE_IN = 1;
    public static final int EASE_IN_OUT = 0;
    public static final int EASE_OUT = 2;
    private static final int INTERPOLATOR_REFRENCE_ID = -2;
    public static final int LAYOUT_HONOR_REQUEST = 1;
    public static final int LAYOUT_IGNORE_REQUEST = 0;
    public static final int LINEAR = 3;
    private static final int SPLINE_STRING = -1;
    public static final String TAG = "MotionScene";
    public static final int TRANSITION_BACKWARD = 0;
    public static final int TRANSITION_FORWARD = 1;
    public static final int UNSET = -1;
    private MotionEvent mLastTouchDown;
    public float mLastTouchX;
    public float mLastTouchY;
    private final MotionLayout mMotionLayout;
    private boolean mRtl;
    private MotionLayout.MotionTracker mVelocityTracker;
    public StateSet mStateSet = null;
    public Transition mCurrentTransition = null;
    private boolean mDisableAutoTransition = false;
    private ArrayList<Transition> mTransitionList = new ArrayList<>();
    private Transition mDefaultTransition = null;
    private ArrayList<Transition> mAbstractTransitionList = new ArrayList<>();
    private SparseArray<ConstraintSet> mConstraintSetMap = new SparseArray<>();
    private HashMap<String, Integer> mConstraintSetIdMap = new HashMap<>();
    private SparseIntArray mDeriveMap = new SparseIntArray();
    private boolean DEBUG_DESKTOP = false;
    private int mDefaultDuration = 400;
    private int mLayoutDuringTransition = 0;
    private boolean mIgnoreTouch = false;
    private boolean mMotionOutsideRegion = false;

    /* renamed from: androidx.constraintlayout.motion.widget.MotionScene$1, reason: invalid class name */
    public class AnonymousClass1 implements Interpolator {
        public final /* synthetic */ Easing val$easing;

        public AnonymousClass1(Easing easing) {
            this.val$easing = easing;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return (float) this.val$easing.get(f);
        }
    }

    public MotionScene(MotionLayout motionLayout) {
        this.mMotionLayout = motionLayout;
    }

    public static /* synthetic */ int access$1000(MotionScene motionScene) {
        return motionScene.mLayoutDuringTransition;
    }

    public static /* synthetic */ SparseArray access$1100(MotionScene motionScene) {
        return motionScene.mConstraintSetMap;
    }

    public static /* synthetic */ MotionLayout access$800(MotionScene motionScene) {
        return motionScene.mMotionLayout;
    }

    public static /* synthetic */ int access$900(MotionScene motionScene) {
        return motionScene.mDefaultDuration;
    }

    private int getId(Context context, String str) {
        int identifier;
        if (str.contains(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN)) {
            identifier = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), ModelAuditLogEntry.CHANGE_KEY_ID, context.getPackageName());
            if (this.DEBUG_DESKTOP) {
                System.out.println("id getMap res = " + identifier);
            }
        } else {
            identifier = -1;
        }
        if (identifier != -1) {
            return identifier;
        }
        if (str.length() > 1) {
            return Integer.parseInt(str.substring(1));
        }
        Log.e(TAG, "error in parsing id");
        return identifier;
    }

    private int getIndex(Transition transition) {
        int iAccess$300 = Transition.access$300(transition);
        if (iAccess$300 == -1) {
            throw new IllegalArgumentException("The transition must have an id");
        }
        for (int i = 0; i < this.mTransitionList.size(); i++) {
            if (Transition.access$300(this.mTransitionList.get(i)) == iAccess$300) {
                return i;
            }
        }
        return -1;
    }

    private int getRealID(int i) {
        int iStateGetConstraintID;
        StateSet stateSet = this.mStateSet;
        return (stateSet == null || (iStateGetConstraintID = stateSet.stateGetConstraintID(i, -1, -1)) == -1) ? i : iStateGetConstraintID;
    }

    private boolean hasCycleDependency(int i) {
        int i2 = this.mDeriveMap.get(i);
        int size = this.mDeriveMap.size();
        while (i2 > 0) {
            if (i2 == i) {
                return true;
            }
            int i3 = size - 1;
            if (size < 0) {
                return true;
            }
            i2 = this.mDeriveMap.get(i2);
            size = i3;
        }
        return false;
    }

    private boolean isProcessingTouch() {
        return this.mVelocityTracker != null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void load(Context context, int i) throws XmlPullParserException, Resources.NotFoundException, IOException {
        XmlResourceParser xml = context.getResources().getXml(i);
        Transition transition = null;
        try {
            int eventType = xml.getEventType();
            while (true) {
                char c = 1;
                if (eventType == 1) {
                    return;
                }
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    if (this.DEBUG_DESKTOP) {
                        System.out.println("parsing = " + name);
                    }
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (!name.equals("ConstraintSet")) {
                                c = 65535;
                                break;
                            } else {
                                c = 5;
                                break;
                            }
                        case -1239391468:
                            if (name.equals("KeyFrameSet")) {
                                c = 6;
                                break;
                            }
                            break;
                        case 269306229:
                            if (name.equals("Transition")) {
                                break;
                            }
                            break;
                        case 312750793:
                            if (name.equals("OnClick")) {
                                c = 3;
                                break;
                            }
                            break;
                        case 327855227:
                            if (name.equals("OnSwipe")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 793277014:
                            if (name.equals(TAG)) {
                                c = 0;
                                break;
                            }
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                c = 4;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            parseMotionSceneTags(context, xml);
                            break;
                        case 1:
                            ArrayList<Transition> arrayList = this.mTransitionList;
                            Transition transition2 = new Transition(this, context, xml);
                            arrayList.add(transition2);
                            if (this.mCurrentTransition == null && !Transition.access$1200(transition2)) {
                                this.mCurrentTransition = transition2;
                                if (Transition.access$200(transition2) != null) {
                                    Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);
                                }
                            }
                            if (Transition.access$1200(transition2)) {
                                if (Transition.access$000(transition2) == -1) {
                                    this.mDefaultTransition = transition2;
                                } else {
                                    this.mAbstractTransitionList.add(transition2);
                                }
                                this.mTransitionList.remove(transition2);
                            }
                            transition = transition2;
                            break;
                        case 2:
                            if (transition == null) {
                                Log.v(TAG, " OnSwipe (" + context.getResources().getResourceEntryName(i) + ".xml:" + xml.getLineNumber() + ")");
                            }
                            Transition.access$202(transition, new TouchResponse(context, this.mMotionLayout, xml));
                            break;
                        case 3:
                            transition.addOnClick(context, xml);
                            break;
                        case 4:
                            this.mStateSet = new StateSet(context, xml);
                            break;
                        case 5:
                            parseConstraintSet(context, xml);
                            break;
                        case 6:
                            Transition.access$1300(transition).add(new KeyFrames(context, xml));
                            break;
                        default:
                            Log.v(TAG, "WARNING UNKNOWN ATTRIBUTE " + name);
                            break;
                    }
                }
                eventType = xml.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    private void parseConstraintSet(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.setForceId(false);
        int attributeCount = xmlPullParser.getAttributeCount();
        int id2 = -1;
        int id3 = -1;
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            if (this.DEBUG_DESKTOP) {
                System.out.println("id string = " + attributeValue);
            }
            attributeName.hashCode();
            if (attributeName.equals("deriveConstraintsFrom")) {
                id3 = getId(context, attributeValue);
            } else if (attributeName.equals(ModelAuditLogEntry.CHANGE_KEY_ID)) {
                id2 = getId(context, attributeValue);
                this.mConstraintSetIdMap.put(stripID(attributeValue), Integer.valueOf(id2));
            }
        }
        if (id2 != -1) {
            if (this.mMotionLayout.mDebugPath != 0) {
                constraintSet.setValidateOnParse(true);
            }
            constraintSet.load(context, xmlPullParser);
            if (id3 != -1) {
                this.mDeriveMap.put(id2, id3);
            }
            this.mConstraintSetMap.put(id2, constraintSet);
        }
    }

    private void parseMotionSceneTags(Context context, XmlPullParser xmlPullParser) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.MotionScene);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == R.styleable.MotionScene_defaultDuration) {
                this.mDefaultDuration = typedArrayObtainStyledAttributes.getInt(index, this.mDefaultDuration);
            } else if (index == R.styleable.MotionScene_layoutDuringTransition) {
                this.mLayoutDuringTransition = typedArrayObtainStyledAttributes.getInteger(index, 0);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void readConstraintChain(int i) {
        int i2 = this.mDeriveMap.get(i);
        if (i2 > 0) {
            readConstraintChain(this.mDeriveMap.get(i));
            ConstraintSet constraintSet = this.mConstraintSetMap.get(i);
            ConstraintSet constraintSet2 = this.mConstraintSetMap.get(i2);
            if (constraintSet2 != null) {
                constraintSet.readFallback(constraintSet2);
                this.mDeriveMap.put(i, -1);
            } else {
                StringBuilder sbU = outline.U("ERROR! invalid deriveConstraintsFrom: @id/");
                sbU.append(Debug.getName(this.mMotionLayout.getContext(), i2));
                Log.e(TAG, sbU.toString());
            }
        }
    }

    public static String stripID(String str) {
        if (str == null) {
            return "";
        }
        int iIndexOf = str.indexOf(47);
        return iIndexOf < 0 ? str : str.substring(iIndexOf + 1);
    }

    public void addOnClickListeners(MotionLayout motionLayout, int i) {
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if (Transition.access$400(next).size() > 0) {
                Iterator it2 = Transition.access$400(next).iterator();
                while (it2.hasNext()) {
                    ((Transition.TransitionOnClick) it2.next()).removeOnClickListeners(motionLayout);
                }
            }
        }
        Iterator<Transition> it3 = this.mAbstractTransitionList.iterator();
        while (it3.hasNext()) {
            Transition next2 = it3.next();
            if (Transition.access$400(next2).size() > 0) {
                Iterator it4 = Transition.access$400(next2).iterator();
                while (it4.hasNext()) {
                    ((Transition.TransitionOnClick) it4.next()).removeOnClickListeners(motionLayout);
                }
            }
        }
        Iterator<Transition> it5 = this.mTransitionList.iterator();
        while (it5.hasNext()) {
            Transition next3 = it5.next();
            if (Transition.access$400(next3).size() > 0) {
                Iterator it6 = Transition.access$400(next3).iterator();
                while (it6.hasNext()) {
                    ((Transition.TransitionOnClick) it6.next()).addOnClickListeners(motionLayout, i, next3);
                }
            }
        }
        Iterator<Transition> it7 = this.mAbstractTransitionList.iterator();
        while (it7.hasNext()) {
            Transition next4 = it7.next();
            if (Transition.access$400(next4).size() > 0) {
                Iterator it8 = Transition.access$400(next4).iterator();
                while (it8.hasNext()) {
                    ((Transition.TransitionOnClick) it8.next()).addOnClickListeners(motionLayout, i, next4);
                }
            }
        }
    }

    public void addTransition(Transition transition) {
        int index = getIndex(transition);
        if (index == -1) {
            this.mTransitionList.add(transition);
        } else {
            this.mTransitionList.set(index, transition);
        }
    }

    public boolean autoTransition(MotionLayout motionLayout, int i) {
        if (isProcessingTouch() || this.mDisableAutoTransition) {
            return false;
        }
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if (Transition.access$600(next) != 0 && this.mCurrentTransition != next) {
                if (i == Transition.access$100(next) && (Transition.access$600(next) == 4 || Transition.access$600(next) == 2)) {
                    MotionLayout.TransitionState transitionState = MotionLayout.TransitionState.FINISHED;
                    motionLayout.setState(transitionState);
                    motionLayout.setTransition(next);
                    if (Transition.access$600(next) == 4) {
                        motionLayout.transitionToEnd();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.evaluate(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(transitionState);
                        motionLayout.onNewStateAttachHandlers();
                    }
                    return true;
                }
                if (i == Transition.access$000(next) && (Transition.access$600(next) == 3 || Transition.access$600(next) == 1)) {
                    MotionLayout.TransitionState transitionState2 = MotionLayout.TransitionState.FINISHED;
                    motionLayout.setState(transitionState2);
                    motionLayout.setTransition(next);
                    if (Transition.access$600(next) == 3) {
                        motionLayout.transitionToStart();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(0.0f);
                        motionLayout.evaluate(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(transitionState2);
                        motionLayout.onNewStateAttachHandlers();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public Transition bestTransitionFor(int i, float f, float f2, MotionEvent motionEvent) {
        if (i == -1) {
            return this.mCurrentTransition;
        }
        List<Transition> transitionsWithState = getTransitionsWithState(i);
        float f3 = 0.0f;
        Transition transition = null;
        RectF rectF = new RectF();
        for (Transition transition2 : transitionsWithState) {
            if (!Transition.access$500(transition2) && Transition.access$200(transition2) != null) {
                Transition.access$200(transition2).setRTL(this.mRtl);
                RectF touchRegion = Transition.access$200(transition2).getTouchRegion(this.mMotionLayout, rectF);
                if (touchRegion == null || motionEvent == null || touchRegion.contains(motionEvent.getX(), motionEvent.getY())) {
                    RectF touchRegion2 = Transition.access$200(transition2).getTouchRegion(this.mMotionLayout, rectF);
                    if (touchRegion2 == null || motionEvent == null || touchRegion2.contains(motionEvent.getX(), motionEvent.getY())) {
                        float fDot = Transition.access$200(transition2).dot(f, f2) * (Transition.access$000(transition2) == i ? -1.0f : 1.1f);
                        if (fDot > f3) {
                            transition = transition2;
                            f3 = fDot;
                        }
                    }
                }
            }
        }
        return transition;
    }

    public void disableAutoTransition(boolean z2) {
        this.mDisableAutoTransition = z2;
    }

    public int gatPathMotionArc() {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            return Transition.access$1800(transition);
        }
        return -1;
    }

    public ConstraintSet getConstraintSet(Context context, String str) throws Resources.NotFoundException {
        if (this.DEBUG_DESKTOP) {
            System.out.println("id " + str);
            PrintStream printStream = System.out;
            StringBuilder sbU = outline.U("size ");
            sbU.append(this.mConstraintSetMap.size());
            printStream.println(sbU.toString());
        }
        for (int i = 0; i < this.mConstraintSetMap.size(); i++) {
            int iKeyAt = this.mConstraintSetMap.keyAt(i);
            String resourceName = context.getResources().getResourceName(iKeyAt);
            if (this.DEBUG_DESKTOP) {
                System.out.println("Id for <" + i + "> is <" + resourceName + "> looking for <" + str + ">");
            }
            if (str.equals(resourceName)) {
                return this.mConstraintSetMap.get(iKeyAt);
            }
        }
        return null;
    }

    public int[] getConstraintSetIds() {
        int size = this.mConstraintSetMap.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = this.mConstraintSetMap.keyAt(i);
        }
        return iArr;
    }

    public ArrayList<Transition> getDefinedTransitions() {
        return this.mTransitionList;
    }

    public int getDuration() {
        Transition transition = this.mCurrentTransition;
        return transition != null ? Transition.access$1700(transition) : this.mDefaultDuration;
    }

    public int getEndId() {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return -1;
        }
        return Transition.access$000(transition);
    }

    public Interpolator getInterpolator() {
        int iAccess$1400 = Transition.access$1400(this.mCurrentTransition);
        if (iAccess$1400 == -2) {
            return AnimationUtils.loadInterpolator(this.mMotionLayout.getContext(), Transition.access$1600(this.mCurrentTransition));
        }
        if (iAccess$1400 == -1) {
            return new AnonymousClass1(Easing.getInterpolator(Transition.access$1500(this.mCurrentTransition)));
        }
        if (iAccess$1400 == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (iAccess$1400 == 1) {
            return new AccelerateInterpolator();
        }
        if (iAccess$1400 == 2) {
            return new DecelerateInterpolator();
        }
        if (iAccess$1400 == 4) {
            return new AnticipateInterpolator();
        }
        if (iAccess$1400 != 5) {
            return null;
        }
        return new BounceInterpolator();
    }

    public Key getKeyFrame(Context context, int i, int i2, int i3) {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return null;
        }
        Iterator it = Transition.access$1300(transition).iterator();
        while (it.hasNext()) {
            KeyFrames keyFrames = (KeyFrames) it.next();
            for (Integer num : keyFrames.getKeys()) {
                if (i2 == num.intValue()) {
                    Iterator<Key> it2 = keyFrames.getKeyFramesForView(num.intValue()).iterator();
                    while (it2.hasNext()) {
                        Key next = it2.next();
                        if (next.mFramePosition == i3 && next.mType == i) {
                            return next;
                        }
                    }
                }
            }
        }
        return null;
    }

    public void getKeyFrames(MotionController motionController) {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            Iterator it = Transition.access$1300(transition).iterator();
            while (it.hasNext()) {
                ((KeyFrames) it.next()).addFrames(motionController);
            }
        } else {
            Transition transition2 = this.mDefaultTransition;
            if (transition2 != null) {
                Iterator it2 = Transition.access$1300(transition2).iterator();
                while (it2.hasNext()) {
                    ((KeyFrames) it2.next()).addFrames(motionController);
                }
            }
        }
    }

    public float getMaxAcceleration() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || Transition.access$200(transition) == null) {
            return 0.0f;
        }
        return Transition.access$200(this.mCurrentTransition).getMaxAcceleration();
    }

    public float getMaxVelocity() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || Transition.access$200(transition) == null) {
            return 0.0f;
        }
        return Transition.access$200(this.mCurrentTransition).getMaxVelocity();
    }

    public boolean getMoveWhenScrollAtTop() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || Transition.access$200(transition) == null) {
            return false;
        }
        return Transition.access$200(this.mCurrentTransition).getMoveWhenScrollAtTop();
    }

    public float getPathPercent(View view, int i) {
        return 0.0f;
    }

    public float getProgressDirection(float f, float f2) {
        Transition transition = this.mCurrentTransition;
        if (transition == null || Transition.access$200(transition) == null) {
            return 0.0f;
        }
        return Transition.access$200(this.mCurrentTransition).getProgressDirection(f, f2);
    }

    public float getStaggered() {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            return Transition.access$1900(transition);
        }
        return 0.0f;
    }

    public int getStartId() {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return -1;
        }
        return Transition.access$100(transition);
    }

    public Transition getTransitionById(int i) {
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if (Transition.access$300(next) == i) {
                return next;
            }
        }
        return null;
    }

    public int getTransitionDirection(int i) {
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            if (Transition.access$100(it.next()) == i) {
                return 0;
            }
        }
        return 1;
    }

    public List<Transition> getTransitionsWithState(int i) {
        int realID = getRealID(i);
        ArrayList arrayList = new ArrayList();
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if (Transition.access$100(next) == realID || Transition.access$000(next) == realID) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public boolean hasKeyFramePosition(View view, int i) {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return false;
        }
        Iterator it = Transition.access$1300(transition).iterator();
        while (it.hasNext()) {
            Iterator<Key> it2 = ((KeyFrames) it.next()).getKeyFramesForView(view.getId()).iterator();
            while (it2.hasNext()) {
                if (it2.next().mFramePosition == i) {
                    return true;
                }
            }
        }
        return false;
    }

    public int lookUpConstraintId(String str) {
        return this.mConstraintSetIdMap.get(str).intValue();
    }

    public String lookUpConstraintName(int i) {
        for (Map.Entry<String, Integer> entry : this.mConstraintSetIdMap.entrySet()) {
            if (entry.getValue().intValue() == i) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
    }

    public void processScrollMove(float f, float f2) {
        Transition transition = this.mCurrentTransition;
        if (transition == null || Transition.access$200(transition) == null) {
            return;
        }
        Transition.access$200(this.mCurrentTransition).scrollMove(f, f2);
    }

    public void processScrollUp(float f, float f2) {
        Transition transition = this.mCurrentTransition;
        if (transition == null || Transition.access$200(transition) == null) {
            return;
        }
        Transition.access$200(this.mCurrentTransition).scrollUp(f, f2);
    }

    public void processTouchEvent(MotionEvent motionEvent, int i, MotionLayout motionLayout) {
        MotionLayout.MotionTracker motionTracker;
        MotionEvent motionEvent2;
        RectF rectF = new RectF();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = this.mMotionLayout.obtainVelocityTracker();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        if (i != -1) {
            int action = motionEvent.getAction();
            boolean z2 = false;
            if (action == 0) {
                this.mLastTouchX = motionEvent.getRawX();
                this.mLastTouchY = motionEvent.getRawY();
                this.mLastTouchDown = motionEvent;
                this.mIgnoreTouch = false;
                if (Transition.access$200(this.mCurrentTransition) != null) {
                    RectF limitBoundsTo = Transition.access$200(this.mCurrentTransition).getLimitBoundsTo(this.mMotionLayout, rectF);
                    if (limitBoundsTo != null && !limitBoundsTo.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                        this.mLastTouchDown = null;
                        this.mIgnoreTouch = true;
                        return;
                    }
                    RectF touchRegion = Transition.access$200(this.mCurrentTransition).getTouchRegion(this.mMotionLayout, rectF);
                    if (touchRegion == null || touchRegion.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                        this.mMotionOutsideRegion = false;
                    } else {
                        this.mMotionOutsideRegion = true;
                    }
                    Transition.access$200(this.mCurrentTransition).setDown(this.mLastTouchX, this.mLastTouchY);
                    return;
                }
                return;
            }
            if (action == 2 && !this.mIgnoreTouch) {
                float rawY = motionEvent.getRawY() - this.mLastTouchY;
                float rawX = motionEvent.getRawX() - this.mLastTouchX;
                if ((rawX == 0.0d && rawY == 0.0d) || (motionEvent2 = this.mLastTouchDown) == null) {
                    return;
                }
                Transition transitionBestTransitionFor = bestTransitionFor(i, rawX, rawY, motionEvent2);
                if (transitionBestTransitionFor != null) {
                    motionLayout.setTransition(transitionBestTransitionFor);
                    RectF touchRegion2 = Transition.access$200(this.mCurrentTransition).getTouchRegion(this.mMotionLayout, rectF);
                    if (touchRegion2 != null && !touchRegion2.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                        z2 = true;
                    }
                    this.mMotionOutsideRegion = z2;
                    Transition.access$200(this.mCurrentTransition).setUpTouchEvent(this.mLastTouchX, this.mLastTouchY);
                }
            }
        }
        if (this.mIgnoreTouch) {
            return;
        }
        Transition transition = this.mCurrentTransition;
        if (transition != null && Transition.access$200(transition) != null && !this.mMotionOutsideRegion) {
            Transition.access$200(this.mCurrentTransition).processTouchEvent(motionEvent, this.mVelocityTracker, i, this);
        }
        this.mLastTouchX = motionEvent.getRawX();
        this.mLastTouchY = motionEvent.getRawY();
        if (motionEvent.getAction() != 1 || (motionTracker = this.mVelocityTracker) == null) {
            return;
        }
        motionTracker.recycle();
        this.mVelocityTracker = null;
        int i2 = motionLayout.mCurrentState;
        if (i2 != -1) {
            autoTransition(motionLayout, i2);
        }
    }

    public void readFallback(MotionLayout motionLayout) {
        for (int i = 0; i < this.mConstraintSetMap.size(); i++) {
            int iKeyAt = this.mConstraintSetMap.keyAt(i);
            if (hasCycleDependency(iKeyAt)) {
                Log.e(TAG, "Cannot be derived from yourself");
                return;
            }
            readConstraintChain(iKeyAt);
        }
        for (int i2 = 0; i2 < this.mConstraintSetMap.size(); i2++) {
            this.mConstraintSetMap.valueAt(i2).readFallback(motionLayout);
        }
    }

    public void removeTransition(Transition transition) {
        int index = getIndex(transition);
        if (index != -1) {
            this.mTransitionList.remove(index);
        }
    }

    public void setConstraintSet(int i, ConstraintSet constraintSet) {
        this.mConstraintSetMap.put(i, constraintSet);
    }

    public void setDuration(int i) {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            transition.setDuration(i);
        } else {
            this.mDefaultDuration = i;
        }
    }

    public void setKeyframe(View view, int i, String str, Object obj) {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return;
        }
        Iterator it = Transition.access$1300(transition).iterator();
        while (it.hasNext()) {
            Iterator<Key> it2 = ((KeyFrames) it.next()).getKeyFramesForView(view.getId()).iterator();
            while (it2.hasNext()) {
                if (it2.next().mFramePosition == i) {
                    int i2 = ((obj != null ? ((Float) obj).floatValue() : 0.0f) > 0.0f ? 1 : ((obj != null ? ((Float) obj).floatValue() : 0.0f) == 0.0f ? 0 : -1));
                    str.equalsIgnoreCase("app:PerpendicularPath_percent");
                }
            }
        }
    }

    public void setRtl(boolean z2) {
        this.mRtl = z2;
        Transition transition = this.mCurrentTransition;
        if (transition == null || Transition.access$200(transition) == null) {
            return;
        }
        Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setTransition(int i, int i2) {
        int iStateGetConstraintID;
        int iStateGetConstraintID2;
        Iterator<Transition> it;
        Iterator<Transition> it2;
        StateSet stateSet = this.mStateSet;
        if (stateSet != null) {
            iStateGetConstraintID = stateSet.stateGetConstraintID(i, -1, -1);
            if (iStateGetConstraintID == -1) {
                iStateGetConstraintID = i;
            }
            iStateGetConstraintID2 = this.mStateSet.stateGetConstraintID(i2, -1, -1);
            if (iStateGetConstraintID2 == -1) {
            }
            it = this.mTransitionList.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if ((Transition.access$000(next) == iStateGetConstraintID2 && Transition.access$100(next) == iStateGetConstraintID) || (Transition.access$000(next) == i2 && Transition.access$100(next) == i)) {
                    this.mCurrentTransition = next;
                    if (next == null || Transition.access$200(next) == null) {
                        return;
                    }
                    Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);
                    return;
                }
            }
            Transition transition = this.mDefaultTransition;
            it2 = this.mAbstractTransitionList.iterator();
            while (it2.hasNext()) {
                Transition next2 = it2.next();
                if (Transition.access$000(next2) == i2) {
                    transition = next2;
                }
            }
            Transition transition2 = new Transition(this, transition);
            Transition.access$102(transition2, iStateGetConstraintID);
            Transition.access$002(transition2, iStateGetConstraintID2);
            if (iStateGetConstraintID != -1) {
                this.mTransitionList.add(transition2);
            }
            this.mCurrentTransition = transition2;
        }
        iStateGetConstraintID = i;
        iStateGetConstraintID2 = i2;
        it = this.mTransitionList.iterator();
        while (it.hasNext()) {
        }
        Transition transition3 = this.mDefaultTransition;
        it2 = this.mAbstractTransitionList.iterator();
        while (it2.hasNext()) {
        }
        Transition transition22 = new Transition(this, transition3);
        Transition.access$102(transition22, iStateGetConstraintID);
        Transition.access$002(transition22, iStateGetConstraintID2);
        if (iStateGetConstraintID != -1) {
        }
        this.mCurrentTransition = transition22;
    }

    public void setupTouch() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || Transition.access$200(transition) == null) {
            return;
        }
        Transition.access$200(this.mCurrentTransition).setupTouch();
    }

    public boolean supportTouch() {
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            if (Transition.access$200(it.next()) != null) {
                return true;
            }
        }
        Transition transition = this.mCurrentTransition;
        return (transition == null || Transition.access$200(transition) == null) ? false : true;
    }

    public boolean validateLayout(MotionLayout motionLayout) {
        return motionLayout == this.mMotionLayout && motionLayout.mScene == this;
    }

    public ConstraintSet getConstraintSet(int i) {
        return getConstraintSet(i, -1, -1);
    }

    public ConstraintSet getConstraintSet(int i, int i2, int i3) {
        int iStateGetConstraintID;
        if (this.DEBUG_DESKTOP) {
            System.out.println("id " + i);
            PrintStream printStream = System.out;
            StringBuilder sbU = outline.U("size ");
            sbU.append(this.mConstraintSetMap.size());
            printStream.println(sbU.toString());
        }
        StateSet stateSet = this.mStateSet;
        if (stateSet != null && (iStateGetConstraintID = stateSet.stateGetConstraintID(i, i2, i3)) != -1) {
            i = iStateGetConstraintID;
        }
        if (this.mConstraintSetMap.get(i) == null) {
            StringBuilder sbU2 = outline.U("Warning could not find ConstraintSet id/");
            sbU2.append(Debug.getName(this.mMotionLayout.getContext(), i));
            sbU2.append(" In MotionScene");
            Log.e(TAG, sbU2.toString());
            SparseArray<ConstraintSet> sparseArray = this.mConstraintSetMap;
            return sparseArray.get(sparseArray.keyAt(0));
        }
        return this.mConstraintSetMap.get(i);
    }

    public MotionScene(Context context, MotionLayout motionLayout, int i) throws XmlPullParserException, Resources.NotFoundException, IOException {
        this.mMotionLayout = motionLayout;
        load(context, i);
        SparseArray<ConstraintSet> sparseArray = this.mConstraintSetMap;
        int i2 = R.id.motion_base;
        sparseArray.put(i2, new ConstraintSet());
        this.mConstraintSetIdMap.put("motion_base", Integer.valueOf(i2));
    }

    public void setTransition(Transition transition) {
        this.mCurrentTransition = transition;
        if (transition == null || Transition.access$200(transition) == null) {
            return;
        }
        Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);
    }

    public static class Transition {
        public static final int AUTO_ANIMATE_TO_END = 4;
        public static final int AUTO_ANIMATE_TO_START = 3;
        public static final int AUTO_JUMP_TO_END = 2;
        public static final int AUTO_JUMP_TO_START = 1;
        public static final int AUTO_NONE = 0;
        public static final int TRANSITION_FLAG_FIRST_DRAW = 1;
        private int mAutoTransition;
        private int mConstraintSetEnd;
        private int mConstraintSetStart;
        private int mDefaultInterpolator;
        private int mDefaultInterpolatorID;
        private String mDefaultInterpolatorString;
        private boolean mDisable;
        private int mDuration;
        private int mId;
        private boolean mIsAbstract;
        private ArrayList<KeyFrames> mKeyFramesList;
        private int mLayoutDuringTransition;
        private final MotionScene mMotionScene;
        private ArrayList<TransitionOnClick> mOnClicks;
        private int mPathMotionArc;
        private float mStagger;
        private TouchResponse mTouchResponse;
        private int mTransitionFlags;

        public static class TransitionOnClick implements View.OnClickListener {
            public static final int ANIM_TOGGLE = 17;
            public static final int ANIM_TO_END = 1;
            public static final int ANIM_TO_START = 16;
            public static final int JUMP_TO_END = 256;
            public static final int JUMP_TO_START = 4096;
            public int mMode;
            public int mTargetId;
            private final Transition mTransition;

            public TransitionOnClick(Context context, Transition transition, XmlPullParser xmlPullParser) {
                this.mTargetId = -1;
                this.mMode = 17;
                this.mTransition = transition;
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.OnClick);
                int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
                for (int i = 0; i < indexCount; i++) {
                    int index = typedArrayObtainStyledAttributes.getIndex(i);
                    if (index == R.styleable.OnClick_targetId) {
                        this.mTargetId = typedArrayObtainStyledAttributes.getResourceId(index, this.mTargetId);
                    } else if (index == R.styleable.OnClick_clickAction) {
                        this.mMode = typedArrayObtainStyledAttributes.getInt(index, this.mMode);
                    }
                }
                typedArrayObtainStyledAttributes.recycle();
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r6v5, types: [android.view.View] */
            public void addOnClickListeners(MotionLayout motionLayout, int i, Transition transition) {
                int i2 = this.mTargetId;
                MotionLayout motionLayoutFindViewById = motionLayout;
                if (i2 != -1) {
                    motionLayoutFindViewById = motionLayout.findViewById(i2);
                }
                if (motionLayoutFindViewById == null) {
                    StringBuilder sbU = outline.U("OnClick could not find id ");
                    sbU.append(this.mTargetId);
                    Log.e(MotionScene.TAG, sbU.toString());
                    return;
                }
                int iAccess$100 = Transition.access$100(transition);
                int iAccess$000 = Transition.access$000(transition);
                if (iAccess$100 == -1) {
                    motionLayoutFindViewById.setOnClickListener(this);
                    return;
                }
                int i3 = this.mMode;
                boolean z2 = false;
                boolean z3 = ((i3 & 1) != 0 && i == iAccess$100) | ((i3 & 1) != 0 && i == iAccess$100) | ((i3 & 256) != 0 && i == iAccess$100) | ((i3 & 16) != 0 && i == iAccess$000);
                if ((i3 & 4096) != 0 && i == iAccess$000) {
                    z2 = true;
                }
                if (z3 || z2) {
                    motionLayoutFindViewById.setOnClickListener(this);
                }
            }

            public boolean isTransitionViable(Transition transition, MotionLayout motionLayout) {
                Transition transition2 = this.mTransition;
                if (transition2 == transition) {
                    return true;
                }
                int iAccess$000 = Transition.access$000(transition2);
                int iAccess$100 = Transition.access$100(this.mTransition);
                if (iAccess$100 == -1) {
                    return motionLayout.mCurrentState != iAccess$000;
                }
                int i = motionLayout.mCurrentState;
                return i == iAccess$100 || i == iAccess$000;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MotionLayout motionLayoutAccess$800 = MotionScene.access$800(Transition.access$700(this.mTransition));
                if (motionLayoutAccess$800.isInteractionEnabled()) {
                    if (Transition.access$100(this.mTransition) == -1) {
                        int currentState = motionLayoutAccess$800.getCurrentState();
                        if (currentState == -1) {
                            motionLayoutAccess$800.transitionToState(Transition.access$000(this.mTransition));
                            return;
                        }
                        Transition transition = new Transition(Transition.access$700(this.mTransition), this.mTransition);
                        Transition.access$102(transition, currentState);
                        Transition.access$002(transition, Transition.access$000(this.mTransition));
                        motionLayoutAccess$800.setTransition(transition);
                        motionLayoutAccess$800.transitionToEnd();
                        return;
                    }
                    Transition transition2 = Transition.access$700(this.mTransition).mCurrentTransition;
                    int i = this.mMode;
                    boolean z2 = false;
                    boolean z3 = ((i & 1) == 0 && (i & 256) == 0) ? false : true;
                    boolean z4 = ((i & 16) == 0 && (i & 4096) == 0) ? false : true;
                    if (z3 && z4) {
                        Transition transition3 = Transition.access$700(this.mTransition).mCurrentTransition;
                        Transition transition4 = this.mTransition;
                        if (transition3 != transition4) {
                            motionLayoutAccess$800.setTransition(transition4);
                        }
                        if (motionLayoutAccess$800.getCurrentState() != motionLayoutAccess$800.getEndState() && motionLayoutAccess$800.getProgress() <= 0.5f) {
                            z2 = z3;
                            z4 = false;
                        }
                    } else {
                        z2 = z3;
                    }
                    if (isTransitionViable(transition2, motionLayoutAccess$800)) {
                        if (z2 && (this.mMode & 1) != 0) {
                            motionLayoutAccess$800.setTransition(this.mTransition);
                            motionLayoutAccess$800.transitionToEnd();
                            return;
                        }
                        if (z4 && (this.mMode & 16) != 0) {
                            motionLayoutAccess$800.setTransition(this.mTransition);
                            motionLayoutAccess$800.transitionToStart();
                        } else if (z2 && (this.mMode & 256) != 0) {
                            motionLayoutAccess$800.setTransition(this.mTransition);
                            motionLayoutAccess$800.setProgress(1.0f);
                        } else {
                            if (!z4 || (this.mMode & 4096) == 0) {
                                return;
                            }
                            motionLayoutAccess$800.setTransition(this.mTransition);
                            motionLayoutAccess$800.setProgress(0.0f);
                        }
                    }
                }
            }

            public void removeOnClickListeners(MotionLayout motionLayout) {
                int i = this.mTargetId;
                if (i == -1) {
                    return;
                }
                View viewFindViewById = motionLayout.findViewById(i);
                if (viewFindViewById != null) {
                    viewFindViewById.setOnClickListener(null);
                    return;
                }
                StringBuilder sbU = outline.U(" (*)  could not find id ");
                sbU.append(this.mTargetId);
                Log.e(MotionScene.TAG, sbU.toString());
            }
        }

        public Transition(MotionScene motionScene, Transition transition) {
            this.mId = -1;
            this.mIsAbstract = false;
            this.mConstraintSetEnd = -1;
            this.mConstraintSetStart = -1;
            this.mDefaultInterpolator = 0;
            this.mDefaultInterpolatorString = null;
            this.mDefaultInterpolatorID = -1;
            this.mDuration = 400;
            this.mStagger = 0.0f;
            this.mKeyFramesList = new ArrayList<>();
            this.mTouchResponse = null;
            this.mOnClicks = new ArrayList<>();
            this.mAutoTransition = 0;
            this.mDisable = false;
            this.mPathMotionArc = -1;
            this.mLayoutDuringTransition = 0;
            this.mTransitionFlags = 0;
            this.mMotionScene = motionScene;
            if (transition != null) {
                this.mPathMotionArc = transition.mPathMotionArc;
                this.mDefaultInterpolator = transition.mDefaultInterpolator;
                this.mDefaultInterpolatorString = transition.mDefaultInterpolatorString;
                this.mDefaultInterpolatorID = transition.mDefaultInterpolatorID;
                this.mDuration = transition.mDuration;
                this.mKeyFramesList = transition.mKeyFramesList;
                this.mStagger = transition.mStagger;
                this.mLayoutDuringTransition = transition.mLayoutDuringTransition;
            }
        }

        public static /* synthetic */ int access$000(Transition transition) {
            return transition.mConstraintSetEnd;
        }

        public static /* synthetic */ int access$002(Transition transition, int i) {
            transition.mConstraintSetEnd = i;
            return i;
        }

        public static /* synthetic */ int access$100(Transition transition) {
            return transition.mConstraintSetStart;
        }

        public static /* synthetic */ int access$102(Transition transition, int i) {
            transition.mConstraintSetStart = i;
            return i;
        }

        public static /* synthetic */ boolean access$1200(Transition transition) {
            return transition.mIsAbstract;
        }

        public static /* synthetic */ ArrayList access$1300(Transition transition) {
            return transition.mKeyFramesList;
        }

        public static /* synthetic */ int access$1400(Transition transition) {
            return transition.mDefaultInterpolator;
        }

        public static /* synthetic */ String access$1500(Transition transition) {
            return transition.mDefaultInterpolatorString;
        }

        public static /* synthetic */ int access$1600(Transition transition) {
            return transition.mDefaultInterpolatorID;
        }

        public static /* synthetic */ int access$1700(Transition transition) {
            return transition.mDuration;
        }

        public static /* synthetic */ int access$1800(Transition transition) {
            return transition.mPathMotionArc;
        }

        public static /* synthetic */ float access$1900(Transition transition) {
            return transition.mStagger;
        }

        public static /* synthetic */ TouchResponse access$200(Transition transition) {
            return transition.mTouchResponse;
        }

        public static /* synthetic */ TouchResponse access$202(Transition transition, TouchResponse touchResponse) {
            transition.mTouchResponse = touchResponse;
            return touchResponse;
        }

        public static /* synthetic */ int access$300(Transition transition) {
            return transition.mId;
        }

        public static /* synthetic */ ArrayList access$400(Transition transition) {
            return transition.mOnClicks;
        }

        public static /* synthetic */ boolean access$500(Transition transition) {
            return transition.mDisable;
        }

        public static /* synthetic */ int access$600(Transition transition) {
            return transition.mAutoTransition;
        }

        public static /* synthetic */ MotionScene access$700(Transition transition) {
            return transition.mMotionScene;
        }

        private void fill(MotionScene motionScene, Context context, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                if (index == R.styleable.Transition_constraintSetEnd) {
                    this.mConstraintSetEnd = typedArray.getResourceId(index, this.mConstraintSetEnd);
                    if ("layout".equals(context.getResources().getResourceTypeName(this.mConstraintSetEnd))) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        constraintSet.load(context, this.mConstraintSetEnd);
                        MotionScene.access$1100(motionScene).append(this.mConstraintSetEnd, constraintSet);
                    }
                } else if (index == R.styleable.Transition_constraintSetStart) {
                    this.mConstraintSetStart = typedArray.getResourceId(index, this.mConstraintSetStart);
                    if ("layout".equals(context.getResources().getResourceTypeName(this.mConstraintSetStart))) {
                        ConstraintSet constraintSet2 = new ConstraintSet();
                        constraintSet2.load(context, this.mConstraintSetStart);
                        MotionScene.access$1100(motionScene).append(this.mConstraintSetStart, constraintSet2);
                    }
                } else if (index == R.styleable.Transition_motionInterpolator) {
                    int i2 = typedArray.peekValue(index).type;
                    if (i2 == 1) {
                        int resourceId = typedArray.getResourceId(index, -1);
                        this.mDefaultInterpolatorID = resourceId;
                        if (resourceId != -1) {
                            this.mDefaultInterpolator = -2;
                        }
                    } else if (i2 == 3) {
                        String string = typedArray.getString(index);
                        this.mDefaultInterpolatorString = string;
                        if (string.indexOf(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN) > 0) {
                            this.mDefaultInterpolatorID = typedArray.getResourceId(index, -1);
                            this.mDefaultInterpolator = -2;
                        } else {
                            this.mDefaultInterpolator = -1;
                        }
                    } else {
                        this.mDefaultInterpolator = typedArray.getInteger(index, this.mDefaultInterpolator);
                    }
                } else if (index == R.styleable.Transition_duration) {
                    this.mDuration = typedArray.getInt(index, this.mDuration);
                } else if (index == R.styleable.Transition_staggered) {
                    this.mStagger = typedArray.getFloat(index, this.mStagger);
                } else if (index == R.styleable.Transition_autoTransition) {
                    this.mAutoTransition = typedArray.getInteger(index, this.mAutoTransition);
                } else if (index == R.styleable.Transition_android_id) {
                    this.mId = typedArray.getResourceId(index, this.mId);
                } else if (index == R.styleable.Transition_transitionDisable) {
                    this.mDisable = typedArray.getBoolean(index, this.mDisable);
                } else if (index == R.styleable.Transition_pathMotionArc) {
                    this.mPathMotionArc = typedArray.getInteger(index, -1);
                } else if (index == R.styleable.Transition_layoutDuringTransition) {
                    this.mLayoutDuringTransition = typedArray.getInteger(index, 0);
                } else if (index == R.styleable.Transition_transitionFlags) {
                    this.mTransitionFlags = typedArray.getInteger(index, 0);
                }
            }
            if (this.mConstraintSetStart == -1) {
                this.mIsAbstract = true;
            }
        }

        private void fillFromAttributeList(MotionScene motionScene, Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Transition);
            fill(motionScene, context, typedArrayObtainStyledAttributes);
            typedArrayObtainStyledAttributes.recycle();
        }

        public void addOnClick(Context context, XmlPullParser xmlPullParser) {
            this.mOnClicks.add(new TransitionOnClick(context, this, xmlPullParser));
        }

        public String debugString(Context context) {
            String resourceEntryName = this.mConstraintSetStart == -1 ? "null" : context.getResources().getResourceEntryName(this.mConstraintSetStart);
            if (this.mConstraintSetEnd == -1) {
                return outline.w(resourceEntryName, " -> null");
            }
            StringBuilder sbX = outline.X(resourceEntryName, " -> ");
            sbX.append(context.getResources().getResourceEntryName(this.mConstraintSetEnd));
            return sbX.toString();
        }

        public int getAutoTransition() {
            return this.mAutoTransition;
        }

        public int getDuration() {
            return this.mDuration;
        }

        public int getEndConstraintSetId() {
            return this.mConstraintSetEnd;
        }

        public int getId() {
            return this.mId;
        }

        public List<KeyFrames> getKeyFrameList() {
            return this.mKeyFramesList;
        }

        public int getLayoutDuringTransition() {
            return this.mLayoutDuringTransition;
        }

        public List<TransitionOnClick> getOnClickList() {
            return this.mOnClicks;
        }

        public int getPathMotionArc() {
            return this.mPathMotionArc;
        }

        public float getStagger() {
            return this.mStagger;
        }

        public int getStartConstraintSetId() {
            return this.mConstraintSetStart;
        }

        public TouchResponse getTouchResponse() {
            return this.mTouchResponse;
        }

        public boolean isEnabled() {
            return !this.mDisable;
        }

        public boolean isTransitionFlag(int i) {
            return (i & this.mTransitionFlags) != 0;
        }

        public void setAutoTransition(int i) {
            this.mAutoTransition = i;
        }

        public void setDuration(int i) {
            this.mDuration = i;
        }

        public void setEnable(boolean z2) {
            this.mDisable = !z2;
        }

        public void setPathMotionArc(int i) {
            this.mPathMotionArc = i;
        }

        public void setStagger(float f) {
            this.mStagger = f;
        }

        public Transition(int i, MotionScene motionScene, int i2, int i3) {
            this.mId = -1;
            this.mIsAbstract = false;
            this.mConstraintSetEnd = -1;
            this.mConstraintSetStart = -1;
            this.mDefaultInterpolator = 0;
            this.mDefaultInterpolatorString = null;
            this.mDefaultInterpolatorID = -1;
            this.mDuration = 400;
            this.mStagger = 0.0f;
            this.mKeyFramesList = new ArrayList<>();
            this.mTouchResponse = null;
            this.mOnClicks = new ArrayList<>();
            this.mAutoTransition = 0;
            this.mDisable = false;
            this.mPathMotionArc = -1;
            this.mLayoutDuringTransition = 0;
            this.mTransitionFlags = 0;
            this.mId = i;
            this.mMotionScene = motionScene;
            this.mConstraintSetStart = i2;
            this.mConstraintSetEnd = i3;
            this.mDuration = MotionScene.access$900(motionScene);
            this.mLayoutDuringTransition = MotionScene.access$1000(motionScene);
        }

        public Transition(MotionScene motionScene, Context context, XmlPullParser xmlPullParser) {
            this.mId = -1;
            this.mIsAbstract = false;
            this.mConstraintSetEnd = -1;
            this.mConstraintSetStart = -1;
            this.mDefaultInterpolator = 0;
            this.mDefaultInterpolatorString = null;
            this.mDefaultInterpolatorID = -1;
            this.mDuration = 400;
            this.mStagger = 0.0f;
            this.mKeyFramesList = new ArrayList<>();
            this.mTouchResponse = null;
            this.mOnClicks = new ArrayList<>();
            this.mAutoTransition = 0;
            this.mDisable = false;
            this.mPathMotionArc = -1;
            this.mLayoutDuringTransition = 0;
            this.mTransitionFlags = 0;
            this.mDuration = MotionScene.access$900(motionScene);
            this.mLayoutDuringTransition = MotionScene.access$1000(motionScene);
            this.mMotionScene = motionScene;
            fillFromAttributeList(motionScene, context, Xml.asAttributeSet(xmlPullParser));
        }
    }
}
