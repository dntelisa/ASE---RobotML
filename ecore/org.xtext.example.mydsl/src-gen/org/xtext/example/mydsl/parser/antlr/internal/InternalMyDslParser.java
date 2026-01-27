package org.xtext.example.mydsl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.example.mydsl.services.MyDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMyDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Programme'", "'{'", "'funcdecl'", "','", "'}'", "'FuncDecl'", "'type'", "'statementlist'", "'StatementList'", "'state'", "'Bool'", "'Number'", "'unit'", "'Void'", "'FuncCall'", "'VarAssign'", "'vardecl'", "'expression'", "'VarDecl'", "'Movement'", "'side'", "'distance'", "'Clock'", "'ControlStructure'", "'condition'", "'Loop'", "'body'", "'Conditional'", "'ifBody'", "'elseBody'", "'SetSpeed'", "'speed'", "'VariableRef'", "'val'", "'BoolLiteral'", "'NumLiteral'", "'BoolUnaryOperation'", "'operand'", "'NumUnaryOperation'", "'BoolBinaryOperation'", "'operands'", "'NumBinaryOperation'", "'SensorAccess'", "'sensorType'", "'-'", "'cm'", "'mm'", "'none'", "'deg'", "'rad'", "'NOT'", "'MINUS'", "'PLUS'", "'EQ'", "'NEQ'", "'LEQ'", "'GEQ'", "'LE'", "'GR'", "'MULTIPLY'", "'DIVIDE'", "'Distance'", "'Time'", "'Battery'", "'Backward'", "'Forward'", "'Sideleft'", "'Sideright'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=5;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__77=77;
    public static final int T__34=34;
    public static final int T__78=78;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__74=74;
    public static final int T__31=31;
    public static final int T__75=75;
    public static final int T__32=32;
    public static final int T__76=76;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalMyDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMyDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMyDslParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMyDsl.g"; }



     	private MyDslGrammarAccess grammarAccess;

        public InternalMyDslParser(TokenStream input, MyDslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Programme";
       	}

       	@Override
       	protected MyDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleProgramme"
    // InternalMyDsl.g:65:1: entryRuleProgramme returns [EObject current=null] : iv_ruleProgramme= ruleProgramme EOF ;
    public final EObject entryRuleProgramme() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgramme = null;


        try {
            // InternalMyDsl.g:65:50: (iv_ruleProgramme= ruleProgramme EOF )
            // InternalMyDsl.g:66:2: iv_ruleProgramme= ruleProgramme EOF
            {
             newCompositeNode(grammarAccess.getProgrammeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProgramme=ruleProgramme();

            state._fsp--;

             current =iv_ruleProgramme; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProgramme"


    // $ANTLR start "ruleProgramme"
    // InternalMyDsl.g:72:1: ruleProgramme returns [EObject current=null] : ( () otherlv_1= 'Programme' otherlv_2= '{' (otherlv_3= 'funcdecl' otherlv_4= '{' ( (lv_funcdecl_5_0= ruleFuncDecl ) ) (otherlv_6= ',' ( (lv_funcdecl_7_0= ruleFuncDecl ) ) )* otherlv_8= '}' )? otherlv_9= '}' ) ;
    public final EObject ruleProgramme() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        EObject lv_funcdecl_5_0 = null;

        EObject lv_funcdecl_7_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:78:2: ( ( () otherlv_1= 'Programme' otherlv_2= '{' (otherlv_3= 'funcdecl' otherlv_4= '{' ( (lv_funcdecl_5_0= ruleFuncDecl ) ) (otherlv_6= ',' ( (lv_funcdecl_7_0= ruleFuncDecl ) ) )* otherlv_8= '}' )? otherlv_9= '}' ) )
            // InternalMyDsl.g:79:2: ( () otherlv_1= 'Programme' otherlv_2= '{' (otherlv_3= 'funcdecl' otherlv_4= '{' ( (lv_funcdecl_5_0= ruleFuncDecl ) ) (otherlv_6= ',' ( (lv_funcdecl_7_0= ruleFuncDecl ) ) )* otherlv_8= '}' )? otherlv_9= '}' )
            {
            // InternalMyDsl.g:79:2: ( () otherlv_1= 'Programme' otherlv_2= '{' (otherlv_3= 'funcdecl' otherlv_4= '{' ( (lv_funcdecl_5_0= ruleFuncDecl ) ) (otherlv_6= ',' ( (lv_funcdecl_7_0= ruleFuncDecl ) ) )* otherlv_8= '}' )? otherlv_9= '}' )
            // InternalMyDsl.g:80:3: () otherlv_1= 'Programme' otherlv_2= '{' (otherlv_3= 'funcdecl' otherlv_4= '{' ( (lv_funcdecl_5_0= ruleFuncDecl ) ) (otherlv_6= ',' ( (lv_funcdecl_7_0= ruleFuncDecl ) ) )* otherlv_8= '}' )? otherlv_9= '}'
            {
            // InternalMyDsl.g:80:3: ()
            // InternalMyDsl.g:81:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getProgrammeAccess().getProgrammeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getProgrammeAccess().getProgrammeKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getProgrammeAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:95:3: (otherlv_3= 'funcdecl' otherlv_4= '{' ( (lv_funcdecl_5_0= ruleFuncDecl ) ) (otherlv_6= ',' ( (lv_funcdecl_7_0= ruleFuncDecl ) ) )* otherlv_8= '}' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalMyDsl.g:96:4: otherlv_3= 'funcdecl' otherlv_4= '{' ( (lv_funcdecl_5_0= ruleFuncDecl ) ) (otherlv_6= ',' ( (lv_funcdecl_7_0= ruleFuncDecl ) ) )* otherlv_8= '}'
                    {
                    otherlv_3=(Token)match(input,13,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getProgrammeAccess().getFuncdeclKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,12,FOLLOW_5); 

                    				newLeafNode(otherlv_4, grammarAccess.getProgrammeAccess().getLeftCurlyBracketKeyword_3_1());
                    			
                    // InternalMyDsl.g:104:4: ( (lv_funcdecl_5_0= ruleFuncDecl ) )
                    // InternalMyDsl.g:105:5: (lv_funcdecl_5_0= ruleFuncDecl )
                    {
                    // InternalMyDsl.g:105:5: (lv_funcdecl_5_0= ruleFuncDecl )
                    // InternalMyDsl.g:106:6: lv_funcdecl_5_0= ruleFuncDecl
                    {

                    						newCompositeNode(grammarAccess.getProgrammeAccess().getFuncdeclFuncDeclParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_6);
                    lv_funcdecl_5_0=ruleFuncDecl();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getProgrammeRule());
                    						}
                    						add(
                    							current,
                    							"funcdecl",
                    							lv_funcdecl_5_0,
                    							"org.xtext.example.mydsl.MyDsl.FuncDecl");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:123:4: (otherlv_6= ',' ( (lv_funcdecl_7_0= ruleFuncDecl ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==14) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // InternalMyDsl.g:124:5: otherlv_6= ',' ( (lv_funcdecl_7_0= ruleFuncDecl ) )
                    	    {
                    	    otherlv_6=(Token)match(input,14,FOLLOW_5); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getProgrammeAccess().getCommaKeyword_3_3_0());
                    	    				
                    	    // InternalMyDsl.g:128:5: ( (lv_funcdecl_7_0= ruleFuncDecl ) )
                    	    // InternalMyDsl.g:129:6: (lv_funcdecl_7_0= ruleFuncDecl )
                    	    {
                    	    // InternalMyDsl.g:129:6: (lv_funcdecl_7_0= ruleFuncDecl )
                    	    // InternalMyDsl.g:130:7: lv_funcdecl_7_0= ruleFuncDecl
                    	    {

                    	    							newCompositeNode(grammarAccess.getProgrammeAccess().getFuncdeclFuncDeclParserRuleCall_3_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_6);
                    	    lv_funcdecl_7_0=ruleFuncDecl();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getProgrammeRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"funcdecl",
                    	    								lv_funcdecl_7_0,
                    	    								"org.xtext.example.mydsl.MyDsl.FuncDecl");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,15,FOLLOW_7); 

                    				newLeafNode(otherlv_8, grammarAccess.getProgrammeAccess().getRightCurlyBracketKeyword_3_4());
                    			

                    }
                    break;

            }

            otherlv_9=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getProgrammeAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProgramme"


    // $ANTLR start "entryRuleType"
    // InternalMyDsl.g:161:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // InternalMyDsl.g:161:45: (iv_ruleType= ruleType EOF )
            // InternalMyDsl.g:162:2: iv_ruleType= ruleType EOF
            {
             newCompositeNode(grammarAccess.getTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleType=ruleType();

            state._fsp--;

             current =iv_ruleType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // InternalMyDsl.g:168:1: ruleType returns [EObject current=null] : (this_Bool_0= ruleBool | this_Number_1= ruleNumber | this_Void_2= ruleVoid ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        EObject this_Bool_0 = null;

        EObject this_Number_1 = null;

        EObject this_Void_2 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:174:2: ( (this_Bool_0= ruleBool | this_Number_1= ruleNumber | this_Void_2= ruleVoid ) )
            // InternalMyDsl.g:175:2: (this_Bool_0= ruleBool | this_Number_1= ruleNumber | this_Void_2= ruleVoid )
            {
            // InternalMyDsl.g:175:2: (this_Bool_0= ruleBool | this_Number_1= ruleNumber | this_Void_2= ruleVoid )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt3=1;
                }
                break;
            case 22:
                {
                alt3=2;
                }
                break;
            case 24:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalMyDsl.g:176:3: this_Bool_0= ruleBool
                    {

                    			newCompositeNode(grammarAccess.getTypeAccess().getBoolParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Bool_0=ruleBool();

                    state._fsp--;


                    			current = this_Bool_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:185:3: this_Number_1= ruleNumber
                    {

                    			newCompositeNode(grammarAccess.getTypeAccess().getNumberParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Number_1=ruleNumber();

                    state._fsp--;


                    			current = this_Number_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:194:3: this_Void_2= ruleVoid
                    {

                    			newCompositeNode(grammarAccess.getTypeAccess().getVoidParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Void_2=ruleVoid();

                    state._fsp--;


                    			current = this_Void_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleStatement"
    // InternalMyDsl.g:206:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalMyDsl.g:206:50: (iv_ruleStatement= ruleStatement EOF )
            // InternalMyDsl.g:207:2: iv_ruleStatement= ruleStatement EOF
            {
             newCompositeNode(grammarAccess.getStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStatement=ruleStatement();

            state._fsp--;

             current =iv_ruleStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // InternalMyDsl.g:213:1: ruleStatement returns [EObject current=null] : (this_FuncCall_0= ruleFuncCall | this_VarAssign_1= ruleVarAssign | this_VarDecl_2= ruleVarDecl | this_Movement_3= ruleMovement | this_Clock_4= ruleClock | this_ControlStructure_Impl_5= ruleControlStructure_Impl | this_Loop_6= ruleLoop | this_Conditional_7= ruleConditional | this_SetSpeed_8= ruleSetSpeed ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_FuncCall_0 = null;

        EObject this_VarAssign_1 = null;

        EObject this_VarDecl_2 = null;

        EObject this_Movement_3 = null;

        EObject this_Clock_4 = null;

        EObject this_ControlStructure_Impl_5 = null;

        EObject this_Loop_6 = null;

        EObject this_Conditional_7 = null;

        EObject this_SetSpeed_8 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:219:2: ( (this_FuncCall_0= ruleFuncCall | this_VarAssign_1= ruleVarAssign | this_VarDecl_2= ruleVarDecl | this_Movement_3= ruleMovement | this_Clock_4= ruleClock | this_ControlStructure_Impl_5= ruleControlStructure_Impl | this_Loop_6= ruleLoop | this_Conditional_7= ruleConditional | this_SetSpeed_8= ruleSetSpeed ) )
            // InternalMyDsl.g:220:2: (this_FuncCall_0= ruleFuncCall | this_VarAssign_1= ruleVarAssign | this_VarDecl_2= ruleVarDecl | this_Movement_3= ruleMovement | this_Clock_4= ruleClock | this_ControlStructure_Impl_5= ruleControlStructure_Impl | this_Loop_6= ruleLoop | this_Conditional_7= ruleConditional | this_SetSpeed_8= ruleSetSpeed )
            {
            // InternalMyDsl.g:220:2: (this_FuncCall_0= ruleFuncCall | this_VarAssign_1= ruleVarAssign | this_VarDecl_2= ruleVarDecl | this_Movement_3= ruleMovement | this_Clock_4= ruleClock | this_ControlStructure_Impl_5= ruleControlStructure_Impl | this_Loop_6= ruleLoop | this_Conditional_7= ruleConditional | this_SetSpeed_8= ruleSetSpeed )
            int alt4=9;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt4=1;
                }
                break;
            case 26:
                {
                alt4=2;
                }
                break;
            case 29:
                {
                alt4=3;
                }
                break;
            case 30:
                {
                alt4=4;
                }
                break;
            case 33:
                {
                alt4=5;
                }
                break;
            case 34:
                {
                alt4=6;
                }
                break;
            case 36:
                {
                alt4=7;
                }
                break;
            case 38:
                {
                alt4=8;
                }
                break;
            case 41:
                {
                alt4=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalMyDsl.g:221:3: this_FuncCall_0= ruleFuncCall
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getFuncCallParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_FuncCall_0=ruleFuncCall();

                    state._fsp--;


                    			current = this_FuncCall_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:230:3: this_VarAssign_1= ruleVarAssign
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getVarAssignParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_VarAssign_1=ruleVarAssign();

                    state._fsp--;


                    			current = this_VarAssign_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:239:3: this_VarDecl_2= ruleVarDecl
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getVarDeclParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_VarDecl_2=ruleVarDecl();

                    state._fsp--;


                    			current = this_VarDecl_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:248:3: this_Movement_3= ruleMovement
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getMovementParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Movement_3=ruleMovement();

                    state._fsp--;


                    			current = this_Movement_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:257:3: this_Clock_4= ruleClock
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getClockParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_Clock_4=ruleClock();

                    state._fsp--;


                    			current = this_Clock_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalMyDsl.g:266:3: this_ControlStructure_Impl_5= ruleControlStructure_Impl
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getControlStructure_ImplParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_ControlStructure_Impl_5=ruleControlStructure_Impl();

                    state._fsp--;


                    			current = this_ControlStructure_Impl_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalMyDsl.g:275:3: this_Loop_6= ruleLoop
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getLoopParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_Loop_6=ruleLoop();

                    state._fsp--;


                    			current = this_Loop_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalMyDsl.g:284:3: this_Conditional_7= ruleConditional
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getConditionalParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_Conditional_7=ruleConditional();

                    state._fsp--;


                    			current = this_Conditional_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 9 :
                    // InternalMyDsl.g:293:3: this_SetSpeed_8= ruleSetSpeed
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getSetSpeedParserRuleCall_8());
                    		
                    pushFollow(FOLLOW_2);
                    this_SetSpeed_8=ruleSetSpeed();

                    state._fsp--;


                    			current = this_SetSpeed_8;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleExpression"
    // InternalMyDsl.g:305:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalMyDsl.g:305:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalMyDsl.g:306:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalMyDsl.g:312:1: ruleExpression returns [EObject current=null] : (this_FuncCall_0= ruleFuncCall | this_VariableRef_1= ruleVariableRef | this_BoolLiteral_2= ruleBoolLiteral | this_NumLiteral_3= ruleNumLiteral | this_BoolUnaryOperation_4= ruleBoolUnaryOperation | this_NumUnaryOperation_5= ruleNumUnaryOperation | this_BoolBinaryOperation_6= ruleBoolBinaryOperation | this_NumBinaryOperation_7= ruleNumBinaryOperation | this_SensorAccess_8= ruleSensorAccess ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_FuncCall_0 = null;

        EObject this_VariableRef_1 = null;

        EObject this_BoolLiteral_2 = null;

        EObject this_NumLiteral_3 = null;

        EObject this_BoolUnaryOperation_4 = null;

        EObject this_NumUnaryOperation_5 = null;

        EObject this_BoolBinaryOperation_6 = null;

        EObject this_NumBinaryOperation_7 = null;

        EObject this_SensorAccess_8 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:318:2: ( (this_FuncCall_0= ruleFuncCall | this_VariableRef_1= ruleVariableRef | this_BoolLiteral_2= ruleBoolLiteral | this_NumLiteral_3= ruleNumLiteral | this_BoolUnaryOperation_4= ruleBoolUnaryOperation | this_NumUnaryOperation_5= ruleNumUnaryOperation | this_BoolBinaryOperation_6= ruleBoolBinaryOperation | this_NumBinaryOperation_7= ruleNumBinaryOperation | this_SensorAccess_8= ruleSensorAccess ) )
            // InternalMyDsl.g:319:2: (this_FuncCall_0= ruleFuncCall | this_VariableRef_1= ruleVariableRef | this_BoolLiteral_2= ruleBoolLiteral | this_NumLiteral_3= ruleNumLiteral | this_BoolUnaryOperation_4= ruleBoolUnaryOperation | this_NumUnaryOperation_5= ruleNumUnaryOperation | this_BoolBinaryOperation_6= ruleBoolBinaryOperation | this_NumBinaryOperation_7= ruleNumBinaryOperation | this_SensorAccess_8= ruleSensorAccess )
            {
            // InternalMyDsl.g:319:2: (this_FuncCall_0= ruleFuncCall | this_VariableRef_1= ruleVariableRef | this_BoolLiteral_2= ruleBoolLiteral | this_NumLiteral_3= ruleNumLiteral | this_BoolUnaryOperation_4= ruleBoolUnaryOperation | this_NumUnaryOperation_5= ruleNumUnaryOperation | this_BoolBinaryOperation_6= ruleBoolBinaryOperation | this_NumBinaryOperation_7= ruleNumBinaryOperation | this_SensorAccess_8= ruleSensorAccess )
            int alt5=9;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt5=1;
                }
                break;
            case 43:
                {
                alt5=2;
                }
                break;
            case 44:
            case 45:
                {
                alt5=3;
                }
                break;
            case 46:
                {
                alt5=4;
                }
                break;
            case 47:
                {
                alt5=5;
                }
                break;
            case 49:
                {
                alt5=6;
                }
                break;
            case 50:
                {
                alt5=7;
                }
                break;
            case 52:
                {
                alt5=8;
                }
                break;
            case 53:
                {
                alt5=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalMyDsl.g:320:3: this_FuncCall_0= ruleFuncCall
                    {

                    			newCompositeNode(grammarAccess.getExpressionAccess().getFuncCallParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_FuncCall_0=ruleFuncCall();

                    state._fsp--;


                    			current = this_FuncCall_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:329:3: this_VariableRef_1= ruleVariableRef
                    {

                    			newCompositeNode(grammarAccess.getExpressionAccess().getVariableRefParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_VariableRef_1=ruleVariableRef();

                    state._fsp--;


                    			current = this_VariableRef_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:338:3: this_BoolLiteral_2= ruleBoolLiteral
                    {

                    			newCompositeNode(grammarAccess.getExpressionAccess().getBoolLiteralParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_BoolLiteral_2=ruleBoolLiteral();

                    state._fsp--;


                    			current = this_BoolLiteral_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:347:3: this_NumLiteral_3= ruleNumLiteral
                    {

                    			newCompositeNode(grammarAccess.getExpressionAccess().getNumLiteralParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_NumLiteral_3=ruleNumLiteral();

                    state._fsp--;


                    			current = this_NumLiteral_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:356:3: this_BoolUnaryOperation_4= ruleBoolUnaryOperation
                    {

                    			newCompositeNode(grammarAccess.getExpressionAccess().getBoolUnaryOperationParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_BoolUnaryOperation_4=ruleBoolUnaryOperation();

                    state._fsp--;


                    			current = this_BoolUnaryOperation_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalMyDsl.g:365:3: this_NumUnaryOperation_5= ruleNumUnaryOperation
                    {

                    			newCompositeNode(grammarAccess.getExpressionAccess().getNumUnaryOperationParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_NumUnaryOperation_5=ruleNumUnaryOperation();

                    state._fsp--;


                    			current = this_NumUnaryOperation_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalMyDsl.g:374:3: this_BoolBinaryOperation_6= ruleBoolBinaryOperation
                    {

                    			newCompositeNode(grammarAccess.getExpressionAccess().getBoolBinaryOperationParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_BoolBinaryOperation_6=ruleBoolBinaryOperation();

                    state._fsp--;


                    			current = this_BoolBinaryOperation_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalMyDsl.g:383:3: this_NumBinaryOperation_7= ruleNumBinaryOperation
                    {

                    			newCompositeNode(grammarAccess.getExpressionAccess().getNumBinaryOperationParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_NumBinaryOperation_7=ruleNumBinaryOperation();

                    state._fsp--;


                    			current = this_NumBinaryOperation_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 9 :
                    // InternalMyDsl.g:392:3: this_SensorAccess_8= ruleSensorAccess
                    {

                    			newCompositeNode(grammarAccess.getExpressionAccess().getSensorAccessParserRuleCall_8());
                    		
                    pushFollow(FOLLOW_2);
                    this_SensorAccess_8=ruleSensorAccess();

                    state._fsp--;


                    			current = this_SensorAccess_8;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleTypeVar"
    // InternalMyDsl.g:404:1: entryRuleTypeVar returns [EObject current=null] : iv_ruleTypeVar= ruleTypeVar EOF ;
    public final EObject entryRuleTypeVar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeVar = null;


        try {
            // InternalMyDsl.g:404:48: (iv_ruleTypeVar= ruleTypeVar EOF )
            // InternalMyDsl.g:405:2: iv_ruleTypeVar= ruleTypeVar EOF
            {
             newCompositeNode(grammarAccess.getTypeVarRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTypeVar=ruleTypeVar();

            state._fsp--;

             current =iv_ruleTypeVar; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeVar"


    // $ANTLR start "ruleTypeVar"
    // InternalMyDsl.g:411:1: ruleTypeVar returns [EObject current=null] : (this_Bool_0= ruleBool | this_Number_1= ruleNumber ) ;
    public final EObject ruleTypeVar() throws RecognitionException {
        EObject current = null;

        EObject this_Bool_0 = null;

        EObject this_Number_1 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:417:2: ( (this_Bool_0= ruleBool | this_Number_1= ruleNumber ) )
            // InternalMyDsl.g:418:2: (this_Bool_0= ruleBool | this_Number_1= ruleNumber )
            {
            // InternalMyDsl.g:418:2: (this_Bool_0= ruleBool | this_Number_1= ruleNumber )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==21) ) {
                alt6=1;
            }
            else if ( (LA6_0==22) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalMyDsl.g:419:3: this_Bool_0= ruleBool
                    {

                    			newCompositeNode(grammarAccess.getTypeVarAccess().getBoolParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Bool_0=ruleBool();

                    state._fsp--;


                    			current = this_Bool_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:428:3: this_Number_1= ruleNumber
                    {

                    			newCompositeNode(grammarAccess.getTypeVarAccess().getNumberParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Number_1=ruleNumber();

                    state._fsp--;


                    			current = this_Number_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeVar"


    // $ANTLR start "entryRuleFuncDecl"
    // InternalMyDsl.g:440:1: entryRuleFuncDecl returns [EObject current=null] : iv_ruleFuncDecl= ruleFuncDecl EOF ;
    public final EObject entryRuleFuncDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFuncDecl = null;


        try {
            // InternalMyDsl.g:440:49: (iv_ruleFuncDecl= ruleFuncDecl EOF )
            // InternalMyDsl.g:441:2: iv_ruleFuncDecl= ruleFuncDecl EOF
            {
             newCompositeNode(grammarAccess.getFuncDeclRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFuncDecl=ruleFuncDecl();

            state._fsp--;

             current =iv_ruleFuncDecl; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFuncDecl"


    // $ANTLR start "ruleFuncDecl"
    // InternalMyDsl.g:447:1: ruleFuncDecl returns [EObject current=null] : (otherlv_0= 'FuncDecl' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'type' ( (lv_type_4_0= ruleType ) ) otherlv_5= 'statementlist' ( (lv_statementlist_6_0= ruleStatementList ) ) otherlv_7= '}' ) ;
    public final EObject ruleFuncDecl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_type_4_0 = null;

        EObject lv_statementlist_6_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:453:2: ( (otherlv_0= 'FuncDecl' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'type' ( (lv_type_4_0= ruleType ) ) otherlv_5= 'statementlist' ( (lv_statementlist_6_0= ruleStatementList ) ) otherlv_7= '}' ) )
            // InternalMyDsl.g:454:2: (otherlv_0= 'FuncDecl' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'type' ( (lv_type_4_0= ruleType ) ) otherlv_5= 'statementlist' ( (lv_statementlist_6_0= ruleStatementList ) ) otherlv_7= '}' )
            {
            // InternalMyDsl.g:454:2: (otherlv_0= 'FuncDecl' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'type' ( (lv_type_4_0= ruleType ) ) otherlv_5= 'statementlist' ( (lv_statementlist_6_0= ruleStatementList ) ) otherlv_7= '}' )
            // InternalMyDsl.g:455:3: otherlv_0= 'FuncDecl' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'type' ( (lv_type_4_0= ruleType ) ) otherlv_5= 'statementlist' ( (lv_statementlist_6_0= ruleStatementList ) ) otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getFuncDeclAccess().getFuncDeclKeyword_0());
            		
            // InternalMyDsl.g:459:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:460:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:460:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:461:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getFuncDeclAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFuncDeclRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_9); 

            			newLeafNode(otherlv_2, grammarAccess.getFuncDeclAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,17,FOLLOW_10); 

            			newLeafNode(otherlv_3, grammarAccess.getFuncDeclAccess().getTypeKeyword_3());
            		
            // InternalMyDsl.g:486:3: ( (lv_type_4_0= ruleType ) )
            // InternalMyDsl.g:487:4: (lv_type_4_0= ruleType )
            {
            // InternalMyDsl.g:487:4: (lv_type_4_0= ruleType )
            // InternalMyDsl.g:488:5: lv_type_4_0= ruleType
            {

            					newCompositeNode(grammarAccess.getFuncDeclAccess().getTypeTypeParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_11);
            lv_type_4_0=ruleType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFuncDeclRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_4_0,
            						"org.xtext.example.mydsl.MyDsl.Type");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,18,FOLLOW_12); 

            			newLeafNode(otherlv_5, grammarAccess.getFuncDeclAccess().getStatementlistKeyword_5());
            		
            // InternalMyDsl.g:509:3: ( (lv_statementlist_6_0= ruleStatementList ) )
            // InternalMyDsl.g:510:4: (lv_statementlist_6_0= ruleStatementList )
            {
            // InternalMyDsl.g:510:4: (lv_statementlist_6_0= ruleStatementList )
            // InternalMyDsl.g:511:5: lv_statementlist_6_0= ruleStatementList
            {

            					newCompositeNode(grammarAccess.getFuncDeclAccess().getStatementlistStatementListParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_7);
            lv_statementlist_6_0=ruleStatementList();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFuncDeclRule());
            					}
            					set(
            						current,
            						"statementlist",
            						lv_statementlist_6_0,
            						"org.xtext.example.mydsl.MyDsl.StatementList");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getFuncDeclAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFuncDecl"


    // $ANTLR start "entryRuleStatementList"
    // InternalMyDsl.g:536:1: entryRuleStatementList returns [EObject current=null] : iv_ruleStatementList= ruleStatementList EOF ;
    public final EObject entryRuleStatementList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatementList = null;


        try {
            // InternalMyDsl.g:536:54: (iv_ruleStatementList= ruleStatementList EOF )
            // InternalMyDsl.g:537:2: iv_ruleStatementList= ruleStatementList EOF
            {
             newCompositeNode(grammarAccess.getStatementListRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStatementList=ruleStatementList();

            state._fsp--;

             current =iv_ruleStatementList; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatementList"


    // $ANTLR start "ruleStatementList"
    // InternalMyDsl.g:543:1: ruleStatementList returns [EObject current=null] : ( () otherlv_1= 'StatementList' otherlv_2= '{' (otherlv_3= 'state' otherlv_4= '{' ( (lv_state_5_0= ruleStatement ) ) (otherlv_6= ',' ( (lv_state_7_0= ruleStatement ) ) )* otherlv_8= '}' )? otherlv_9= '}' ) ;
    public final EObject ruleStatementList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        EObject lv_state_5_0 = null;

        EObject lv_state_7_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:549:2: ( ( () otherlv_1= 'StatementList' otherlv_2= '{' (otherlv_3= 'state' otherlv_4= '{' ( (lv_state_5_0= ruleStatement ) ) (otherlv_6= ',' ( (lv_state_7_0= ruleStatement ) ) )* otherlv_8= '}' )? otherlv_9= '}' ) )
            // InternalMyDsl.g:550:2: ( () otherlv_1= 'StatementList' otherlv_2= '{' (otherlv_3= 'state' otherlv_4= '{' ( (lv_state_5_0= ruleStatement ) ) (otherlv_6= ',' ( (lv_state_7_0= ruleStatement ) ) )* otherlv_8= '}' )? otherlv_9= '}' )
            {
            // InternalMyDsl.g:550:2: ( () otherlv_1= 'StatementList' otherlv_2= '{' (otherlv_3= 'state' otherlv_4= '{' ( (lv_state_5_0= ruleStatement ) ) (otherlv_6= ',' ( (lv_state_7_0= ruleStatement ) ) )* otherlv_8= '}' )? otherlv_9= '}' )
            // InternalMyDsl.g:551:3: () otherlv_1= 'StatementList' otherlv_2= '{' (otherlv_3= 'state' otherlv_4= '{' ( (lv_state_5_0= ruleStatement ) ) (otherlv_6= ',' ( (lv_state_7_0= ruleStatement ) ) )* otherlv_8= '}' )? otherlv_9= '}'
            {
            // InternalMyDsl.g:551:3: ()
            // InternalMyDsl.g:552:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getStatementListAccess().getStatementListAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,19,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getStatementListAccess().getStatementListKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_13); 

            			newLeafNode(otherlv_2, grammarAccess.getStatementListAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:566:3: (otherlv_3= 'state' otherlv_4= '{' ( (lv_state_5_0= ruleStatement ) ) (otherlv_6= ',' ( (lv_state_7_0= ruleStatement ) ) )* otherlv_8= '}' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==20) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalMyDsl.g:567:4: otherlv_3= 'state' otherlv_4= '{' ( (lv_state_5_0= ruleStatement ) ) (otherlv_6= ',' ( (lv_state_7_0= ruleStatement ) ) )* otherlv_8= '}'
                    {
                    otherlv_3=(Token)match(input,20,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getStatementListAccess().getStateKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,12,FOLLOW_14); 

                    				newLeafNode(otherlv_4, grammarAccess.getStatementListAccess().getLeftCurlyBracketKeyword_3_1());
                    			
                    // InternalMyDsl.g:575:4: ( (lv_state_5_0= ruleStatement ) )
                    // InternalMyDsl.g:576:5: (lv_state_5_0= ruleStatement )
                    {
                    // InternalMyDsl.g:576:5: (lv_state_5_0= ruleStatement )
                    // InternalMyDsl.g:577:6: lv_state_5_0= ruleStatement
                    {

                    						newCompositeNode(grammarAccess.getStatementListAccess().getStateStatementParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_6);
                    lv_state_5_0=ruleStatement();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStatementListRule());
                    						}
                    						add(
                    							current,
                    							"state",
                    							lv_state_5_0,
                    							"org.xtext.example.mydsl.MyDsl.Statement");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:594:4: (otherlv_6= ',' ( (lv_state_7_0= ruleStatement ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==14) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalMyDsl.g:595:5: otherlv_6= ',' ( (lv_state_7_0= ruleStatement ) )
                    	    {
                    	    otherlv_6=(Token)match(input,14,FOLLOW_14); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getStatementListAccess().getCommaKeyword_3_3_0());
                    	    				
                    	    // InternalMyDsl.g:599:5: ( (lv_state_7_0= ruleStatement ) )
                    	    // InternalMyDsl.g:600:6: (lv_state_7_0= ruleStatement )
                    	    {
                    	    // InternalMyDsl.g:600:6: (lv_state_7_0= ruleStatement )
                    	    // InternalMyDsl.g:601:7: lv_state_7_0= ruleStatement
                    	    {

                    	    							newCompositeNode(grammarAccess.getStatementListAccess().getStateStatementParserRuleCall_3_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_6);
                    	    lv_state_7_0=ruleStatement();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getStatementListRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"state",
                    	    								lv_state_7_0,
                    	    								"org.xtext.example.mydsl.MyDsl.Statement");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,15,FOLLOW_7); 

                    				newLeafNode(otherlv_8, grammarAccess.getStatementListAccess().getRightCurlyBracketKeyword_3_4());
                    			

                    }
                    break;

            }

            otherlv_9=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getStatementListAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatementList"


    // $ANTLR start "entryRuleEString"
    // InternalMyDsl.g:632:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalMyDsl.g:632:47: (iv_ruleEString= ruleEString EOF )
            // InternalMyDsl.g:633:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalMyDsl.g:639:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalMyDsl.g:645:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalMyDsl.g:646:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalMyDsl.g:646:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_STRING) ) {
                alt9=1;
            }
            else if ( (LA9_0==RULE_ID) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalMyDsl.g:647:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:655:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_1);
                    		

                    			newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleBool"
    // InternalMyDsl.g:666:1: entryRuleBool returns [EObject current=null] : iv_ruleBool= ruleBool EOF ;
    public final EObject entryRuleBool() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBool = null;


        try {
            // InternalMyDsl.g:666:45: (iv_ruleBool= ruleBool EOF )
            // InternalMyDsl.g:667:2: iv_ruleBool= ruleBool EOF
            {
             newCompositeNode(grammarAccess.getBoolRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBool=ruleBool();

            state._fsp--;

             current =iv_ruleBool; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBool"


    // $ANTLR start "ruleBool"
    // InternalMyDsl.g:673:1: ruleBool returns [EObject current=null] : ( () otherlv_1= 'Bool' ) ;
    public final EObject ruleBool() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMyDsl.g:679:2: ( ( () otherlv_1= 'Bool' ) )
            // InternalMyDsl.g:680:2: ( () otherlv_1= 'Bool' )
            {
            // InternalMyDsl.g:680:2: ( () otherlv_1= 'Bool' )
            // InternalMyDsl.g:681:3: () otherlv_1= 'Bool'
            {
            // InternalMyDsl.g:681:3: ()
            // InternalMyDsl.g:682:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBoolAccess().getBoolAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,21,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getBoolAccess().getBoolKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBool"


    // $ANTLR start "entryRuleNumber"
    // InternalMyDsl.g:696:1: entryRuleNumber returns [EObject current=null] : iv_ruleNumber= ruleNumber EOF ;
    public final EObject entryRuleNumber() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumber = null;


        try {
            // InternalMyDsl.g:696:47: (iv_ruleNumber= ruleNumber EOF )
            // InternalMyDsl.g:697:2: iv_ruleNumber= ruleNumber EOF
            {
             newCompositeNode(grammarAccess.getNumberRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumber=ruleNumber();

            state._fsp--;

             current =iv_ruleNumber; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumber"


    // $ANTLR start "ruleNumber"
    // InternalMyDsl.g:703:1: ruleNumber returns [EObject current=null] : ( () otherlv_1= 'Number' otherlv_2= '{' (otherlv_3= 'unit' ( (lv_unit_4_0= ruleUnit ) ) )? otherlv_5= '}' ) ;
    public final EObject ruleNumber() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Enumerator lv_unit_4_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:709:2: ( ( () otherlv_1= 'Number' otherlv_2= '{' (otherlv_3= 'unit' ( (lv_unit_4_0= ruleUnit ) ) )? otherlv_5= '}' ) )
            // InternalMyDsl.g:710:2: ( () otherlv_1= 'Number' otherlv_2= '{' (otherlv_3= 'unit' ( (lv_unit_4_0= ruleUnit ) ) )? otherlv_5= '}' )
            {
            // InternalMyDsl.g:710:2: ( () otherlv_1= 'Number' otherlv_2= '{' (otherlv_3= 'unit' ( (lv_unit_4_0= ruleUnit ) ) )? otherlv_5= '}' )
            // InternalMyDsl.g:711:3: () otherlv_1= 'Number' otherlv_2= '{' (otherlv_3= 'unit' ( (lv_unit_4_0= ruleUnit ) ) )? otherlv_5= '}'
            {
            // InternalMyDsl.g:711:3: ()
            // InternalMyDsl.g:712:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNumberAccess().getNumberAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,22,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getNumberAccess().getNumberKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getNumberAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:726:3: (otherlv_3= 'unit' ( (lv_unit_4_0= ruleUnit ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==23) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalMyDsl.g:727:4: otherlv_3= 'unit' ( (lv_unit_4_0= ruleUnit ) )
                    {
                    otherlv_3=(Token)match(input,23,FOLLOW_16); 

                    				newLeafNode(otherlv_3, grammarAccess.getNumberAccess().getUnitKeyword_3_0());
                    			
                    // InternalMyDsl.g:731:4: ( (lv_unit_4_0= ruleUnit ) )
                    // InternalMyDsl.g:732:5: (lv_unit_4_0= ruleUnit )
                    {
                    // InternalMyDsl.g:732:5: (lv_unit_4_0= ruleUnit )
                    // InternalMyDsl.g:733:6: lv_unit_4_0= ruleUnit
                    {

                    						newCompositeNode(grammarAccess.getNumberAccess().getUnitUnitEnumRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_unit_4_0=ruleUnit();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getNumberRule());
                    						}
                    						set(
                    							current,
                    							"unit",
                    							lv_unit_4_0,
                    							"org.xtext.example.mydsl.MyDsl.Unit");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getNumberAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumber"


    // $ANTLR start "entryRuleVoid"
    // InternalMyDsl.g:759:1: entryRuleVoid returns [EObject current=null] : iv_ruleVoid= ruleVoid EOF ;
    public final EObject entryRuleVoid() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVoid = null;


        try {
            // InternalMyDsl.g:759:45: (iv_ruleVoid= ruleVoid EOF )
            // InternalMyDsl.g:760:2: iv_ruleVoid= ruleVoid EOF
            {
             newCompositeNode(grammarAccess.getVoidRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVoid=ruleVoid();

            state._fsp--;

             current =iv_ruleVoid; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVoid"


    // $ANTLR start "ruleVoid"
    // InternalMyDsl.g:766:1: ruleVoid returns [EObject current=null] : ( () otherlv_1= 'Void' ) ;
    public final EObject ruleVoid() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMyDsl.g:772:2: ( ( () otherlv_1= 'Void' ) )
            // InternalMyDsl.g:773:2: ( () otherlv_1= 'Void' )
            {
            // InternalMyDsl.g:773:2: ( () otherlv_1= 'Void' )
            // InternalMyDsl.g:774:3: () otherlv_1= 'Void'
            {
            // InternalMyDsl.g:774:3: ()
            // InternalMyDsl.g:775:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getVoidAccess().getVoidAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getVoidAccess().getVoidKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVoid"


    // $ANTLR start "entryRuleFuncCall"
    // InternalMyDsl.g:789:1: entryRuleFuncCall returns [EObject current=null] : iv_ruleFuncCall= ruleFuncCall EOF ;
    public final EObject entryRuleFuncCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFuncCall = null;


        try {
            // InternalMyDsl.g:789:49: (iv_ruleFuncCall= ruleFuncCall EOF )
            // InternalMyDsl.g:790:2: iv_ruleFuncCall= ruleFuncCall EOF
            {
             newCompositeNode(grammarAccess.getFuncCallRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFuncCall=ruleFuncCall();

            state._fsp--;

             current =iv_ruleFuncCall; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFuncCall"


    // $ANTLR start "ruleFuncCall"
    // InternalMyDsl.g:796:1: ruleFuncCall returns [EObject current=null] : ( () otherlv_1= 'FuncCall' otherlv_2= '{' (otherlv_3= 'funcdecl' ( ( ruleEString ) ) )? otherlv_5= '}' ) ;
    public final EObject ruleFuncCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalMyDsl.g:802:2: ( ( () otherlv_1= 'FuncCall' otherlv_2= '{' (otherlv_3= 'funcdecl' ( ( ruleEString ) ) )? otherlv_5= '}' ) )
            // InternalMyDsl.g:803:2: ( () otherlv_1= 'FuncCall' otherlv_2= '{' (otherlv_3= 'funcdecl' ( ( ruleEString ) ) )? otherlv_5= '}' )
            {
            // InternalMyDsl.g:803:2: ( () otherlv_1= 'FuncCall' otherlv_2= '{' (otherlv_3= 'funcdecl' ( ( ruleEString ) ) )? otherlv_5= '}' )
            // InternalMyDsl.g:804:3: () otherlv_1= 'FuncCall' otherlv_2= '{' (otherlv_3= 'funcdecl' ( ( ruleEString ) ) )? otherlv_5= '}'
            {
            // InternalMyDsl.g:804:3: ()
            // InternalMyDsl.g:805:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFuncCallAccess().getFuncCallAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,25,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getFuncCallAccess().getFuncCallKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getFuncCallAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:819:3: (otherlv_3= 'funcdecl' ( ( ruleEString ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==13) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalMyDsl.g:820:4: otherlv_3= 'funcdecl' ( ( ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,13,FOLLOW_8); 

                    				newLeafNode(otherlv_3, grammarAccess.getFuncCallAccess().getFuncdeclKeyword_3_0());
                    			
                    // InternalMyDsl.g:824:4: ( ( ruleEString ) )
                    // InternalMyDsl.g:825:5: ( ruleEString )
                    {
                    // InternalMyDsl.g:825:5: ( ruleEString )
                    // InternalMyDsl.g:826:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFuncCallRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getFuncCallAccess().getFuncdeclFuncDeclCrossReference_3_1_0());
                    					
                    pushFollow(FOLLOW_7);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getFuncCallAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFuncCall"


    // $ANTLR start "entryRuleVarAssign"
    // InternalMyDsl.g:849:1: entryRuleVarAssign returns [EObject current=null] : iv_ruleVarAssign= ruleVarAssign EOF ;
    public final EObject entryRuleVarAssign() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarAssign = null;


        try {
            // InternalMyDsl.g:849:50: (iv_ruleVarAssign= ruleVarAssign EOF )
            // InternalMyDsl.g:850:2: iv_ruleVarAssign= ruleVarAssign EOF
            {
             newCompositeNode(grammarAccess.getVarAssignRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVarAssign=ruleVarAssign();

            state._fsp--;

             current =iv_ruleVarAssign; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVarAssign"


    // $ANTLR start "ruleVarAssign"
    // InternalMyDsl.g:856:1: ruleVarAssign returns [EObject current=null] : (otherlv_0= 'VarAssign' otherlv_1= '{' (otherlv_2= 'vardecl' ( ( ruleEString ) ) )? otherlv_4= 'expression' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' ) ;
    public final EObject ruleVarAssign() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_expression_5_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:862:2: ( (otherlv_0= 'VarAssign' otherlv_1= '{' (otherlv_2= 'vardecl' ( ( ruleEString ) ) )? otherlv_4= 'expression' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' ) )
            // InternalMyDsl.g:863:2: (otherlv_0= 'VarAssign' otherlv_1= '{' (otherlv_2= 'vardecl' ( ( ruleEString ) ) )? otherlv_4= 'expression' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )
            {
            // InternalMyDsl.g:863:2: (otherlv_0= 'VarAssign' otherlv_1= '{' (otherlv_2= 'vardecl' ( ( ruleEString ) ) )? otherlv_4= 'expression' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )
            // InternalMyDsl.g:864:3: otherlv_0= 'VarAssign' otherlv_1= '{' (otherlv_2= 'vardecl' ( ( ruleEString ) ) )? otherlv_4= 'expression' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,26,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getVarAssignAccess().getVarAssignKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_17); 

            			newLeafNode(otherlv_1, grammarAccess.getVarAssignAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalMyDsl.g:872:3: (otherlv_2= 'vardecl' ( ( ruleEString ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==27) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalMyDsl.g:873:4: otherlv_2= 'vardecl' ( ( ruleEString ) )
                    {
                    otherlv_2=(Token)match(input,27,FOLLOW_8); 

                    				newLeafNode(otherlv_2, grammarAccess.getVarAssignAccess().getVardeclKeyword_2_0());
                    			
                    // InternalMyDsl.g:877:4: ( ( ruleEString ) )
                    // InternalMyDsl.g:878:5: ( ruleEString )
                    {
                    // InternalMyDsl.g:878:5: ( ruleEString )
                    // InternalMyDsl.g:879:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getVarAssignRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getVarAssignAccess().getVardeclVarDeclCrossReference_2_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,28,FOLLOW_19); 

            			newLeafNode(otherlv_4, grammarAccess.getVarAssignAccess().getExpressionKeyword_3());
            		
            // InternalMyDsl.g:898:3: ( (lv_expression_5_0= ruleExpression ) )
            // InternalMyDsl.g:899:4: (lv_expression_5_0= ruleExpression )
            {
            // InternalMyDsl.g:899:4: (lv_expression_5_0= ruleExpression )
            // InternalMyDsl.g:900:5: lv_expression_5_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getVarAssignAccess().getExpressionExpressionParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_7);
            lv_expression_5_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVarAssignRule());
            					}
            					set(
            						current,
            						"expression",
            						lv_expression_5_0,
            						"org.xtext.example.mydsl.MyDsl.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getVarAssignAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVarAssign"


    // $ANTLR start "entryRuleVarDecl"
    // InternalMyDsl.g:925:1: entryRuleVarDecl returns [EObject current=null] : iv_ruleVarDecl= ruleVarDecl EOF ;
    public final EObject entryRuleVarDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarDecl = null;


        try {
            // InternalMyDsl.g:925:48: (iv_ruleVarDecl= ruleVarDecl EOF )
            // InternalMyDsl.g:926:2: iv_ruleVarDecl= ruleVarDecl EOF
            {
             newCompositeNode(grammarAccess.getVarDeclRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVarDecl=ruleVarDecl();

            state._fsp--;

             current =iv_ruleVarDecl; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVarDecl"


    // $ANTLR start "ruleVarDecl"
    // InternalMyDsl.g:932:1: ruleVarDecl returns [EObject current=null] : (otherlv_0= 'VarDecl' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'type' ( (lv_type_4_0= ruleTypeVar ) ) (otherlv_5= 'expression' ( (lv_expression_6_0= ruleExpression ) ) )? otherlv_7= '}' ) ;
    public final EObject ruleVarDecl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_type_4_0 = null;

        EObject lv_expression_6_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:938:2: ( (otherlv_0= 'VarDecl' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'type' ( (lv_type_4_0= ruleTypeVar ) ) (otherlv_5= 'expression' ( (lv_expression_6_0= ruleExpression ) ) )? otherlv_7= '}' ) )
            // InternalMyDsl.g:939:2: (otherlv_0= 'VarDecl' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'type' ( (lv_type_4_0= ruleTypeVar ) ) (otherlv_5= 'expression' ( (lv_expression_6_0= ruleExpression ) ) )? otherlv_7= '}' )
            {
            // InternalMyDsl.g:939:2: (otherlv_0= 'VarDecl' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'type' ( (lv_type_4_0= ruleTypeVar ) ) (otherlv_5= 'expression' ( (lv_expression_6_0= ruleExpression ) ) )? otherlv_7= '}' )
            // InternalMyDsl.g:940:3: otherlv_0= 'VarDecl' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'type' ( (lv_type_4_0= ruleTypeVar ) ) (otherlv_5= 'expression' ( (lv_expression_6_0= ruleExpression ) ) )? otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getVarDeclAccess().getVarDeclKeyword_0());
            		
            // InternalMyDsl.g:944:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:945:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:945:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:946:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getVarDeclAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVarDeclRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_9); 

            			newLeafNode(otherlv_2, grammarAccess.getVarDeclAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,17,FOLLOW_20); 

            			newLeafNode(otherlv_3, grammarAccess.getVarDeclAccess().getTypeKeyword_3());
            		
            // InternalMyDsl.g:971:3: ( (lv_type_4_0= ruleTypeVar ) )
            // InternalMyDsl.g:972:4: (lv_type_4_0= ruleTypeVar )
            {
            // InternalMyDsl.g:972:4: (lv_type_4_0= ruleTypeVar )
            // InternalMyDsl.g:973:5: lv_type_4_0= ruleTypeVar
            {

            					newCompositeNode(grammarAccess.getVarDeclAccess().getTypeTypeVarParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_21);
            lv_type_4_0=ruleTypeVar();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVarDeclRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_4_0,
            						"org.xtext.example.mydsl.MyDsl.TypeVar");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:990:3: (otherlv_5= 'expression' ( (lv_expression_6_0= ruleExpression ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==28) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalMyDsl.g:991:4: otherlv_5= 'expression' ( (lv_expression_6_0= ruleExpression ) )
                    {
                    otherlv_5=(Token)match(input,28,FOLLOW_19); 

                    				newLeafNode(otherlv_5, grammarAccess.getVarDeclAccess().getExpressionKeyword_5_0());
                    			
                    // InternalMyDsl.g:995:4: ( (lv_expression_6_0= ruleExpression ) )
                    // InternalMyDsl.g:996:5: (lv_expression_6_0= ruleExpression )
                    {
                    // InternalMyDsl.g:996:5: (lv_expression_6_0= ruleExpression )
                    // InternalMyDsl.g:997:6: lv_expression_6_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getVarDeclAccess().getExpressionExpressionParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_expression_6_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getVarDeclRule());
                    						}
                    						set(
                    							current,
                    							"expression",
                    							lv_expression_6_0,
                    							"org.xtext.example.mydsl.MyDsl.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getVarDeclAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVarDecl"


    // $ANTLR start "entryRuleMovement"
    // InternalMyDsl.g:1023:1: entryRuleMovement returns [EObject current=null] : iv_ruleMovement= ruleMovement EOF ;
    public final EObject entryRuleMovement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMovement = null;


        try {
            // InternalMyDsl.g:1023:49: (iv_ruleMovement= ruleMovement EOF )
            // InternalMyDsl.g:1024:2: iv_ruleMovement= ruleMovement EOF
            {
             newCompositeNode(grammarAccess.getMovementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMovement=ruleMovement();

            state._fsp--;

             current =iv_ruleMovement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMovement"


    // $ANTLR start "ruleMovement"
    // InternalMyDsl.g:1030:1: ruleMovement returns [EObject current=null] : (otherlv_0= 'Movement' otherlv_1= '{' (otherlv_2= 'side' ( (lv_side_3_0= ruleDirection ) ) )? otherlv_4= 'distance' ( (lv_distance_5_0= ruleExpression ) ) otherlv_6= '}' ) ;
    public final EObject ruleMovement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Enumerator lv_side_3_0 = null;

        EObject lv_distance_5_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1036:2: ( (otherlv_0= 'Movement' otherlv_1= '{' (otherlv_2= 'side' ( (lv_side_3_0= ruleDirection ) ) )? otherlv_4= 'distance' ( (lv_distance_5_0= ruleExpression ) ) otherlv_6= '}' ) )
            // InternalMyDsl.g:1037:2: (otherlv_0= 'Movement' otherlv_1= '{' (otherlv_2= 'side' ( (lv_side_3_0= ruleDirection ) ) )? otherlv_4= 'distance' ( (lv_distance_5_0= ruleExpression ) ) otherlv_6= '}' )
            {
            // InternalMyDsl.g:1037:2: (otherlv_0= 'Movement' otherlv_1= '{' (otherlv_2= 'side' ( (lv_side_3_0= ruleDirection ) ) )? otherlv_4= 'distance' ( (lv_distance_5_0= ruleExpression ) ) otherlv_6= '}' )
            // InternalMyDsl.g:1038:3: otherlv_0= 'Movement' otherlv_1= '{' (otherlv_2= 'side' ( (lv_side_3_0= ruleDirection ) ) )? otherlv_4= 'distance' ( (lv_distance_5_0= ruleExpression ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getMovementAccess().getMovementKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_22); 

            			newLeafNode(otherlv_1, grammarAccess.getMovementAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalMyDsl.g:1046:3: (otherlv_2= 'side' ( (lv_side_3_0= ruleDirection ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==31) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalMyDsl.g:1047:4: otherlv_2= 'side' ( (lv_side_3_0= ruleDirection ) )
                    {
                    otherlv_2=(Token)match(input,31,FOLLOW_23); 

                    				newLeafNode(otherlv_2, grammarAccess.getMovementAccess().getSideKeyword_2_0());
                    			
                    // InternalMyDsl.g:1051:4: ( (lv_side_3_0= ruleDirection ) )
                    // InternalMyDsl.g:1052:5: (lv_side_3_0= ruleDirection )
                    {
                    // InternalMyDsl.g:1052:5: (lv_side_3_0= ruleDirection )
                    // InternalMyDsl.g:1053:6: lv_side_3_0= ruleDirection
                    {

                    						newCompositeNode(grammarAccess.getMovementAccess().getSideDirectionEnumRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_24);
                    lv_side_3_0=ruleDirection();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMovementRule());
                    						}
                    						set(
                    							current,
                    							"side",
                    							lv_side_3_0,
                    							"org.xtext.example.mydsl.MyDsl.Direction");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,32,FOLLOW_19); 

            			newLeafNode(otherlv_4, grammarAccess.getMovementAccess().getDistanceKeyword_3());
            		
            // InternalMyDsl.g:1075:3: ( (lv_distance_5_0= ruleExpression ) )
            // InternalMyDsl.g:1076:4: (lv_distance_5_0= ruleExpression )
            {
            // InternalMyDsl.g:1076:4: (lv_distance_5_0= ruleExpression )
            // InternalMyDsl.g:1077:5: lv_distance_5_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getMovementAccess().getDistanceExpressionParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_7);
            lv_distance_5_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMovementRule());
            					}
            					set(
            						current,
            						"distance",
            						lv_distance_5_0,
            						"org.xtext.example.mydsl.MyDsl.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getMovementAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMovement"


    // $ANTLR start "entryRuleClock"
    // InternalMyDsl.g:1102:1: entryRuleClock returns [EObject current=null] : iv_ruleClock= ruleClock EOF ;
    public final EObject entryRuleClock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClock = null;


        try {
            // InternalMyDsl.g:1102:46: (iv_ruleClock= ruleClock EOF )
            // InternalMyDsl.g:1103:2: iv_ruleClock= ruleClock EOF
            {
             newCompositeNode(grammarAccess.getClockRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleClock=ruleClock();

            state._fsp--;

             current =iv_ruleClock; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClock"


    // $ANTLR start "ruleClock"
    // InternalMyDsl.g:1109:1: ruleClock returns [EObject current=null] : (otherlv_0= 'Clock' otherlv_1= '{' otherlv_2= 'distance' ( (lv_distance_3_0= ruleExpression ) ) otherlv_4= '}' ) ;
    public final EObject ruleClock() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_distance_3_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1115:2: ( (otherlv_0= 'Clock' otherlv_1= '{' otherlv_2= 'distance' ( (lv_distance_3_0= ruleExpression ) ) otherlv_4= '}' ) )
            // InternalMyDsl.g:1116:2: (otherlv_0= 'Clock' otherlv_1= '{' otherlv_2= 'distance' ( (lv_distance_3_0= ruleExpression ) ) otherlv_4= '}' )
            {
            // InternalMyDsl.g:1116:2: (otherlv_0= 'Clock' otherlv_1= '{' otherlv_2= 'distance' ( (lv_distance_3_0= ruleExpression ) ) otherlv_4= '}' )
            // InternalMyDsl.g:1117:3: otherlv_0= 'Clock' otherlv_1= '{' otherlv_2= 'distance' ( (lv_distance_3_0= ruleExpression ) ) otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getClockAccess().getClockKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_24); 

            			newLeafNode(otherlv_1, grammarAccess.getClockAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,32,FOLLOW_19); 

            			newLeafNode(otherlv_2, grammarAccess.getClockAccess().getDistanceKeyword_2());
            		
            // InternalMyDsl.g:1129:3: ( (lv_distance_3_0= ruleExpression ) )
            // InternalMyDsl.g:1130:4: (lv_distance_3_0= ruleExpression )
            {
            // InternalMyDsl.g:1130:4: (lv_distance_3_0= ruleExpression )
            // InternalMyDsl.g:1131:5: lv_distance_3_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getClockAccess().getDistanceExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_7);
            lv_distance_3_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getClockRule());
            					}
            					set(
            						current,
            						"distance",
            						lv_distance_3_0,
            						"org.xtext.example.mydsl.MyDsl.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getClockAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClock"


    // $ANTLR start "entryRuleControlStructure_Impl"
    // InternalMyDsl.g:1156:1: entryRuleControlStructure_Impl returns [EObject current=null] : iv_ruleControlStructure_Impl= ruleControlStructure_Impl EOF ;
    public final EObject entryRuleControlStructure_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleControlStructure_Impl = null;


        try {
            // InternalMyDsl.g:1156:62: (iv_ruleControlStructure_Impl= ruleControlStructure_Impl EOF )
            // InternalMyDsl.g:1157:2: iv_ruleControlStructure_Impl= ruleControlStructure_Impl EOF
            {
             newCompositeNode(grammarAccess.getControlStructure_ImplRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleControlStructure_Impl=ruleControlStructure_Impl();

            state._fsp--;

             current =iv_ruleControlStructure_Impl; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleControlStructure_Impl"


    // $ANTLR start "ruleControlStructure_Impl"
    // InternalMyDsl.g:1163:1: ruleControlStructure_Impl returns [EObject current=null] : (otherlv_0= 'ControlStructure' otherlv_1= '{' otherlv_2= 'condition' ( (lv_condition_3_0= ruleExpression ) ) otherlv_4= '}' ) ;
    public final EObject ruleControlStructure_Impl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_condition_3_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1169:2: ( (otherlv_0= 'ControlStructure' otherlv_1= '{' otherlv_2= 'condition' ( (lv_condition_3_0= ruleExpression ) ) otherlv_4= '}' ) )
            // InternalMyDsl.g:1170:2: (otherlv_0= 'ControlStructure' otherlv_1= '{' otherlv_2= 'condition' ( (lv_condition_3_0= ruleExpression ) ) otherlv_4= '}' )
            {
            // InternalMyDsl.g:1170:2: (otherlv_0= 'ControlStructure' otherlv_1= '{' otherlv_2= 'condition' ( (lv_condition_3_0= ruleExpression ) ) otherlv_4= '}' )
            // InternalMyDsl.g:1171:3: otherlv_0= 'ControlStructure' otherlv_1= '{' otherlv_2= 'condition' ( (lv_condition_3_0= ruleExpression ) ) otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,34,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getControlStructure_ImplAccess().getControlStructureKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_25); 

            			newLeafNode(otherlv_1, grammarAccess.getControlStructure_ImplAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,35,FOLLOW_19); 

            			newLeafNode(otherlv_2, grammarAccess.getControlStructure_ImplAccess().getConditionKeyword_2());
            		
            // InternalMyDsl.g:1183:3: ( (lv_condition_3_0= ruleExpression ) )
            // InternalMyDsl.g:1184:4: (lv_condition_3_0= ruleExpression )
            {
            // InternalMyDsl.g:1184:4: (lv_condition_3_0= ruleExpression )
            // InternalMyDsl.g:1185:5: lv_condition_3_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getControlStructure_ImplAccess().getConditionExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_7);
            lv_condition_3_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getControlStructure_ImplRule());
            					}
            					set(
            						current,
            						"condition",
            						lv_condition_3_0,
            						"org.xtext.example.mydsl.MyDsl.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getControlStructure_ImplAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleControlStructure_Impl"


    // $ANTLR start "entryRuleLoop"
    // InternalMyDsl.g:1210:1: entryRuleLoop returns [EObject current=null] : iv_ruleLoop= ruleLoop EOF ;
    public final EObject entryRuleLoop() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop = null;


        try {
            // InternalMyDsl.g:1210:45: (iv_ruleLoop= ruleLoop EOF )
            // InternalMyDsl.g:1211:2: iv_ruleLoop= ruleLoop EOF
            {
             newCompositeNode(grammarAccess.getLoopRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLoop=ruleLoop();

            state._fsp--;

             current =iv_ruleLoop; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLoop"


    // $ANTLR start "ruleLoop"
    // InternalMyDsl.g:1217:1: ruleLoop returns [EObject current=null] : (otherlv_0= 'Loop' otherlv_1= '{' otherlv_2= 'condition' ( (lv_condition_3_0= ruleExpression ) ) otherlv_4= 'body' ( (lv_body_5_0= ruleStatementList ) ) otherlv_6= '}' ) ;
    public final EObject ruleLoop() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_condition_3_0 = null;

        EObject lv_body_5_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1223:2: ( (otherlv_0= 'Loop' otherlv_1= '{' otherlv_2= 'condition' ( (lv_condition_3_0= ruleExpression ) ) otherlv_4= 'body' ( (lv_body_5_0= ruleStatementList ) ) otherlv_6= '}' ) )
            // InternalMyDsl.g:1224:2: (otherlv_0= 'Loop' otherlv_1= '{' otherlv_2= 'condition' ( (lv_condition_3_0= ruleExpression ) ) otherlv_4= 'body' ( (lv_body_5_0= ruleStatementList ) ) otherlv_6= '}' )
            {
            // InternalMyDsl.g:1224:2: (otherlv_0= 'Loop' otherlv_1= '{' otherlv_2= 'condition' ( (lv_condition_3_0= ruleExpression ) ) otherlv_4= 'body' ( (lv_body_5_0= ruleStatementList ) ) otherlv_6= '}' )
            // InternalMyDsl.g:1225:3: otherlv_0= 'Loop' otherlv_1= '{' otherlv_2= 'condition' ( (lv_condition_3_0= ruleExpression ) ) otherlv_4= 'body' ( (lv_body_5_0= ruleStatementList ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,36,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getLoopAccess().getLoopKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_25); 

            			newLeafNode(otherlv_1, grammarAccess.getLoopAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,35,FOLLOW_19); 

            			newLeafNode(otherlv_2, grammarAccess.getLoopAccess().getConditionKeyword_2());
            		
            // InternalMyDsl.g:1237:3: ( (lv_condition_3_0= ruleExpression ) )
            // InternalMyDsl.g:1238:4: (lv_condition_3_0= ruleExpression )
            {
            // InternalMyDsl.g:1238:4: (lv_condition_3_0= ruleExpression )
            // InternalMyDsl.g:1239:5: lv_condition_3_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getLoopAccess().getConditionExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_26);
            lv_condition_3_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLoopRule());
            					}
            					set(
            						current,
            						"condition",
            						lv_condition_3_0,
            						"org.xtext.example.mydsl.MyDsl.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,37,FOLLOW_12); 

            			newLeafNode(otherlv_4, grammarAccess.getLoopAccess().getBodyKeyword_4());
            		
            // InternalMyDsl.g:1260:3: ( (lv_body_5_0= ruleStatementList ) )
            // InternalMyDsl.g:1261:4: (lv_body_5_0= ruleStatementList )
            {
            // InternalMyDsl.g:1261:4: (lv_body_5_0= ruleStatementList )
            // InternalMyDsl.g:1262:5: lv_body_5_0= ruleStatementList
            {

            					newCompositeNode(grammarAccess.getLoopAccess().getBodyStatementListParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_7);
            lv_body_5_0=ruleStatementList();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLoopRule());
            					}
            					set(
            						current,
            						"body",
            						lv_body_5_0,
            						"org.xtext.example.mydsl.MyDsl.StatementList");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getLoopAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLoop"


    // $ANTLR start "entryRuleConditional"
    // InternalMyDsl.g:1287:1: entryRuleConditional returns [EObject current=null] : iv_ruleConditional= ruleConditional EOF ;
    public final EObject entryRuleConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditional = null;


        try {
            // InternalMyDsl.g:1287:52: (iv_ruleConditional= ruleConditional EOF )
            // InternalMyDsl.g:1288:2: iv_ruleConditional= ruleConditional EOF
            {
             newCompositeNode(grammarAccess.getConditionalRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConditional=ruleConditional();

            state._fsp--;

             current =iv_ruleConditional; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConditional"


    // $ANTLR start "ruleConditional"
    // InternalMyDsl.g:1294:1: ruleConditional returns [EObject current=null] : (otherlv_0= 'Conditional' otherlv_1= '{' otherlv_2= 'condition' ( (lv_condition_3_0= ruleExpression ) ) otherlv_4= 'ifBody' ( (lv_ifBody_5_0= ruleStatementList ) ) (otherlv_6= 'elseBody' ( (lv_elseBody_7_0= ruleStatementList ) ) )? otherlv_8= '}' ) ;
    public final EObject ruleConditional() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_condition_3_0 = null;

        EObject lv_ifBody_5_0 = null;

        EObject lv_elseBody_7_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1300:2: ( (otherlv_0= 'Conditional' otherlv_1= '{' otherlv_2= 'condition' ( (lv_condition_3_0= ruleExpression ) ) otherlv_4= 'ifBody' ( (lv_ifBody_5_0= ruleStatementList ) ) (otherlv_6= 'elseBody' ( (lv_elseBody_7_0= ruleStatementList ) ) )? otherlv_8= '}' ) )
            // InternalMyDsl.g:1301:2: (otherlv_0= 'Conditional' otherlv_1= '{' otherlv_2= 'condition' ( (lv_condition_3_0= ruleExpression ) ) otherlv_4= 'ifBody' ( (lv_ifBody_5_0= ruleStatementList ) ) (otherlv_6= 'elseBody' ( (lv_elseBody_7_0= ruleStatementList ) ) )? otherlv_8= '}' )
            {
            // InternalMyDsl.g:1301:2: (otherlv_0= 'Conditional' otherlv_1= '{' otherlv_2= 'condition' ( (lv_condition_3_0= ruleExpression ) ) otherlv_4= 'ifBody' ( (lv_ifBody_5_0= ruleStatementList ) ) (otherlv_6= 'elseBody' ( (lv_elseBody_7_0= ruleStatementList ) ) )? otherlv_8= '}' )
            // InternalMyDsl.g:1302:3: otherlv_0= 'Conditional' otherlv_1= '{' otherlv_2= 'condition' ( (lv_condition_3_0= ruleExpression ) ) otherlv_4= 'ifBody' ( (lv_ifBody_5_0= ruleStatementList ) ) (otherlv_6= 'elseBody' ( (lv_elseBody_7_0= ruleStatementList ) ) )? otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getConditionalAccess().getConditionalKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_25); 

            			newLeafNode(otherlv_1, grammarAccess.getConditionalAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,35,FOLLOW_19); 

            			newLeafNode(otherlv_2, grammarAccess.getConditionalAccess().getConditionKeyword_2());
            		
            // InternalMyDsl.g:1314:3: ( (lv_condition_3_0= ruleExpression ) )
            // InternalMyDsl.g:1315:4: (lv_condition_3_0= ruleExpression )
            {
            // InternalMyDsl.g:1315:4: (lv_condition_3_0= ruleExpression )
            // InternalMyDsl.g:1316:5: lv_condition_3_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getConditionalAccess().getConditionExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_27);
            lv_condition_3_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConditionalRule());
            					}
            					set(
            						current,
            						"condition",
            						lv_condition_3_0,
            						"org.xtext.example.mydsl.MyDsl.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,39,FOLLOW_12); 

            			newLeafNode(otherlv_4, grammarAccess.getConditionalAccess().getIfBodyKeyword_4());
            		
            // InternalMyDsl.g:1337:3: ( (lv_ifBody_5_0= ruleStatementList ) )
            // InternalMyDsl.g:1338:4: (lv_ifBody_5_0= ruleStatementList )
            {
            // InternalMyDsl.g:1338:4: (lv_ifBody_5_0= ruleStatementList )
            // InternalMyDsl.g:1339:5: lv_ifBody_5_0= ruleStatementList
            {

            					newCompositeNode(grammarAccess.getConditionalAccess().getIfBodyStatementListParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_28);
            lv_ifBody_5_0=ruleStatementList();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConditionalRule());
            					}
            					set(
            						current,
            						"ifBody",
            						lv_ifBody_5_0,
            						"org.xtext.example.mydsl.MyDsl.StatementList");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:1356:3: (otherlv_6= 'elseBody' ( (lv_elseBody_7_0= ruleStatementList ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==40) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalMyDsl.g:1357:4: otherlv_6= 'elseBody' ( (lv_elseBody_7_0= ruleStatementList ) )
                    {
                    otherlv_6=(Token)match(input,40,FOLLOW_12); 

                    				newLeafNode(otherlv_6, grammarAccess.getConditionalAccess().getElseBodyKeyword_6_0());
                    			
                    // InternalMyDsl.g:1361:4: ( (lv_elseBody_7_0= ruleStatementList ) )
                    // InternalMyDsl.g:1362:5: (lv_elseBody_7_0= ruleStatementList )
                    {
                    // InternalMyDsl.g:1362:5: (lv_elseBody_7_0= ruleStatementList )
                    // InternalMyDsl.g:1363:6: lv_elseBody_7_0= ruleStatementList
                    {

                    						newCompositeNode(grammarAccess.getConditionalAccess().getElseBodyStatementListParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_elseBody_7_0=ruleStatementList();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getConditionalRule());
                    						}
                    						set(
                    							current,
                    							"elseBody",
                    							lv_elseBody_7_0,
                    							"org.xtext.example.mydsl.MyDsl.StatementList");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getConditionalAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConditional"


    // $ANTLR start "entryRuleSetSpeed"
    // InternalMyDsl.g:1389:1: entryRuleSetSpeed returns [EObject current=null] : iv_ruleSetSpeed= ruleSetSpeed EOF ;
    public final EObject entryRuleSetSpeed() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetSpeed = null;


        try {
            // InternalMyDsl.g:1389:49: (iv_ruleSetSpeed= ruleSetSpeed EOF )
            // InternalMyDsl.g:1390:2: iv_ruleSetSpeed= ruleSetSpeed EOF
            {
             newCompositeNode(grammarAccess.getSetSpeedRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSetSpeed=ruleSetSpeed();

            state._fsp--;

             current =iv_ruleSetSpeed; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSetSpeed"


    // $ANTLR start "ruleSetSpeed"
    // InternalMyDsl.g:1396:1: ruleSetSpeed returns [EObject current=null] : (otherlv_0= 'SetSpeed' otherlv_1= '{' otherlv_2= 'speed' ( (lv_speed_3_0= ruleExpression ) ) otherlv_4= '}' ) ;
    public final EObject ruleSetSpeed() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_speed_3_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1402:2: ( (otherlv_0= 'SetSpeed' otherlv_1= '{' otherlv_2= 'speed' ( (lv_speed_3_0= ruleExpression ) ) otherlv_4= '}' ) )
            // InternalMyDsl.g:1403:2: (otherlv_0= 'SetSpeed' otherlv_1= '{' otherlv_2= 'speed' ( (lv_speed_3_0= ruleExpression ) ) otherlv_4= '}' )
            {
            // InternalMyDsl.g:1403:2: (otherlv_0= 'SetSpeed' otherlv_1= '{' otherlv_2= 'speed' ( (lv_speed_3_0= ruleExpression ) ) otherlv_4= '}' )
            // InternalMyDsl.g:1404:3: otherlv_0= 'SetSpeed' otherlv_1= '{' otherlv_2= 'speed' ( (lv_speed_3_0= ruleExpression ) ) otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,41,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getSetSpeedAccess().getSetSpeedKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_29); 

            			newLeafNode(otherlv_1, grammarAccess.getSetSpeedAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,42,FOLLOW_19); 

            			newLeafNode(otherlv_2, grammarAccess.getSetSpeedAccess().getSpeedKeyword_2());
            		
            // InternalMyDsl.g:1416:3: ( (lv_speed_3_0= ruleExpression ) )
            // InternalMyDsl.g:1417:4: (lv_speed_3_0= ruleExpression )
            {
            // InternalMyDsl.g:1417:4: (lv_speed_3_0= ruleExpression )
            // InternalMyDsl.g:1418:5: lv_speed_3_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getSetSpeedAccess().getSpeedExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_7);
            lv_speed_3_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSetSpeedRule());
            					}
            					set(
            						current,
            						"speed",
            						lv_speed_3_0,
            						"org.xtext.example.mydsl.MyDsl.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getSetSpeedAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSetSpeed"


    // $ANTLR start "entryRuleVariableRef"
    // InternalMyDsl.g:1443:1: entryRuleVariableRef returns [EObject current=null] : iv_ruleVariableRef= ruleVariableRef EOF ;
    public final EObject entryRuleVariableRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableRef = null;


        try {
            // InternalMyDsl.g:1443:52: (iv_ruleVariableRef= ruleVariableRef EOF )
            // InternalMyDsl.g:1444:2: iv_ruleVariableRef= ruleVariableRef EOF
            {
             newCompositeNode(grammarAccess.getVariableRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariableRef=ruleVariableRef();

            state._fsp--;

             current =iv_ruleVariableRef; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableRef"


    // $ANTLR start "ruleVariableRef"
    // InternalMyDsl.g:1450:1: ruleVariableRef returns [EObject current=null] : ( () otherlv_1= 'VariableRef' otherlv_2= '{' (otherlv_3= 'vardecl' ( ( ruleEString ) ) )? otherlv_5= '}' ) ;
    public final EObject ruleVariableRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalMyDsl.g:1456:2: ( ( () otherlv_1= 'VariableRef' otherlv_2= '{' (otherlv_3= 'vardecl' ( ( ruleEString ) ) )? otherlv_5= '}' ) )
            // InternalMyDsl.g:1457:2: ( () otherlv_1= 'VariableRef' otherlv_2= '{' (otherlv_3= 'vardecl' ( ( ruleEString ) ) )? otherlv_5= '}' )
            {
            // InternalMyDsl.g:1457:2: ( () otherlv_1= 'VariableRef' otherlv_2= '{' (otherlv_3= 'vardecl' ( ( ruleEString ) ) )? otherlv_5= '}' )
            // InternalMyDsl.g:1458:3: () otherlv_1= 'VariableRef' otherlv_2= '{' (otherlv_3= 'vardecl' ( ( ruleEString ) ) )? otherlv_5= '}'
            {
            // InternalMyDsl.g:1458:3: ()
            // InternalMyDsl.g:1459:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getVariableRefAccess().getVariableRefAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,43,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getVariableRefAccess().getVariableRefKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_30); 

            			newLeafNode(otherlv_2, grammarAccess.getVariableRefAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:1473:3: (otherlv_3= 'vardecl' ( ( ruleEString ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==27) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalMyDsl.g:1474:4: otherlv_3= 'vardecl' ( ( ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,27,FOLLOW_8); 

                    				newLeafNode(otherlv_3, grammarAccess.getVariableRefAccess().getVardeclKeyword_3_0());
                    			
                    // InternalMyDsl.g:1478:4: ( ( ruleEString ) )
                    // InternalMyDsl.g:1479:5: ( ruleEString )
                    {
                    // InternalMyDsl.g:1479:5: ( ruleEString )
                    // InternalMyDsl.g:1480:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getVariableRefRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getVariableRefAccess().getVardeclVarDeclCrossReference_3_1_0());
                    					
                    pushFollow(FOLLOW_7);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getVariableRefAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableRef"


    // $ANTLR start "entryRuleBoolLiteral"
    // InternalMyDsl.g:1503:1: entryRuleBoolLiteral returns [EObject current=null] : iv_ruleBoolLiteral= ruleBoolLiteral EOF ;
    public final EObject entryRuleBoolLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolLiteral = null;


        try {
            // InternalMyDsl.g:1503:52: (iv_ruleBoolLiteral= ruleBoolLiteral EOF )
            // InternalMyDsl.g:1504:2: iv_ruleBoolLiteral= ruleBoolLiteral EOF
            {
             newCompositeNode(grammarAccess.getBoolLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBoolLiteral=ruleBoolLiteral();

            state._fsp--;

             current =iv_ruleBoolLiteral; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBoolLiteral"


    // $ANTLR start "ruleBoolLiteral"
    // InternalMyDsl.g:1510:1: ruleBoolLiteral returns [EObject current=null] : ( () ( (lv_val_1_0= 'val' ) )? otherlv_2= 'BoolLiteral' ) ;
    public final EObject ruleBoolLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_val_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalMyDsl.g:1516:2: ( ( () ( (lv_val_1_0= 'val' ) )? otherlv_2= 'BoolLiteral' ) )
            // InternalMyDsl.g:1517:2: ( () ( (lv_val_1_0= 'val' ) )? otherlv_2= 'BoolLiteral' )
            {
            // InternalMyDsl.g:1517:2: ( () ( (lv_val_1_0= 'val' ) )? otherlv_2= 'BoolLiteral' )
            // InternalMyDsl.g:1518:3: () ( (lv_val_1_0= 'val' ) )? otherlv_2= 'BoolLiteral'
            {
            // InternalMyDsl.g:1518:3: ()
            // InternalMyDsl.g:1519:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBoolLiteralAccess().getBoolLiteralAction_0(),
            					current);
            			

            }

            // InternalMyDsl.g:1525:3: ( (lv_val_1_0= 'val' ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==44) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalMyDsl.g:1526:4: (lv_val_1_0= 'val' )
                    {
                    // InternalMyDsl.g:1526:4: (lv_val_1_0= 'val' )
                    // InternalMyDsl.g:1527:5: lv_val_1_0= 'val'
                    {
                    lv_val_1_0=(Token)match(input,44,FOLLOW_31); 

                    					newLeafNode(lv_val_1_0, grammarAccess.getBoolLiteralAccess().getValValKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBoolLiteralRule());
                    					}
                    					setWithLastConsumed(current, "val", lv_val_1_0 != null, "val");
                    				

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,45,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getBoolLiteralAccess().getBoolLiteralKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBoolLiteral"


    // $ANTLR start "entryRuleNumLiteral"
    // InternalMyDsl.g:1547:1: entryRuleNumLiteral returns [EObject current=null] : iv_ruleNumLiteral= ruleNumLiteral EOF ;
    public final EObject entryRuleNumLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumLiteral = null;


        try {
            // InternalMyDsl.g:1547:51: (iv_ruleNumLiteral= ruleNumLiteral EOF )
            // InternalMyDsl.g:1548:2: iv_ruleNumLiteral= ruleNumLiteral EOF
            {
             newCompositeNode(grammarAccess.getNumLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumLiteral=ruleNumLiteral();

            state._fsp--;

             current =iv_ruleNumLiteral; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumLiteral"


    // $ANTLR start "ruleNumLiteral"
    // InternalMyDsl.g:1554:1: ruleNumLiteral returns [EObject current=null] : ( () otherlv_1= 'NumLiteral' otherlv_2= '{' (otherlv_3= 'val' ( (lv_val_4_0= ruleEInt ) ) )? otherlv_5= '}' ) ;
    public final EObject ruleNumLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_val_4_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1560:2: ( ( () otherlv_1= 'NumLiteral' otherlv_2= '{' (otherlv_3= 'val' ( (lv_val_4_0= ruleEInt ) ) )? otherlv_5= '}' ) )
            // InternalMyDsl.g:1561:2: ( () otherlv_1= 'NumLiteral' otherlv_2= '{' (otherlv_3= 'val' ( (lv_val_4_0= ruleEInt ) ) )? otherlv_5= '}' )
            {
            // InternalMyDsl.g:1561:2: ( () otherlv_1= 'NumLiteral' otherlv_2= '{' (otherlv_3= 'val' ( (lv_val_4_0= ruleEInt ) ) )? otherlv_5= '}' )
            // InternalMyDsl.g:1562:3: () otherlv_1= 'NumLiteral' otherlv_2= '{' (otherlv_3= 'val' ( (lv_val_4_0= ruleEInt ) ) )? otherlv_5= '}'
            {
            // InternalMyDsl.g:1562:3: ()
            // InternalMyDsl.g:1563:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNumLiteralAccess().getNumLiteralAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,46,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getNumLiteralAccess().getNumLiteralKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_32); 

            			newLeafNode(otherlv_2, grammarAccess.getNumLiteralAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:1577:3: (otherlv_3= 'val' ( (lv_val_4_0= ruleEInt ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==44) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalMyDsl.g:1578:4: otherlv_3= 'val' ( (lv_val_4_0= ruleEInt ) )
                    {
                    otherlv_3=(Token)match(input,44,FOLLOW_33); 

                    				newLeafNode(otherlv_3, grammarAccess.getNumLiteralAccess().getValKeyword_3_0());
                    			
                    // InternalMyDsl.g:1582:4: ( (lv_val_4_0= ruleEInt ) )
                    // InternalMyDsl.g:1583:5: (lv_val_4_0= ruleEInt )
                    {
                    // InternalMyDsl.g:1583:5: (lv_val_4_0= ruleEInt )
                    // InternalMyDsl.g:1584:6: lv_val_4_0= ruleEInt
                    {

                    						newCompositeNode(grammarAccess.getNumLiteralAccess().getValEIntParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_val_4_0=ruleEInt();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getNumLiteralRule());
                    						}
                    						set(
                    							current,
                    							"val",
                    							lv_val_4_0,
                    							"org.xtext.example.mydsl.MyDsl.EInt");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getNumLiteralAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumLiteral"


    // $ANTLR start "entryRuleBoolUnaryOperation"
    // InternalMyDsl.g:1610:1: entryRuleBoolUnaryOperation returns [EObject current=null] : iv_ruleBoolUnaryOperation= ruleBoolUnaryOperation EOF ;
    public final EObject entryRuleBoolUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolUnaryOperation = null;


        try {
            // InternalMyDsl.g:1610:59: (iv_ruleBoolUnaryOperation= ruleBoolUnaryOperation EOF )
            // InternalMyDsl.g:1611:2: iv_ruleBoolUnaryOperation= ruleBoolUnaryOperation EOF
            {
             newCompositeNode(grammarAccess.getBoolUnaryOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBoolUnaryOperation=ruleBoolUnaryOperation();

            state._fsp--;

             current =iv_ruleBoolUnaryOperation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBoolUnaryOperation"


    // $ANTLR start "ruleBoolUnaryOperation"
    // InternalMyDsl.g:1617:1: ruleBoolUnaryOperation returns [EObject current=null] : (otherlv_0= 'BoolUnaryOperation' otherlv_1= '{' (otherlv_2= 'type' ( (lv_type_3_0= ruleBoolUOp ) ) )? otherlv_4= 'operand' ( (lv_operand_5_0= ruleExpression ) ) otherlv_6= '}' ) ;
    public final EObject ruleBoolUnaryOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Enumerator lv_type_3_0 = null;

        EObject lv_operand_5_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1623:2: ( (otherlv_0= 'BoolUnaryOperation' otherlv_1= '{' (otherlv_2= 'type' ( (lv_type_3_0= ruleBoolUOp ) ) )? otherlv_4= 'operand' ( (lv_operand_5_0= ruleExpression ) ) otherlv_6= '}' ) )
            // InternalMyDsl.g:1624:2: (otherlv_0= 'BoolUnaryOperation' otherlv_1= '{' (otherlv_2= 'type' ( (lv_type_3_0= ruleBoolUOp ) ) )? otherlv_4= 'operand' ( (lv_operand_5_0= ruleExpression ) ) otherlv_6= '}' )
            {
            // InternalMyDsl.g:1624:2: (otherlv_0= 'BoolUnaryOperation' otherlv_1= '{' (otherlv_2= 'type' ( (lv_type_3_0= ruleBoolUOp ) ) )? otherlv_4= 'operand' ( (lv_operand_5_0= ruleExpression ) ) otherlv_6= '}' )
            // InternalMyDsl.g:1625:3: otherlv_0= 'BoolUnaryOperation' otherlv_1= '{' (otherlv_2= 'type' ( (lv_type_3_0= ruleBoolUOp ) ) )? otherlv_4= 'operand' ( (lv_operand_5_0= ruleExpression ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,47,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getBoolUnaryOperationAccess().getBoolUnaryOperationKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_34); 

            			newLeafNode(otherlv_1, grammarAccess.getBoolUnaryOperationAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalMyDsl.g:1633:3: (otherlv_2= 'type' ( (lv_type_3_0= ruleBoolUOp ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==17) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalMyDsl.g:1634:4: otherlv_2= 'type' ( (lv_type_3_0= ruleBoolUOp ) )
                    {
                    otherlv_2=(Token)match(input,17,FOLLOW_35); 

                    				newLeafNode(otherlv_2, grammarAccess.getBoolUnaryOperationAccess().getTypeKeyword_2_0());
                    			
                    // InternalMyDsl.g:1638:4: ( (lv_type_3_0= ruleBoolUOp ) )
                    // InternalMyDsl.g:1639:5: (lv_type_3_0= ruleBoolUOp )
                    {
                    // InternalMyDsl.g:1639:5: (lv_type_3_0= ruleBoolUOp )
                    // InternalMyDsl.g:1640:6: lv_type_3_0= ruleBoolUOp
                    {

                    						newCompositeNode(grammarAccess.getBoolUnaryOperationAccess().getTypeBoolUOpEnumRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_36);
                    lv_type_3_0=ruleBoolUOp();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getBoolUnaryOperationRule());
                    						}
                    						set(
                    							current,
                    							"type",
                    							lv_type_3_0,
                    							"org.xtext.example.mydsl.MyDsl.BoolUOp");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,48,FOLLOW_19); 

            			newLeafNode(otherlv_4, grammarAccess.getBoolUnaryOperationAccess().getOperandKeyword_3());
            		
            // InternalMyDsl.g:1662:3: ( (lv_operand_5_0= ruleExpression ) )
            // InternalMyDsl.g:1663:4: (lv_operand_5_0= ruleExpression )
            {
            // InternalMyDsl.g:1663:4: (lv_operand_5_0= ruleExpression )
            // InternalMyDsl.g:1664:5: lv_operand_5_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getBoolUnaryOperationAccess().getOperandExpressionParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_7);
            lv_operand_5_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBoolUnaryOperationRule());
            					}
            					set(
            						current,
            						"operand",
            						lv_operand_5_0,
            						"org.xtext.example.mydsl.MyDsl.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getBoolUnaryOperationAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBoolUnaryOperation"


    // $ANTLR start "entryRuleNumUnaryOperation"
    // InternalMyDsl.g:1689:1: entryRuleNumUnaryOperation returns [EObject current=null] : iv_ruleNumUnaryOperation= ruleNumUnaryOperation EOF ;
    public final EObject entryRuleNumUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumUnaryOperation = null;


        try {
            // InternalMyDsl.g:1689:58: (iv_ruleNumUnaryOperation= ruleNumUnaryOperation EOF )
            // InternalMyDsl.g:1690:2: iv_ruleNumUnaryOperation= ruleNumUnaryOperation EOF
            {
             newCompositeNode(grammarAccess.getNumUnaryOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumUnaryOperation=ruleNumUnaryOperation();

            state._fsp--;

             current =iv_ruleNumUnaryOperation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumUnaryOperation"


    // $ANTLR start "ruleNumUnaryOperation"
    // InternalMyDsl.g:1696:1: ruleNumUnaryOperation returns [EObject current=null] : (otherlv_0= 'NumUnaryOperation' otherlv_1= '{' (otherlv_2= 'type' ( (lv_type_3_0= ruleNumUOp ) ) )? otherlv_4= 'operand' ( (lv_operand_5_0= ruleExpression ) ) otherlv_6= '}' ) ;
    public final EObject ruleNumUnaryOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Enumerator lv_type_3_0 = null;

        EObject lv_operand_5_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1702:2: ( (otherlv_0= 'NumUnaryOperation' otherlv_1= '{' (otherlv_2= 'type' ( (lv_type_3_0= ruleNumUOp ) ) )? otherlv_4= 'operand' ( (lv_operand_5_0= ruleExpression ) ) otherlv_6= '}' ) )
            // InternalMyDsl.g:1703:2: (otherlv_0= 'NumUnaryOperation' otherlv_1= '{' (otherlv_2= 'type' ( (lv_type_3_0= ruleNumUOp ) ) )? otherlv_4= 'operand' ( (lv_operand_5_0= ruleExpression ) ) otherlv_6= '}' )
            {
            // InternalMyDsl.g:1703:2: (otherlv_0= 'NumUnaryOperation' otherlv_1= '{' (otherlv_2= 'type' ( (lv_type_3_0= ruleNumUOp ) ) )? otherlv_4= 'operand' ( (lv_operand_5_0= ruleExpression ) ) otherlv_6= '}' )
            // InternalMyDsl.g:1704:3: otherlv_0= 'NumUnaryOperation' otherlv_1= '{' (otherlv_2= 'type' ( (lv_type_3_0= ruleNumUOp ) ) )? otherlv_4= 'operand' ( (lv_operand_5_0= ruleExpression ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,49,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getNumUnaryOperationAccess().getNumUnaryOperationKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_34); 

            			newLeafNode(otherlv_1, grammarAccess.getNumUnaryOperationAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalMyDsl.g:1712:3: (otherlv_2= 'type' ( (lv_type_3_0= ruleNumUOp ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==17) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalMyDsl.g:1713:4: otherlv_2= 'type' ( (lv_type_3_0= ruleNumUOp ) )
                    {
                    otherlv_2=(Token)match(input,17,FOLLOW_37); 

                    				newLeafNode(otherlv_2, grammarAccess.getNumUnaryOperationAccess().getTypeKeyword_2_0());
                    			
                    // InternalMyDsl.g:1717:4: ( (lv_type_3_0= ruleNumUOp ) )
                    // InternalMyDsl.g:1718:5: (lv_type_3_0= ruleNumUOp )
                    {
                    // InternalMyDsl.g:1718:5: (lv_type_3_0= ruleNumUOp )
                    // InternalMyDsl.g:1719:6: lv_type_3_0= ruleNumUOp
                    {

                    						newCompositeNode(grammarAccess.getNumUnaryOperationAccess().getTypeNumUOpEnumRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_36);
                    lv_type_3_0=ruleNumUOp();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getNumUnaryOperationRule());
                    						}
                    						set(
                    							current,
                    							"type",
                    							lv_type_3_0,
                    							"org.xtext.example.mydsl.MyDsl.NumUOp");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,48,FOLLOW_19); 

            			newLeafNode(otherlv_4, grammarAccess.getNumUnaryOperationAccess().getOperandKeyword_3());
            		
            // InternalMyDsl.g:1741:3: ( (lv_operand_5_0= ruleExpression ) )
            // InternalMyDsl.g:1742:4: (lv_operand_5_0= ruleExpression )
            {
            // InternalMyDsl.g:1742:4: (lv_operand_5_0= ruleExpression )
            // InternalMyDsl.g:1743:5: lv_operand_5_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getNumUnaryOperationAccess().getOperandExpressionParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_7);
            lv_operand_5_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNumUnaryOperationRule());
            					}
            					set(
            						current,
            						"operand",
            						lv_operand_5_0,
            						"org.xtext.example.mydsl.MyDsl.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getNumUnaryOperationAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumUnaryOperation"


    // $ANTLR start "entryRuleBoolBinaryOperation"
    // InternalMyDsl.g:1768:1: entryRuleBoolBinaryOperation returns [EObject current=null] : iv_ruleBoolBinaryOperation= ruleBoolBinaryOperation EOF ;
    public final EObject entryRuleBoolBinaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolBinaryOperation = null;


        try {
            // InternalMyDsl.g:1768:60: (iv_ruleBoolBinaryOperation= ruleBoolBinaryOperation EOF )
            // InternalMyDsl.g:1769:2: iv_ruleBoolBinaryOperation= ruleBoolBinaryOperation EOF
            {
             newCompositeNode(grammarAccess.getBoolBinaryOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBoolBinaryOperation=ruleBoolBinaryOperation();

            state._fsp--;

             current =iv_ruleBoolBinaryOperation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBoolBinaryOperation"


    // $ANTLR start "ruleBoolBinaryOperation"
    // InternalMyDsl.g:1775:1: ruleBoolBinaryOperation returns [EObject current=null] : (otherlv_0= 'BoolBinaryOperation' otherlv_1= '{' (otherlv_2= 'type' ( (lv_type_3_0= ruleBoolBOp ) ) )? otherlv_4= 'operands' otherlv_5= '{' ( (lv_operands_6_0= ruleExpression ) ) (otherlv_7= ',' ( (lv_operands_8_0= ruleExpression ) ) )* otherlv_9= '}' otherlv_10= '}' ) ;
    public final EObject ruleBoolBinaryOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Enumerator lv_type_3_0 = null;

        EObject lv_operands_6_0 = null;

        EObject lv_operands_8_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1781:2: ( (otherlv_0= 'BoolBinaryOperation' otherlv_1= '{' (otherlv_2= 'type' ( (lv_type_3_0= ruleBoolBOp ) ) )? otherlv_4= 'operands' otherlv_5= '{' ( (lv_operands_6_0= ruleExpression ) ) (otherlv_7= ',' ( (lv_operands_8_0= ruleExpression ) ) )* otherlv_9= '}' otherlv_10= '}' ) )
            // InternalMyDsl.g:1782:2: (otherlv_0= 'BoolBinaryOperation' otherlv_1= '{' (otherlv_2= 'type' ( (lv_type_3_0= ruleBoolBOp ) ) )? otherlv_4= 'operands' otherlv_5= '{' ( (lv_operands_6_0= ruleExpression ) ) (otherlv_7= ',' ( (lv_operands_8_0= ruleExpression ) ) )* otherlv_9= '}' otherlv_10= '}' )
            {
            // InternalMyDsl.g:1782:2: (otherlv_0= 'BoolBinaryOperation' otherlv_1= '{' (otherlv_2= 'type' ( (lv_type_3_0= ruleBoolBOp ) ) )? otherlv_4= 'operands' otherlv_5= '{' ( (lv_operands_6_0= ruleExpression ) ) (otherlv_7= ',' ( (lv_operands_8_0= ruleExpression ) ) )* otherlv_9= '}' otherlv_10= '}' )
            // InternalMyDsl.g:1783:3: otherlv_0= 'BoolBinaryOperation' otherlv_1= '{' (otherlv_2= 'type' ( (lv_type_3_0= ruleBoolBOp ) ) )? otherlv_4= 'operands' otherlv_5= '{' ( (lv_operands_6_0= ruleExpression ) ) (otherlv_7= ',' ( (lv_operands_8_0= ruleExpression ) ) )* otherlv_9= '}' otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,50,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getBoolBinaryOperationAccess().getBoolBinaryOperationKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_38); 

            			newLeafNode(otherlv_1, grammarAccess.getBoolBinaryOperationAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalMyDsl.g:1791:3: (otherlv_2= 'type' ( (lv_type_3_0= ruleBoolBOp ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==17) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalMyDsl.g:1792:4: otherlv_2= 'type' ( (lv_type_3_0= ruleBoolBOp ) )
                    {
                    otherlv_2=(Token)match(input,17,FOLLOW_39); 

                    				newLeafNode(otherlv_2, grammarAccess.getBoolBinaryOperationAccess().getTypeKeyword_2_0());
                    			
                    // InternalMyDsl.g:1796:4: ( (lv_type_3_0= ruleBoolBOp ) )
                    // InternalMyDsl.g:1797:5: (lv_type_3_0= ruleBoolBOp )
                    {
                    // InternalMyDsl.g:1797:5: (lv_type_3_0= ruleBoolBOp )
                    // InternalMyDsl.g:1798:6: lv_type_3_0= ruleBoolBOp
                    {

                    						newCompositeNode(grammarAccess.getBoolBinaryOperationAccess().getTypeBoolBOpEnumRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_40);
                    lv_type_3_0=ruleBoolBOp();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getBoolBinaryOperationRule());
                    						}
                    						set(
                    							current,
                    							"type",
                    							lv_type_3_0,
                    							"org.xtext.example.mydsl.MyDsl.BoolBOp");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,51,FOLLOW_3); 

            			newLeafNode(otherlv_4, grammarAccess.getBoolBinaryOperationAccess().getOperandsKeyword_3());
            		
            otherlv_5=(Token)match(input,12,FOLLOW_19); 

            			newLeafNode(otherlv_5, grammarAccess.getBoolBinaryOperationAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalMyDsl.g:1824:3: ( (lv_operands_6_0= ruleExpression ) )
            // InternalMyDsl.g:1825:4: (lv_operands_6_0= ruleExpression )
            {
            // InternalMyDsl.g:1825:4: (lv_operands_6_0= ruleExpression )
            // InternalMyDsl.g:1826:5: lv_operands_6_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getBoolBinaryOperationAccess().getOperandsExpressionParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_6);
            lv_operands_6_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBoolBinaryOperationRule());
            					}
            					add(
            						current,
            						"operands",
            						lv_operands_6_0,
            						"org.xtext.example.mydsl.MyDsl.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:1843:3: (otherlv_7= ',' ( (lv_operands_8_0= ruleExpression ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==14) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalMyDsl.g:1844:4: otherlv_7= ',' ( (lv_operands_8_0= ruleExpression ) )
            	    {
            	    otherlv_7=(Token)match(input,14,FOLLOW_19); 

            	    				newLeafNode(otherlv_7, grammarAccess.getBoolBinaryOperationAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalMyDsl.g:1848:4: ( (lv_operands_8_0= ruleExpression ) )
            	    // InternalMyDsl.g:1849:5: (lv_operands_8_0= ruleExpression )
            	    {
            	    // InternalMyDsl.g:1849:5: (lv_operands_8_0= ruleExpression )
            	    // InternalMyDsl.g:1850:6: lv_operands_8_0= ruleExpression
            	    {

            	    						newCompositeNode(grammarAccess.getBoolBinaryOperationAccess().getOperandsExpressionParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_6);
            	    lv_operands_8_0=ruleExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getBoolBinaryOperationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"operands",
            	    							lv_operands_8_0,
            	    							"org.xtext.example.mydsl.MyDsl.Expression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            otherlv_9=(Token)match(input,15,FOLLOW_7); 

            			newLeafNode(otherlv_9, grammarAccess.getBoolBinaryOperationAccess().getRightCurlyBracketKeyword_7());
            		
            otherlv_10=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getBoolBinaryOperationAccess().getRightCurlyBracketKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBoolBinaryOperation"


    // $ANTLR start "entryRuleNumBinaryOperation"
    // InternalMyDsl.g:1880:1: entryRuleNumBinaryOperation returns [EObject current=null] : iv_ruleNumBinaryOperation= ruleNumBinaryOperation EOF ;
    public final EObject entryRuleNumBinaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumBinaryOperation = null;


        try {
            // InternalMyDsl.g:1880:59: (iv_ruleNumBinaryOperation= ruleNumBinaryOperation EOF )
            // InternalMyDsl.g:1881:2: iv_ruleNumBinaryOperation= ruleNumBinaryOperation EOF
            {
             newCompositeNode(grammarAccess.getNumBinaryOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumBinaryOperation=ruleNumBinaryOperation();

            state._fsp--;

             current =iv_ruleNumBinaryOperation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumBinaryOperation"


    // $ANTLR start "ruleNumBinaryOperation"
    // InternalMyDsl.g:1887:1: ruleNumBinaryOperation returns [EObject current=null] : (otherlv_0= 'NumBinaryOperation' otherlv_1= '{' (otherlv_2= 'type' ( (lv_type_3_0= ruleNumBOp ) ) )? otherlv_4= 'operands' otherlv_5= '{' ( (lv_operands_6_0= ruleExpression ) ) (otherlv_7= ',' ( (lv_operands_8_0= ruleExpression ) ) )* otherlv_9= '}' otherlv_10= '}' ) ;
    public final EObject ruleNumBinaryOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Enumerator lv_type_3_0 = null;

        EObject lv_operands_6_0 = null;

        EObject lv_operands_8_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1893:2: ( (otherlv_0= 'NumBinaryOperation' otherlv_1= '{' (otherlv_2= 'type' ( (lv_type_3_0= ruleNumBOp ) ) )? otherlv_4= 'operands' otherlv_5= '{' ( (lv_operands_6_0= ruleExpression ) ) (otherlv_7= ',' ( (lv_operands_8_0= ruleExpression ) ) )* otherlv_9= '}' otherlv_10= '}' ) )
            // InternalMyDsl.g:1894:2: (otherlv_0= 'NumBinaryOperation' otherlv_1= '{' (otherlv_2= 'type' ( (lv_type_3_0= ruleNumBOp ) ) )? otherlv_4= 'operands' otherlv_5= '{' ( (lv_operands_6_0= ruleExpression ) ) (otherlv_7= ',' ( (lv_operands_8_0= ruleExpression ) ) )* otherlv_9= '}' otherlv_10= '}' )
            {
            // InternalMyDsl.g:1894:2: (otherlv_0= 'NumBinaryOperation' otherlv_1= '{' (otherlv_2= 'type' ( (lv_type_3_0= ruleNumBOp ) ) )? otherlv_4= 'operands' otherlv_5= '{' ( (lv_operands_6_0= ruleExpression ) ) (otherlv_7= ',' ( (lv_operands_8_0= ruleExpression ) ) )* otherlv_9= '}' otherlv_10= '}' )
            // InternalMyDsl.g:1895:3: otherlv_0= 'NumBinaryOperation' otherlv_1= '{' (otherlv_2= 'type' ( (lv_type_3_0= ruleNumBOp ) ) )? otherlv_4= 'operands' otherlv_5= '{' ( (lv_operands_6_0= ruleExpression ) ) (otherlv_7= ',' ( (lv_operands_8_0= ruleExpression ) ) )* otherlv_9= '}' otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,52,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getNumBinaryOperationAccess().getNumBinaryOperationKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_38); 

            			newLeafNode(otherlv_1, grammarAccess.getNumBinaryOperationAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalMyDsl.g:1903:3: (otherlv_2= 'type' ( (lv_type_3_0= ruleNumBOp ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==17) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalMyDsl.g:1904:4: otherlv_2= 'type' ( (lv_type_3_0= ruleNumBOp ) )
                    {
                    otherlv_2=(Token)match(input,17,FOLLOW_41); 

                    				newLeafNode(otherlv_2, grammarAccess.getNumBinaryOperationAccess().getTypeKeyword_2_0());
                    			
                    // InternalMyDsl.g:1908:4: ( (lv_type_3_0= ruleNumBOp ) )
                    // InternalMyDsl.g:1909:5: (lv_type_3_0= ruleNumBOp )
                    {
                    // InternalMyDsl.g:1909:5: (lv_type_3_0= ruleNumBOp )
                    // InternalMyDsl.g:1910:6: lv_type_3_0= ruleNumBOp
                    {

                    						newCompositeNode(grammarAccess.getNumBinaryOperationAccess().getTypeNumBOpEnumRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_40);
                    lv_type_3_0=ruleNumBOp();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getNumBinaryOperationRule());
                    						}
                    						set(
                    							current,
                    							"type",
                    							lv_type_3_0,
                    							"org.xtext.example.mydsl.MyDsl.NumBOp");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,51,FOLLOW_3); 

            			newLeafNode(otherlv_4, grammarAccess.getNumBinaryOperationAccess().getOperandsKeyword_3());
            		
            otherlv_5=(Token)match(input,12,FOLLOW_19); 

            			newLeafNode(otherlv_5, grammarAccess.getNumBinaryOperationAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalMyDsl.g:1936:3: ( (lv_operands_6_0= ruleExpression ) )
            // InternalMyDsl.g:1937:4: (lv_operands_6_0= ruleExpression )
            {
            // InternalMyDsl.g:1937:4: (lv_operands_6_0= ruleExpression )
            // InternalMyDsl.g:1938:5: lv_operands_6_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getNumBinaryOperationAccess().getOperandsExpressionParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_6);
            lv_operands_6_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNumBinaryOperationRule());
            					}
            					add(
            						current,
            						"operands",
            						lv_operands_6_0,
            						"org.xtext.example.mydsl.MyDsl.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:1955:3: (otherlv_7= ',' ( (lv_operands_8_0= ruleExpression ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==14) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalMyDsl.g:1956:4: otherlv_7= ',' ( (lv_operands_8_0= ruleExpression ) )
            	    {
            	    otherlv_7=(Token)match(input,14,FOLLOW_19); 

            	    				newLeafNode(otherlv_7, grammarAccess.getNumBinaryOperationAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalMyDsl.g:1960:4: ( (lv_operands_8_0= ruleExpression ) )
            	    // InternalMyDsl.g:1961:5: (lv_operands_8_0= ruleExpression )
            	    {
            	    // InternalMyDsl.g:1961:5: (lv_operands_8_0= ruleExpression )
            	    // InternalMyDsl.g:1962:6: lv_operands_8_0= ruleExpression
            	    {

            	    						newCompositeNode(grammarAccess.getNumBinaryOperationAccess().getOperandsExpressionParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_6);
            	    lv_operands_8_0=ruleExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getNumBinaryOperationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"operands",
            	    							lv_operands_8_0,
            	    							"org.xtext.example.mydsl.MyDsl.Expression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            otherlv_9=(Token)match(input,15,FOLLOW_7); 

            			newLeafNode(otherlv_9, grammarAccess.getNumBinaryOperationAccess().getRightCurlyBracketKeyword_7());
            		
            otherlv_10=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getNumBinaryOperationAccess().getRightCurlyBracketKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumBinaryOperation"


    // $ANTLR start "entryRuleSensorAccess"
    // InternalMyDsl.g:1992:1: entryRuleSensorAccess returns [EObject current=null] : iv_ruleSensorAccess= ruleSensorAccess EOF ;
    public final EObject entryRuleSensorAccess() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSensorAccess = null;


        try {
            // InternalMyDsl.g:1992:53: (iv_ruleSensorAccess= ruleSensorAccess EOF )
            // InternalMyDsl.g:1993:2: iv_ruleSensorAccess= ruleSensorAccess EOF
            {
             newCompositeNode(grammarAccess.getSensorAccessRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSensorAccess=ruleSensorAccess();

            state._fsp--;

             current =iv_ruleSensorAccess; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSensorAccess"


    // $ANTLR start "ruleSensorAccess"
    // InternalMyDsl.g:1999:1: ruleSensorAccess returns [EObject current=null] : ( () otherlv_1= 'SensorAccess' otherlv_2= '{' (otherlv_3= 'sensorType' ( (lv_sensorType_4_0= ruleSensorType ) ) )? otherlv_5= '}' ) ;
    public final EObject ruleSensorAccess() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Enumerator lv_sensorType_4_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2005:2: ( ( () otherlv_1= 'SensorAccess' otherlv_2= '{' (otherlv_3= 'sensorType' ( (lv_sensorType_4_0= ruleSensorType ) ) )? otherlv_5= '}' ) )
            // InternalMyDsl.g:2006:2: ( () otherlv_1= 'SensorAccess' otherlv_2= '{' (otherlv_3= 'sensorType' ( (lv_sensorType_4_0= ruleSensorType ) ) )? otherlv_5= '}' )
            {
            // InternalMyDsl.g:2006:2: ( () otherlv_1= 'SensorAccess' otherlv_2= '{' (otherlv_3= 'sensorType' ( (lv_sensorType_4_0= ruleSensorType ) ) )? otherlv_5= '}' )
            // InternalMyDsl.g:2007:3: () otherlv_1= 'SensorAccess' otherlv_2= '{' (otherlv_3= 'sensorType' ( (lv_sensorType_4_0= ruleSensorType ) ) )? otherlv_5= '}'
            {
            // InternalMyDsl.g:2007:3: ()
            // InternalMyDsl.g:2008:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSensorAccessAccess().getSensorAccessAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,53,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getSensorAccessAccess().getSensorAccessKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_42); 

            			newLeafNode(otherlv_2, grammarAccess.getSensorAccessAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:2022:3: (otherlv_3= 'sensorType' ( (lv_sensorType_4_0= ruleSensorType ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==54) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalMyDsl.g:2023:4: otherlv_3= 'sensorType' ( (lv_sensorType_4_0= ruleSensorType ) )
                    {
                    otherlv_3=(Token)match(input,54,FOLLOW_43); 

                    				newLeafNode(otherlv_3, grammarAccess.getSensorAccessAccess().getSensorTypeKeyword_3_0());
                    			
                    // InternalMyDsl.g:2027:4: ( (lv_sensorType_4_0= ruleSensorType ) )
                    // InternalMyDsl.g:2028:5: (lv_sensorType_4_0= ruleSensorType )
                    {
                    // InternalMyDsl.g:2028:5: (lv_sensorType_4_0= ruleSensorType )
                    // InternalMyDsl.g:2029:6: lv_sensorType_4_0= ruleSensorType
                    {

                    						newCompositeNode(grammarAccess.getSensorAccessAccess().getSensorTypeSensorTypeEnumRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_sensorType_4_0=ruleSensorType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSensorAccessRule());
                    						}
                    						set(
                    							current,
                    							"sensorType",
                    							lv_sensorType_4_0,
                    							"org.xtext.example.mydsl.MyDsl.SensorType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getSensorAccessAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSensorAccess"


    // $ANTLR start "entryRuleEInt"
    // InternalMyDsl.g:2055:1: entryRuleEInt returns [String current=null] : iv_ruleEInt= ruleEInt EOF ;
    public final String entryRuleEInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEInt = null;


        try {
            // InternalMyDsl.g:2055:44: (iv_ruleEInt= ruleEInt EOF )
            // InternalMyDsl.g:2056:2: iv_ruleEInt= ruleEInt EOF
            {
             newCompositeNode(grammarAccess.getEIntRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEInt=ruleEInt();

            state._fsp--;

             current =iv_ruleEInt.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEInt"


    // $ANTLR start "ruleEInt"
    // InternalMyDsl.g:2062:1: ruleEInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;


        	enterRule();

        try {
            // InternalMyDsl.g:2068:2: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // InternalMyDsl.g:2069:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // InternalMyDsl.g:2069:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            // InternalMyDsl.g:2070:3: (kw= '-' )? this_INT_1= RULE_INT
            {
            // InternalMyDsl.g:2070:3: (kw= '-' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==55) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalMyDsl.g:2071:4: kw= '-'
                    {
                    kw=(Token)match(input,55,FOLLOW_44); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEIntAccess().getHyphenMinusKeyword_0());
                    			

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_2); 

            			current.merge(this_INT_1);
            		

            			newLeafNode(this_INT_1, grammarAccess.getEIntAccess().getINTTerminalRuleCall_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEInt"


    // $ANTLR start "ruleUnit"
    // InternalMyDsl.g:2088:1: ruleUnit returns [Enumerator current=null] : ( (enumLiteral_0= 'cm' ) | (enumLiteral_1= 'mm' ) | (enumLiteral_2= 'none' ) | (enumLiteral_3= 'deg' ) | (enumLiteral_4= 'rad' ) ) ;
    public final Enumerator ruleUnit() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalMyDsl.g:2094:2: ( ( (enumLiteral_0= 'cm' ) | (enumLiteral_1= 'mm' ) | (enumLiteral_2= 'none' ) | (enumLiteral_3= 'deg' ) | (enumLiteral_4= 'rad' ) ) )
            // InternalMyDsl.g:2095:2: ( (enumLiteral_0= 'cm' ) | (enumLiteral_1= 'mm' ) | (enumLiteral_2= 'none' ) | (enumLiteral_3= 'deg' ) | (enumLiteral_4= 'rad' ) )
            {
            // InternalMyDsl.g:2095:2: ( (enumLiteral_0= 'cm' ) | (enumLiteral_1= 'mm' ) | (enumLiteral_2= 'none' ) | (enumLiteral_3= 'deg' ) | (enumLiteral_4= 'rad' ) )
            int alt27=5;
            switch ( input.LA(1) ) {
            case 56:
                {
                alt27=1;
                }
                break;
            case 57:
                {
                alt27=2;
                }
                break;
            case 58:
                {
                alt27=3;
                }
                break;
            case 59:
                {
                alt27=4;
                }
                break;
            case 60:
                {
                alt27=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // InternalMyDsl.g:2096:3: (enumLiteral_0= 'cm' )
                    {
                    // InternalMyDsl.g:2096:3: (enumLiteral_0= 'cm' )
                    // InternalMyDsl.g:2097:4: enumLiteral_0= 'cm'
                    {
                    enumLiteral_0=(Token)match(input,56,FOLLOW_2); 

                    				current = grammarAccess.getUnitAccess().getCmEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getUnitAccess().getCmEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:2104:3: (enumLiteral_1= 'mm' )
                    {
                    // InternalMyDsl.g:2104:3: (enumLiteral_1= 'mm' )
                    // InternalMyDsl.g:2105:4: enumLiteral_1= 'mm'
                    {
                    enumLiteral_1=(Token)match(input,57,FOLLOW_2); 

                    				current = grammarAccess.getUnitAccess().getMmEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getUnitAccess().getMmEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:2112:3: (enumLiteral_2= 'none' )
                    {
                    // InternalMyDsl.g:2112:3: (enumLiteral_2= 'none' )
                    // InternalMyDsl.g:2113:4: enumLiteral_2= 'none'
                    {
                    enumLiteral_2=(Token)match(input,58,FOLLOW_2); 

                    				current = grammarAccess.getUnitAccess().getNoneEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getUnitAccess().getNoneEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:2120:3: (enumLiteral_3= 'deg' )
                    {
                    // InternalMyDsl.g:2120:3: (enumLiteral_3= 'deg' )
                    // InternalMyDsl.g:2121:4: enumLiteral_3= 'deg'
                    {
                    enumLiteral_3=(Token)match(input,59,FOLLOW_2); 

                    				current = grammarAccess.getUnitAccess().getDegEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getUnitAccess().getDegEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:2128:3: (enumLiteral_4= 'rad' )
                    {
                    // InternalMyDsl.g:2128:3: (enumLiteral_4= 'rad' )
                    // InternalMyDsl.g:2129:4: enumLiteral_4= 'rad'
                    {
                    enumLiteral_4=(Token)match(input,60,FOLLOW_2); 

                    				current = grammarAccess.getUnitAccess().getRadEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getUnitAccess().getRadEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnit"


    // $ANTLR start "ruleBoolUOp"
    // InternalMyDsl.g:2139:1: ruleBoolUOp returns [Enumerator current=null] : (enumLiteral_0= 'NOT' ) ;
    public final Enumerator ruleBoolUOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;


        	enterRule();

        try {
            // InternalMyDsl.g:2145:2: ( (enumLiteral_0= 'NOT' ) )
            // InternalMyDsl.g:2146:2: (enumLiteral_0= 'NOT' )
            {
            // InternalMyDsl.g:2146:2: (enumLiteral_0= 'NOT' )
            // InternalMyDsl.g:2147:3: enumLiteral_0= 'NOT'
            {
            enumLiteral_0=(Token)match(input,61,FOLLOW_2); 

            			current = grammarAccess.getBoolUOpAccess().getNOTEnumLiteralDeclaration().getEnumLiteral().getInstance();
            			newLeafNode(enumLiteral_0, grammarAccess.getBoolUOpAccess().getNOTEnumLiteralDeclaration());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBoolUOp"


    // $ANTLR start "ruleNumUOp"
    // InternalMyDsl.g:2156:1: ruleNumUOp returns [Enumerator current=null] : ( (enumLiteral_0= 'MINUS' ) | (enumLiteral_1= 'PLUS' ) ) ;
    public final Enumerator ruleNumUOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalMyDsl.g:2162:2: ( ( (enumLiteral_0= 'MINUS' ) | (enumLiteral_1= 'PLUS' ) ) )
            // InternalMyDsl.g:2163:2: ( (enumLiteral_0= 'MINUS' ) | (enumLiteral_1= 'PLUS' ) )
            {
            // InternalMyDsl.g:2163:2: ( (enumLiteral_0= 'MINUS' ) | (enumLiteral_1= 'PLUS' ) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==62) ) {
                alt28=1;
            }
            else if ( (LA28_0==63) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // InternalMyDsl.g:2164:3: (enumLiteral_0= 'MINUS' )
                    {
                    // InternalMyDsl.g:2164:3: (enumLiteral_0= 'MINUS' )
                    // InternalMyDsl.g:2165:4: enumLiteral_0= 'MINUS'
                    {
                    enumLiteral_0=(Token)match(input,62,FOLLOW_2); 

                    				current = grammarAccess.getNumUOpAccess().getMINUSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getNumUOpAccess().getMINUSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:2172:3: (enumLiteral_1= 'PLUS' )
                    {
                    // InternalMyDsl.g:2172:3: (enumLiteral_1= 'PLUS' )
                    // InternalMyDsl.g:2173:4: enumLiteral_1= 'PLUS'
                    {
                    enumLiteral_1=(Token)match(input,63,FOLLOW_2); 

                    				current = grammarAccess.getNumUOpAccess().getPLUSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getNumUOpAccess().getPLUSEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumUOp"


    // $ANTLR start "ruleBoolBOp"
    // InternalMyDsl.g:2183:1: ruleBoolBOp returns [Enumerator current=null] : ( (enumLiteral_0= 'EQ' ) | (enumLiteral_1= 'NEQ' ) | (enumLiteral_2= 'LEQ' ) | (enumLiteral_3= 'GEQ' ) | (enumLiteral_4= 'LE' ) | (enumLiteral_5= 'GR' ) ) ;
    public final Enumerator ruleBoolBOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;


        	enterRule();

        try {
            // InternalMyDsl.g:2189:2: ( ( (enumLiteral_0= 'EQ' ) | (enumLiteral_1= 'NEQ' ) | (enumLiteral_2= 'LEQ' ) | (enumLiteral_3= 'GEQ' ) | (enumLiteral_4= 'LE' ) | (enumLiteral_5= 'GR' ) ) )
            // InternalMyDsl.g:2190:2: ( (enumLiteral_0= 'EQ' ) | (enumLiteral_1= 'NEQ' ) | (enumLiteral_2= 'LEQ' ) | (enumLiteral_3= 'GEQ' ) | (enumLiteral_4= 'LE' ) | (enumLiteral_5= 'GR' ) )
            {
            // InternalMyDsl.g:2190:2: ( (enumLiteral_0= 'EQ' ) | (enumLiteral_1= 'NEQ' ) | (enumLiteral_2= 'LEQ' ) | (enumLiteral_3= 'GEQ' ) | (enumLiteral_4= 'LE' ) | (enumLiteral_5= 'GR' ) )
            int alt29=6;
            switch ( input.LA(1) ) {
            case 64:
                {
                alt29=1;
                }
                break;
            case 65:
                {
                alt29=2;
                }
                break;
            case 66:
                {
                alt29=3;
                }
                break;
            case 67:
                {
                alt29=4;
                }
                break;
            case 68:
                {
                alt29=5;
                }
                break;
            case 69:
                {
                alt29=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // InternalMyDsl.g:2191:3: (enumLiteral_0= 'EQ' )
                    {
                    // InternalMyDsl.g:2191:3: (enumLiteral_0= 'EQ' )
                    // InternalMyDsl.g:2192:4: enumLiteral_0= 'EQ'
                    {
                    enumLiteral_0=(Token)match(input,64,FOLLOW_2); 

                    				current = grammarAccess.getBoolBOpAccess().getEQEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getBoolBOpAccess().getEQEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:2199:3: (enumLiteral_1= 'NEQ' )
                    {
                    // InternalMyDsl.g:2199:3: (enumLiteral_1= 'NEQ' )
                    // InternalMyDsl.g:2200:4: enumLiteral_1= 'NEQ'
                    {
                    enumLiteral_1=(Token)match(input,65,FOLLOW_2); 

                    				current = grammarAccess.getBoolBOpAccess().getNEQEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getBoolBOpAccess().getNEQEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:2207:3: (enumLiteral_2= 'LEQ' )
                    {
                    // InternalMyDsl.g:2207:3: (enumLiteral_2= 'LEQ' )
                    // InternalMyDsl.g:2208:4: enumLiteral_2= 'LEQ'
                    {
                    enumLiteral_2=(Token)match(input,66,FOLLOW_2); 

                    				current = grammarAccess.getBoolBOpAccess().getLEQEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getBoolBOpAccess().getLEQEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:2215:3: (enumLiteral_3= 'GEQ' )
                    {
                    // InternalMyDsl.g:2215:3: (enumLiteral_3= 'GEQ' )
                    // InternalMyDsl.g:2216:4: enumLiteral_3= 'GEQ'
                    {
                    enumLiteral_3=(Token)match(input,67,FOLLOW_2); 

                    				current = grammarAccess.getBoolBOpAccess().getGEQEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getBoolBOpAccess().getGEQEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:2223:3: (enumLiteral_4= 'LE' )
                    {
                    // InternalMyDsl.g:2223:3: (enumLiteral_4= 'LE' )
                    // InternalMyDsl.g:2224:4: enumLiteral_4= 'LE'
                    {
                    enumLiteral_4=(Token)match(input,68,FOLLOW_2); 

                    				current = grammarAccess.getBoolBOpAccess().getLEEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getBoolBOpAccess().getLEEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalMyDsl.g:2231:3: (enumLiteral_5= 'GR' )
                    {
                    // InternalMyDsl.g:2231:3: (enumLiteral_5= 'GR' )
                    // InternalMyDsl.g:2232:4: enumLiteral_5= 'GR'
                    {
                    enumLiteral_5=(Token)match(input,69,FOLLOW_2); 

                    				current = grammarAccess.getBoolBOpAccess().getGREnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getBoolBOpAccess().getGREnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBoolBOp"


    // $ANTLR start "ruleNumBOp"
    // InternalMyDsl.g:2242:1: ruleNumBOp returns [Enumerator current=null] : ( (enumLiteral_0= 'MINUS' ) | (enumLiteral_1= 'PLUS' ) | (enumLiteral_2= 'MULTIPLY' ) | (enumLiteral_3= 'DIVIDE' ) ) ;
    public final Enumerator ruleNumBOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalMyDsl.g:2248:2: ( ( (enumLiteral_0= 'MINUS' ) | (enumLiteral_1= 'PLUS' ) | (enumLiteral_2= 'MULTIPLY' ) | (enumLiteral_3= 'DIVIDE' ) ) )
            // InternalMyDsl.g:2249:2: ( (enumLiteral_0= 'MINUS' ) | (enumLiteral_1= 'PLUS' ) | (enumLiteral_2= 'MULTIPLY' ) | (enumLiteral_3= 'DIVIDE' ) )
            {
            // InternalMyDsl.g:2249:2: ( (enumLiteral_0= 'MINUS' ) | (enumLiteral_1= 'PLUS' ) | (enumLiteral_2= 'MULTIPLY' ) | (enumLiteral_3= 'DIVIDE' ) )
            int alt30=4;
            switch ( input.LA(1) ) {
            case 62:
                {
                alt30=1;
                }
                break;
            case 63:
                {
                alt30=2;
                }
                break;
            case 70:
                {
                alt30=3;
                }
                break;
            case 71:
                {
                alt30=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // InternalMyDsl.g:2250:3: (enumLiteral_0= 'MINUS' )
                    {
                    // InternalMyDsl.g:2250:3: (enumLiteral_0= 'MINUS' )
                    // InternalMyDsl.g:2251:4: enumLiteral_0= 'MINUS'
                    {
                    enumLiteral_0=(Token)match(input,62,FOLLOW_2); 

                    				current = grammarAccess.getNumBOpAccess().getMINUSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getNumBOpAccess().getMINUSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:2258:3: (enumLiteral_1= 'PLUS' )
                    {
                    // InternalMyDsl.g:2258:3: (enumLiteral_1= 'PLUS' )
                    // InternalMyDsl.g:2259:4: enumLiteral_1= 'PLUS'
                    {
                    enumLiteral_1=(Token)match(input,63,FOLLOW_2); 

                    				current = grammarAccess.getNumBOpAccess().getPLUSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getNumBOpAccess().getPLUSEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:2266:3: (enumLiteral_2= 'MULTIPLY' )
                    {
                    // InternalMyDsl.g:2266:3: (enumLiteral_2= 'MULTIPLY' )
                    // InternalMyDsl.g:2267:4: enumLiteral_2= 'MULTIPLY'
                    {
                    enumLiteral_2=(Token)match(input,70,FOLLOW_2); 

                    				current = grammarAccess.getNumBOpAccess().getMULTIPLYEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getNumBOpAccess().getMULTIPLYEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:2274:3: (enumLiteral_3= 'DIVIDE' )
                    {
                    // InternalMyDsl.g:2274:3: (enumLiteral_3= 'DIVIDE' )
                    // InternalMyDsl.g:2275:4: enumLiteral_3= 'DIVIDE'
                    {
                    enumLiteral_3=(Token)match(input,71,FOLLOW_2); 

                    				current = grammarAccess.getNumBOpAccess().getDIVIDEEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getNumBOpAccess().getDIVIDEEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumBOp"


    // $ANTLR start "ruleSensorType"
    // InternalMyDsl.g:2285:1: ruleSensorType returns [Enumerator current=null] : ( (enumLiteral_0= 'Distance' ) | (enumLiteral_1= 'Time' ) | (enumLiteral_2= 'Battery' ) ) ;
    public final Enumerator ruleSensorType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalMyDsl.g:2291:2: ( ( (enumLiteral_0= 'Distance' ) | (enumLiteral_1= 'Time' ) | (enumLiteral_2= 'Battery' ) ) )
            // InternalMyDsl.g:2292:2: ( (enumLiteral_0= 'Distance' ) | (enumLiteral_1= 'Time' ) | (enumLiteral_2= 'Battery' ) )
            {
            // InternalMyDsl.g:2292:2: ( (enumLiteral_0= 'Distance' ) | (enumLiteral_1= 'Time' ) | (enumLiteral_2= 'Battery' ) )
            int alt31=3;
            switch ( input.LA(1) ) {
            case 72:
                {
                alt31=1;
                }
                break;
            case 73:
                {
                alt31=2;
                }
                break;
            case 74:
                {
                alt31=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // InternalMyDsl.g:2293:3: (enumLiteral_0= 'Distance' )
                    {
                    // InternalMyDsl.g:2293:3: (enumLiteral_0= 'Distance' )
                    // InternalMyDsl.g:2294:4: enumLiteral_0= 'Distance'
                    {
                    enumLiteral_0=(Token)match(input,72,FOLLOW_2); 

                    				current = grammarAccess.getSensorTypeAccess().getDistanceEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getSensorTypeAccess().getDistanceEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:2301:3: (enumLiteral_1= 'Time' )
                    {
                    // InternalMyDsl.g:2301:3: (enumLiteral_1= 'Time' )
                    // InternalMyDsl.g:2302:4: enumLiteral_1= 'Time'
                    {
                    enumLiteral_1=(Token)match(input,73,FOLLOW_2); 

                    				current = grammarAccess.getSensorTypeAccess().getTimeEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getSensorTypeAccess().getTimeEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:2309:3: (enumLiteral_2= 'Battery' )
                    {
                    // InternalMyDsl.g:2309:3: (enumLiteral_2= 'Battery' )
                    // InternalMyDsl.g:2310:4: enumLiteral_2= 'Battery'
                    {
                    enumLiteral_2=(Token)match(input,74,FOLLOW_2); 

                    				current = grammarAccess.getSensorTypeAccess().getBatteryEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getSensorTypeAccess().getBatteryEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSensorType"


    // $ANTLR start "ruleDirection"
    // InternalMyDsl.g:2320:1: ruleDirection returns [Enumerator current=null] : ( (enumLiteral_0= 'Backward' ) | (enumLiteral_1= 'Forward' ) | (enumLiteral_2= 'Sideleft' ) | (enumLiteral_3= 'Sideright' ) ) ;
    public final Enumerator ruleDirection() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalMyDsl.g:2326:2: ( ( (enumLiteral_0= 'Backward' ) | (enumLiteral_1= 'Forward' ) | (enumLiteral_2= 'Sideleft' ) | (enumLiteral_3= 'Sideright' ) ) )
            // InternalMyDsl.g:2327:2: ( (enumLiteral_0= 'Backward' ) | (enumLiteral_1= 'Forward' ) | (enumLiteral_2= 'Sideleft' ) | (enumLiteral_3= 'Sideright' ) )
            {
            // InternalMyDsl.g:2327:2: ( (enumLiteral_0= 'Backward' ) | (enumLiteral_1= 'Forward' ) | (enumLiteral_2= 'Sideleft' ) | (enumLiteral_3= 'Sideright' ) )
            int alt32=4;
            switch ( input.LA(1) ) {
            case 75:
                {
                alt32=1;
                }
                break;
            case 76:
                {
                alt32=2;
                }
                break;
            case 77:
                {
                alt32=3;
                }
                break;
            case 78:
                {
                alt32=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // InternalMyDsl.g:2328:3: (enumLiteral_0= 'Backward' )
                    {
                    // InternalMyDsl.g:2328:3: (enumLiteral_0= 'Backward' )
                    // InternalMyDsl.g:2329:4: enumLiteral_0= 'Backward'
                    {
                    enumLiteral_0=(Token)match(input,75,FOLLOW_2); 

                    				current = grammarAccess.getDirectionAccess().getBackwardEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDirectionAccess().getBackwardEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:2336:3: (enumLiteral_1= 'Forward' )
                    {
                    // InternalMyDsl.g:2336:3: (enumLiteral_1= 'Forward' )
                    // InternalMyDsl.g:2337:4: enumLiteral_1= 'Forward'
                    {
                    enumLiteral_1=(Token)match(input,76,FOLLOW_2); 

                    				current = grammarAccess.getDirectionAccess().getForwardEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDirectionAccess().getForwardEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:2344:3: (enumLiteral_2= 'Sideleft' )
                    {
                    // InternalMyDsl.g:2344:3: (enumLiteral_2= 'Sideleft' )
                    // InternalMyDsl.g:2345:4: enumLiteral_2= 'Sideleft'
                    {
                    enumLiteral_2=(Token)match(input,77,FOLLOW_2); 

                    				current = grammarAccess.getDirectionAccess().getSideleftEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDirectionAccess().getSideleftEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:2352:3: (enumLiteral_3= 'Sideright' )
                    {
                    // InternalMyDsl.g:2352:3: (enumLiteral_3= 'Sideright' )
                    // InternalMyDsl.g:2353:4: enumLiteral_3= 'Sideright'
                    {
                    enumLiteral_3=(Token)match(input,78,FOLLOW_2); 

                    				current = grammarAccess.getDirectionAccess().getSiderightEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getDirectionAccess().getSiderightEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDirection"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x000000000000A000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000001600000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000025666000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000808000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x1F00000000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0036F80002000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000010008000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000180000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000000L,0x0000000000007800L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000010000008000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000008008000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000100000008000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0080000000000040L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0001000000020000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0xC000000000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0008000000020000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000000L,0x000000000000003FL});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0xC000000000000000L,0x00000000000000C0L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0040000000008000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000700L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000040L});

}