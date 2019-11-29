// Generated from Calculette.g4 by ANTLR 4.7.2



	import java.util.HashMap;
	import java.util.Scanner;  // Import the Scanner class
	
	
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalculetteParser}.
 */
public interface CalculetteListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(CalculetteParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(CalculetteParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#calcul}.
	 * @param ctx the parse tree
	 */
	void enterCalcul(CalculetteParser.CalculContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#calcul}.
	 * @param ctx the parse tree
	 */
	void exitCalcul(CalculetteParser.CalculContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(CalculetteParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(CalculetteParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(CalculetteParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(CalculetteParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#entrSorti}.
	 * @param ctx the parse tree
	 */
	void enterEntrSorti(CalculetteParser.EntrSortiContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#entrSorti}.
	 * @param ctx the parse tree
	 */
	void exitEntrSorti(CalculetteParser.EntrSortiContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(CalculetteParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(CalculetteParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#exprFloat}.
	 * @param ctx the parse tree
	 */
	void enterExprFloat(CalculetteParser.ExprFloatContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#exprFloat}.
	 * @param ctx the parse tree
	 */
	void exitExprFloat(CalculetteParser.ExprFloatContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#exprBoolean}.
	 * @param ctx the parse tree
	 */
	void enterExprBoolean(CalculetteParser.ExprBooleanContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#exprBoolean}.
	 * @param ctx the parse tree
	 */
	void exitExprBoolean(CalculetteParser.ExprBooleanContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#assignation}.
	 * @param ctx the parse tree
	 */
	void enterAssignation(CalculetteParser.AssignationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#assignation}.
	 * @param ctx the parse tree
	 */
	void exitAssignation(CalculetteParser.AssignationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#bloc}.
	 * @param ctx the parse tree
	 */
	void enterBloc(CalculetteParser.BlocContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#bloc}.
	 * @param ctx the parse tree
	 */
	void exitBloc(CalculetteParser.BlocContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#blocFonction}.
	 * @param ctx the parse tree
	 */
	void enterBlocFonction(CalculetteParser.BlocFonctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#blocFonction}.
	 * @param ctx the parse tree
	 */
	void exitBlocFonction(CalculetteParser.BlocFonctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(CalculetteParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(CalculetteParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#fonction}.
	 * @param ctx the parse tree
	 */
	void enterFonction(CalculetteParser.FonctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#fonction}.
	 * @param ctx the parse tree
	 */
	void exitFonction(CalculetteParser.FonctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(CalculetteParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(CalculetteParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(CalculetteParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(CalculetteParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#finInstruction}.
	 * @param ctx the parse tree
	 */
	void enterFinInstruction(CalculetteParser.FinInstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#finInstruction}.
	 * @param ctx the parse tree
	 */
	void exitFinInstruction(CalculetteParser.FinInstructionContext ctx);
}